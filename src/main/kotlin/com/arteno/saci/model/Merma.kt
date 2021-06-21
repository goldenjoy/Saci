package com.arteno.saci.model

import javax.persistence.*
import javax.validation.constraints.Min

@Entity
@Table(name = "mermas")
data class Merma (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0,

    @ManyToOne
    val catProducto: CatProducto,

    @get:Min(0)
    val cantidad:Double,

    @get:Min(0)
    val precioUnitario:Double,

    @get:Min(0)
    val totalPerdida:Double){

    override fun equals(other:Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as Merma

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}