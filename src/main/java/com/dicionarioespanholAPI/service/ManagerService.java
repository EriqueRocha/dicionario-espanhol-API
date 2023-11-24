package com.dicionarioespanholAPI.service;

import com.dicionarioespanholAPI.infra.handler.exception.*;
import com.dicionarioespanholAPI.model.manager.ManagerEntity;
import com.dicionarioespanholAPI.model.manager.ManagerRequest;
import com.dicionarioespanholAPI.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository repository;

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public Object save(ManagerRequest request) {
        return this.persist(null, request);
    }

    private ManagerEntity findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException("Administrador", "ID"));
    }

    public Object editar(ManagerRequest request, Integer id) {
        return  this.persist(id, request);
    }

    public ManagerEntity findByLogin(String login) {
        Optional<ManagerEntity> optionalManager = Optional.ofNullable(repository.findByEmail(login));
        if (optionalManager.isPresent()) {
            return optionalManager.get();
        } else {
            throw new RecordNotFoundException("Manager", "Login");
        }
    }

    public Integer findIdByLogin(String login) {
        ManagerEntity manager = findByLogin(login);
        return manager.getId();
    }

    public String findNomeByLogin(String email) {
        ManagerEntity usuario = findByLogin(email);
        return usuario.getNome();
    }

    public Object delete(Integer id) {
        if(!repository.existsById(id)){
            throw new RecordNotFoundException("Manager","id");
        }
        Optional<ManagerEntity> entity = repository.findById(id);
        repository.deleteById(id);
        return entity;
    }

    public String findMatriculaByEmail(String email) {
        return repository.findMatriculaByEmail(email);
    }

    @Transactional
    public ManagerEntity persist(Integer id, ManagerRequest request){

        ManagerEntity entity = null;

        if(id!=null){

            entity = this.findById(id);
            if (!entity.getEmail().equals(request.getEmail())) {
                if (repository.findByEmail(request.getEmail()).equals(request.getEmail())) {
                    throw new EmailAlreadyExistsException(request.getEmail());
                }
            }

            if (!entity.getMatricula().equals(request.getMatricula())) {
                if (repository.findByMatricula(request.getMatricula()).isPresent()) {
                    throw new MatriculaAlreadyExistsException(request.getMatricula());
                }
            }

        }else{
            if (repository.findByMatriculaOptional(request.getMatricula()).isPresent())
                throw new MatriculaAlreadyExistsException(request.getMatricula());

            if (repository.findByEmailOptional(request.getEmail()).isPresent())
                throw new EmailAlreadyExistsException(request.getEmail());

            if(request.getNome()==null || request.getNome().isEmpty())
                throw new RequiredFieldException("Nome");

            if(request.getPassword()==null || request.getPassword().isEmpty())
                throw new RequiredFieldException("Senha");

            entity= new ManagerEntity();
            entity.setNome(request.getNome().toUpperCase());
            entity.setPassword(passwordEncoder().encode(request.getPassword()));
        }

        BeanUtils.copyProperties(request, entity);
        entity.setNome(request.getNome().toUpperCase());
        entity.setPassword(passwordEncoder().encode(request.getPassword()));
        return repository.save(entity);
    }
}
