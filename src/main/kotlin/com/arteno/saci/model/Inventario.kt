package com.arteno.saci.model

import javax.persistence.*
import javax.validation.constraints.Min

@Entity
@Table(name = "inventario")
data class Inventario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0,

    @ManyToOne
    val catProducto: CatProducto,

    @get:Min(0)
    val cantidad:Double){

    override fun equals(other:Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as Inventario

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}