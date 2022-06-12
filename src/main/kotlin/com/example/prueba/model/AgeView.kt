package com.example.prueba.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="hora_view")

class HoraView {
        @Id
        @Column(updatable = false)
        var age: String? = null
        var frequency: Long? = null

}