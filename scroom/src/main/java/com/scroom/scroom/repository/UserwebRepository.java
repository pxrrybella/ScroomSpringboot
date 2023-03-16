package com.scroom.scroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scroom.scroom.model.Userweb;

public interface UserwebRepository extends JpaRepository<Userweb, Integer>{
    /* @Query(value= "SELECT Userweb.userName, Userweb.lastName, Proyect.proyectName FROM Userweb JOIN UserwebProyect ON Userweb.userweb_id = UserwebProyect.userweb_id JOIN Proyect ON Proyect.proyect_id = UserwebProyect.proyect_id", nativeQuery=true)
    List<Userweb> findProyectosByUserweb(); */

    @Query(value= "SELECT Userweb.userName, Userweb.lastName, Proyect.proyectName FROM Userweb JOIN UserwebProyect ON Userweb.userweb_id = UserwebProyect.userweb_id JOIN Proyect ON Proyect.proyect_id = UserwebProyect.proyect_id WHERE userName like ?1", nativeQuery=true)
    List<Userweb> findProyectosByUserweb(String userName);
}