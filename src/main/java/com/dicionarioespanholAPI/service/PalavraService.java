package com.dicionarioespanholAPI.service;

import com.dicionarioespanholAPI.infra.FieldType;
import com.dicionarioespanholAPI.infra.handler.Response;
import com.dicionarioespanholAPI.infra.handler.ResponseFactory;
import com.dicionarioespanholAPI.infra.handler.exception.NomeAlreadyExistsException;
import com.dicionarioespanholAPI.infra.handler.exception.RecordNotFoundException;
import com.dicionarioespanholAPI.model.palavra.PalavraEntity;
import com.dicionarioespanholAPI.model.palavra.PalavraResquest;
import com.dicionarioespanholAPI.repository.PalavraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PalavraService {

    private static final String MESSAGE = "Palavra já cadastrada";

    private static final String MESSAGE2 = "Nome científico já cadastrado";

    private static final String MESSAGE3 = "use outro nome";

    @Autowired
    private FieldType fieldType;

    @Autowired
    private PalavraRepository repository;

    public Object save(PalavraResquest resquest){
        return  this.persist(null, resquest);
    }

    public Object editar(PalavraResquest resquest, Integer id){
        return  this.persist(id,resquest);
    }

    private PalavraEntity findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException("Palavra", "ID"));
    }

    public Object addImage(Integer id, List<String> imagePaths) {

        PalavraEntity entity = this.findById(id);

        entity.setImagePaths(imagePaths);

        repository.save(entity);
        return entity.getImagePaths();
    }
    public Object getImages(Integer id) {
        if (repository.existsById(id)){
            PalavraEntity entity = this.findById(id);
            return entity.getImagePaths();
        }else throw new RecordNotFoundException("Ocorrência","id");
    }
    @Transactional
    public ResponseEntity<Response> persist(Integer id, PalavraResquest request){

        PalavraEntity entity;

        if(id!=null){

            entity = this.findById(id);
            if (!entity.getNome().equals(request.getNome()) &&
                    (repository.findByNome(request.getNome()).isPresent())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(ResponseFactory.error(409,MESSAGE,MESSAGE3));
            }
            if (!entity.getNomeCientifico().equals(request.getNomeCientifico()) &&
                    (repository.findByNomeCientifico(request.getNomeCientifico()).isPresent())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                       .body(ResponseFactory.error(409,MESSAGE2,MESSAGE3));
            }
        }else{

            if (repository.existsByNome(request.getNome())){
                Exception error = new NomeAlreadyExistsException(request.getNome());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseFactory.error(409,
                        error.getMessage(),"Utilize outra palavra como nome"));
            }
            if (repository.existsByNomeCientifico(request.getNomeCientifico())){
                Exception error = new NomeAlreadyExistsException(request.getNomeCientifico());
                return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseFactory.error(409,
                        error.getMessage(),"Utilize outra palavra como nome científico"));
            }

            Exception error = fieldType.checkData(request);

            if (error!=null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseFactory.error(400,error.getMessage(),
                        "preencha todos os campos"));
            }
            entity= new PalavraEntity();
        }

        entity.setNome(request.getNome().toUpperCase());
        entity.setNomeCientifico(request.getNomeCientifico().toUpperCase());
        BeanUtils.copyProperties(request,entity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseFactory.create(repository.save(entity),
                        "Salvo com sucesso",
                        "Esta palavra já pode ser gerênciada pelo sistema"));
    }

    public ResponseEntity<Response> findPalavraByNome(String nome) {
        Optional<PalavraEntity> entity = repository.findByNome(nome);

        if (entity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseFactory.error(404,
                            "Esta palavra não existe na base de dados",
                            "Busque por outra palavra"));
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseFactory.ok(entity,"Consulta realizada com sucesso"));
        }

    }

    public List<PalavraEntity> findPalavraByNumLetra(int num) {
        List<PalavraEntity> palavras = repository.findAll();
        return palavras.stream()
                .filter(palavra -> palavra.getNome().length() == num)
                .collect(Collectors.toList());
    }

    public List<PalavraEntity> findPalavraByLetraInicial(String letra) {
        return repository.findByNomeStartingWithLetter(letra);
    }

    public List<PalavraEntity> findPalavraByLetraFinal(String letra) {
        return repository.findByNomeEndingWithLetter(letra);
    }

    public Object findPalavraByCriteria(Integer numberLetter, String initialLetter, String finalLetter) {
         List<PalavraEntity> palavras = repository.findAll();
        if (numberLetter == null && initialLetter == null  && finalLetter == null){
            return Collections.singletonList(repository.findAll());
        }
        if (numberLetter != null && initialLetter == null  && finalLetter == null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().length() == numberLetter)
                    .collect(Collectors.toList());
        }
        if (numberLetter != null && initialLetter != null  && finalLetter == null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().length() == numberLetter)
                    .filter(palavra -> palavra.getNome().startsWith(initialLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (numberLetter != null && initialLetter != null  && finalLetter != null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().length() == numberLetter)
                    .filter(palavra -> palavra.getNome().startsWith(initialLetter.toUpperCase()))
                    .filter(palavra -> palavra.getNome().endsWith(finalLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (numberLetter != null && initialLetter == null  && finalLetter != null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().length() == numberLetter)
                    .filter(palavra -> palavra.getNome().endsWith(finalLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (numberLetter == null && initialLetter != null  && finalLetter != null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().startsWith(initialLetter))
                    .filter(palavra -> palavra.getNome().endsWith(finalLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (numberLetter == null && initialLetter == null  && finalLetter != null){
            return palavras.stream()
                    .filter(palavra -> palavra.getNome().endsWith(finalLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }
        if (numberLetter == null && initialLetter != null  && finalLetter == null){

            return palavras.stream()
                    .filter(palavra -> palavra.getNome().startsWith(initialLetter.toUpperCase()))
                    .collect(Collectors.toList());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseFactory.error(404,
                            "Esta palavra não existe na base de dados",
                            "Busque por outra palavra"));
        }

    }

}
