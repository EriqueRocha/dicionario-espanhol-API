package com.dicionarioespanholAPI.controller;

import com.dicionarioespanholAPI.infra.handler.Response;
import com.dicionarioespanholAPI.infra.handler.ResponseFactory;
import com.dicionarioespanholAPI.infra.security.jwt.JwtProperties;
import com.dicionarioespanholAPI.model.manager.ManagerRequest;
import com.dicionarioespanholAPI.repository.ManagerRepository;
import com.dicionarioespanholAPI.service.ManagerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private ManagerService service;

    @Autowired
    private ManagerRepository repository;


    @PostMapping("/adicionar")
    public Response save(@RequestHeader("Authorization") String authorizationHeader,@RequestBody ManagerRequest request){
        String subject = extractSubjectFromToken(authorizationHeader);
        Integer mId = service.findIdByLogin(subject);
        String role = service.findRoleById(mId);
        if (role.equals("MANAGER")) {
            return ResponseFactory.create(service.save(request), "Administrador cadastrado com sucesso", "Agora este administrador pode gerenciar o sistema");
        }else {
            return ResponseFactory.error("Você não tem permissão para prosseguir com a requisição","Está é uma requisição do tipo administrador");
        }
    }

    @DeleteMapping("/deletar")
    public Response delete(Integer id){
        return ResponseFactory.delete(service.delete(id),"Manager deletado com sucesso","Não se encontra mais na base de dados");
    }

    @GetMapping("/list")
    public Response list(){
        return ResponseFactory.ok(repository.findAll());
    }

    @PutMapping("/editar")
    public Response editar(@RequestBody ManagerRequest request, Integer id){
        return ResponseFactory.ok(service.editar(request, id));
    }

    private String extractSubjectFromToken(String authorizationHeader) {
        try {
            String token = authorizationHeader.replace(jwtProperties.getPrefix(), "");

            Claims claims = Jwts.parser()
                    .setSigningKey(jwtProperties.getKey())
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

}
