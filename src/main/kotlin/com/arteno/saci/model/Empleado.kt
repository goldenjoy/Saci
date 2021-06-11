package com.arteno.saci.model

import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
data class Empleado (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0,

    @get:Size(min = 3, max = 50)
    val nombre:String,

    @ManyToOne
    val catPuestoLaboral: CatPuestoLaboral,

    @get:Min(0)
    val salarioPeriodo:Double,

    @ManyToOne
    val catPeriodoNomina: CatPeriodoNomina){

    override fun equals(other:Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as Empleado

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}