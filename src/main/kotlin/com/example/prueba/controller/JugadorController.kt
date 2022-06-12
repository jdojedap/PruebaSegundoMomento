package com.example.prueba.controller

import com.example.prueba.dto.nameDto
import com.example.prueba.model.HoraView
import com.example.prueba.model.Jugador
import com.example.prueba.service.JugadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jugador")

class JugadorController {

    @Autowired
    lateinit var jugadorService: JugadorService

    @GetMapping
            fun List():List<Jugador>{
                return jugadorService.list()
            }

    @PostMapping

    fun save (@RequestBody jugador: Jugador): Jugador {
        return  jugadorService.save(jugador)
    }

    @PutMapping
    fun update (@RequestBody jugador: Jugador): Jugador{
        return jugadorService.update(jugador)
    }
    @PatchMapping
    fun updateName(@RequestBody jugador: Jugador): Jugador{
        return jugadorService.updateName(jugador)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return jugadorService.delete(id )
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Jugador?{
        return jugadorService.getById(id)
    }

    @GetMapping("/hora/{hora}")
    fun listByHora (@PathVariable("hora") hora: Long): List<Jugador>?{
        return jugadorService.getByHora(hora)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody nameDto:nameDto): String?{
        return jugadorService.updateOtherName(nameDto)
    }

    @GetMapping("/frequency/hora")
    fun listHoraView (): List<HoraView>?{
        return jugadorService.listHoraView()
    }

}