package com.dicionarioespanholAPI.controller;

import com.dicionarioespanholAPI.infra.handler.Response;
import com.dicionarioespanholAPI.infra.handler.ResponseFactory;
import com.dicionarioespanholAPI.infra.handler.exception.BusinessException;
import com.dicionarioespanholAPI.infra.handler.exception.RecordNotFoundException;
import com.dicionarioespanholAPI.infra.security.Login;
import com.dicionarioespanholAPI.infra.security.Session;
import com.dicionarioespanholAPI.infra.security.jwt.JwtFactory;
import com.dicionarioespanholAPI.infra.security.jwt.JwtObject;
import com.dicionarioespanholAPI.infra.security.jwt.JwtProperties;
import com.dicionarioespanholAPI.model.manager.ManagerEntity;
import com.dicionarioespanholAPI.repository.ManagerRepository;
import com.dicionarioespanholAPI.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginResource {

    public static final BusinessException USUARIO_INVALIDO_EXCEPTION = new BusinessException("Login Inválido","403","Confirme seu login e senha");
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    @Operation(summary = "login administrador")
    public Response managerLogin(@RequestBody Login login){
        ManagerEntity entity = managerRepository.findByEmail(login.getEmail());
        if(entity!=null ){
            Session session = new Session();
            session.setLogin(login.getEmail());
            session.setId(managerService.findIdByLogin(login.getEmail()));
            session.setNome(managerService.findNomeByLogin(login.getEmail()));
            session.setMatricula(managerService.findMatriculaByEmail(login.getEmail()));

            boolean senhaValida = encoder.matches(login.getPassword(), entity.getPassword());

            if(!senhaValida)
                throw USUARIO_INVALIDO_EXCEPTION;

            JwtObject jwtObject = JwtObject.builder()
                    .subject(login.getEmail())
                    .issuedAt()
                    .expirationHours(4)
                    .roles(entity.getRole()==null?"MANAGER":entity.getRole());

            session.setToken(JwtFactory.create(JwtProperties.PREFIX, JwtProperties.KEY, jwtObject));
            return ResponseFactory.ok(session,"Login realizado com sucesso");
        }else{
            throw new RecordNotFoundException("Administrador","Login");
        }

    }

}
