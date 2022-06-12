package com.example.prueba.service

import com.example.prueba.dto.nameDto
import com.example.prueba.model.HoraView
import com.example.prueba.model.Jugador
import com.example.prueba.repository.HoraViewRepository
import com.example.prueba.repository.JugadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service

class JugadorService {
    @Autowired
    lateinit var jugadorRepository: JugadorRepository

    fun  list(): List<Jugador>{
        return jugadorRepository.findAll()
    }

    fun save(jugador: Jugador):Jugador{
        return jugadorRepository.save(jugador)
    }

    fun update(jugador: Jugador): Jugador{
        jugadorRepository.findById(jugador.id) ?:throw Exception()

        return jugadorRepository.save(jugador)
    }

    fun updateName(jugador: Jugador): Jugador{
        val response=jugadorRepository.findById(jugador.id)
            ?:throw  Exception()
        response.nombre=jugador.nombre
        return jugadorRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        jugadorRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?): Jugador?{
        return jugadorRepository.findById(id)
    }

    fun getByHora (hora: Long?):List<Jugador>?{
        return jugadorRepository.getListHora (hora)

    }

    @Transactional
    fun updateOtherName (nameDto:nameDto): String?{
        val rowsUpdate=jugadorRepository.setOtherName(nameDto.name, nameDto.newName)
        return "${rowsUpdate} rows updated"
    }

    @Autowired
    lateinit var horaViewRepository: HoraViewRepository

    /*resto del codigo*/


    fun listHoraView ():List<HoraView>{
        return horaViewRepository.findAll()
    }
}