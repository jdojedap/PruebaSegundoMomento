package com.example.prueba.repository

import com.example.prueba.model.Jugador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JugadorRepository: JpaRepository<Jugador,Long> {

    fun findById(id:Long?): Jugador?
    @Query(nativeQuery=true)
    fun getListHora (@Param("hora")  hora:Long?) : List <Jugador>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  name:String?, @Param("newName")  newName:String?) : Integer?

}