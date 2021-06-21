package com.arteno.saci.model

import javax.persistence.*
import javax.validation.constraints.Min

@Entity
@Table(name = "nomina")
data class Nomina (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0,

    @ManyToOne
    val empleado: Empleado,

    @get:Min(0)
    val pagoNomina:Double){

    override fun equals(other:Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as Nomina

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}