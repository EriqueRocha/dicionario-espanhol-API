package com.dicionarioespanholAPI.controller;

import com.dicionarioespanholAPI.infra.handler.Response;
import com.dicionarioespanholAPI.infra.handler.ResponseFactory;
import com.dicionarioespanholAPI.model.manager.ManagerRequest;
import com.dicionarioespanholAPI.repository.ManagerRepository;
import com.dicionarioespanholAPI.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    private ManagerService service;

    @Autowired
    private ManagerRepository repository;

    @PostMapping("/adicionar")
    public Response save(@RequestBody ManagerRequest request){
        return ResponseFactory.create(service.save(request),
                "Salvo com sucesso",
                "Este Administrador já pode ser gerenciada pelo sistema");
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

}
