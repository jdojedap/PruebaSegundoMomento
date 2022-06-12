package com.example.prueba.repository

import com.example.prueba.model.HoraView
import org.springframework.data.jpa.repository.JpaRepository

interface HoraViewRepository: JpaRepository<HoraView, String> {
}