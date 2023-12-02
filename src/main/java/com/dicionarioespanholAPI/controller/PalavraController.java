package com.dicionarioespanholAPI.controller;

import com.dicionarioespanholAPI.infra.handler.Response;
import com.dicionarioespanholAPI.infra.handler.ResponseFactory;
import com.dicionarioespanholAPI.infra.security.jwt.JwtProperties;
import com.dicionarioespanholAPI.model.palavra.PalavraEntity;
import com.dicionarioespanholAPI.model.palavra.PalavraResquest;
import com.dicionarioespanholAPI.repository.PalavraRepository;
import com.dicionarioespanholAPI.service.ManagerService;
import com.dicionarioespanholAPI.service.PalavraService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dicionario")
@CrossOrigin(origins = "*")
public class PalavraController {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PalavraService service;

    @Autowired
    private PalavraRepository repository;

    @PostMapping("/adicionar")
    @Operation(summary = "Adicionar uma nova palavra")
    public Object save(@RequestHeader("Authorization") String authorizationHeader, @RequestBody PalavraResquest resquest){

        String subject = extractSubjectFromToken(authorizationHeader);
        Integer mId = managerService.findIdByLogin(subject);
        String role = managerService.findRoleById(mId);
        if (role.equals("MANAGER")) {
            return ResponseFactory.create(service.save(resquest), "Palavra cadastrado com sucesso", "Agora este administrador pode gerenciar o sistema");
        }else {
            return ResponseFactory.error("Você não tem permissão para prosseguir com a requisição","Está é uma requisição do tipo administrador");
        }

    }

    @DeleteMapping("/deletar")
    @Operation(summary = "Deleta uma palavra")
    public void delete(Integer id){
        repository.deleteById(id);
    }

    @GetMapping("buscar-palavra/{id}")
    @Operation(summary = "Busca uma palavra pelo id")
    public Optional<PalavraEntity> buscarUm(@PathVariable Integer id){
        return repository.findById(id);
    }

    @GetMapping("listar-palavras")
    @Operation(summary = "Restorna todas as palavras")
    public List<PalavraEntity> list(){
        return repository.findAll();
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita uma palavra")
    public Object editar(@RequestBody PalavraResquest resquest,@PathVariable Integer id){
        return service.editar(resquest, id);
    }

    @PatchMapping("/ocorrenciasImage/{id}")
    @Operation(summary = "Adicionar imagens a uma palavra")
    public Response addImage(@PathVariable Integer id,
                             @RequestBody @Parameter(description = "Caminhos das imagens", required = true) List<String> imagePaths) {
        return ResponseFactory.ok(service.addImage(id, imagePaths),"Imagens salvas","use o id da palavra em: localhost:8080/dicionario/getImages/{id} para obter a lista patch da imagens");
    }

    @GetMapping("/buscadepalavra/{nome}")
    @Operation(summary = "Busca uma palavra pelo nome")
    public ResponseEntity<Response> findPalavraByNome(@PathVariable String nome) {
        return service.findPalavraByNome(nome);
    }

    @GetMapping("/buscadepalavraNumLetra/{num}")
    @Operation(summary = "Busca uma palavra pela quantidade de letra, hífen inclui")
    public List<PalavraEntity> findPalavraByNumLetra(@PathVariable int num) {
        return service.findPalavraByNumLetra(num);
    }

    @GetMapping("/buscaPorLetraInicial/{letra}")
    @Operation(summary = "Busca palavras cujo nome começa com uma letra específica")
    public List<PalavraEntity> findPalavraByLetraInicial(@PathVariable @Size(min = 1, max = 1) String letra) {
        return service.findPalavraByLetraInicial(letra);
    }

    @GetMapping("/buscaPorLetraFinal/{letra}")
    @Operation(summary = "Busca palavras cujo nome termina com uma letra específica")
    public List<PalavraEntity> findPalavraByLetraFinal(@PathVariable String letra) {
        return service.findPalavraByLetraFinal(letra);
    }

    @GetMapping("/buscaPorCriterios")
    @Operation(summary = "Busca palavras por critérios específicos")
    public Object findPalavraByCriteria(
            @RequestParam(required = false) Integer numeroLetras,
            @RequestParam(required = false) String letraInicial,
            @RequestParam(required = false) String letraFinal) {
        return service.findPalavraByCriteria(numeroLetras, letraInicial, letraFinal);
    }

    @GetMapping("/getImages/{id}")
    @Operation(summary = "Retorna as imagens de uma palavra")
    public Response getImages(@PathVariable Integer id){
        return  ResponseFactory.ok(service.getImages(id));
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
