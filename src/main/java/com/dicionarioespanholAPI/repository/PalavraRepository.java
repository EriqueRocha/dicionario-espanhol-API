package com.dicionarioespanholAPI.repository;

import com.dicionarioespanholAPI.model.palavra.PalavraEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PalavraRepository extends JpaRepository<PalavraEntity, Integer>, JpaSpecificationExecutor<PalavraEntity> {


    @Override
    Optional<PalavraEntity> findById(Integer integer);

    @Query("SELECT p.nome FROM PalavraEntity p WHERE p.id = :id")
    Optional<String> findNomeById(@Param("id") Integer id);

    @Query("SELECT p FROM PalavraEntity p WHERE p.nome = :nome")
    Optional<PalavraEntity> findByNome(@Param("nome") String nome);

    @Query("SELECT p FROM PalavraEntity p WHERE p.nomeCientifico = :nomeCientifico")
    Optional<PalavraEntity> findByNomeCientifico(@Param("nomeCientifico") String nomeCientifico);

    boolean existsByNome(String nome);

    boolean existsByNomeCientifico(String nomeCientifico);

    @Query("SELECT p FROM PalavraEntity p WHERE LOWER(SUBSTRING(p.nome, 1, 1)) = LOWER(:letra)")
    List<PalavraEntity> findByNomeStartingWithLetter(@Param("letra") String letra);

    @Query("SELECT p FROM PalavraEntity p WHERE LOWER(SUBSTRING(p.nome, LENGTH(p.nome), 1)) = LOWER(:letra)")
    List<PalavraEntity> findByNomeEndingWithLetter(@Param("letra") String letra);

}
