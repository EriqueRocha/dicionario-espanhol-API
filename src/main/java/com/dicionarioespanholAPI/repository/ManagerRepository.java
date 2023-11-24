package com.dicionarioespanholAPI.repository;

import com.dicionarioespanholAPI.model.manager.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {
    @Query("SELECT m FROM ManagerEntity m WHERE m.email = :email")
    ManagerEntity findByEmail(@Param("email") String email);

    @Query("SELECT u FROM ManagerEntity u WHERE u.email = :email")
    Optional<ManagerEntity> findByEmailOptional(@Param("email") String email);

    @Query("SELECT u FROM ManagerEntity u WHERE u.matricula = :matricula")
    Optional<ManagerEntity> findByMatriculaOptional(@Param("matricula") String matricula);

    @Query("SELECT p FROM ManagerEntity p WHERE p.matricula = :matricula")
    Optional<ManagerEntity> findByMatricula(@Param("matricula") String matricula);

    @Query("SELECT m.matricula FROM ManagerEntity m WHERE m.email = :email")
    String findMatriculaByEmail(@Param("email") String email);

//    @Query("SELECT p FROM AdministradorEntity p WHERE p.email = :email")
//    AdministradorEntity findByEmail(@Param("email") String email);
}
