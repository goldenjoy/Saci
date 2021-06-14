package com.arteno.saci.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class CatPuestoLaboral (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0,

    @get:Size(min = 3, max = 25)
    @Column(unique = true)
    val desc:String){

    override fun equals(other:Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as CatPuestoLaboral

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}