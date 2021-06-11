package com.arteno.saci.service

import com.arteno.saci.dao.CatPuestoLaboralDao
import com.arteno.saci.model.CatPuestoLaboral
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class CatPuestoLaboralService(private val daoCat: CatPuestoLaboralDao):CrudSimple<CatPuestoLaboral, Int> {

    override fun obtenerTodos():List<CatPuestoLaboral> = this.daoCat.findAll()

    override fun obtenerPorId(id: Int): CatPuestoLaboral? = this.daoCat.findByIdOrNull(id)

    override fun guardar(t: CatPuestoLaboral): CatPuestoLaboral {
        return if (!this.daoCat.existsByDesc(t.desc))
            this.daoCat.save(t)
        else
            throw DuplicateKeyException("El puesto laboral ${t.desc} ya esta registrado en el sistema y no puede duplicarse")
    }

    override fun actualizar(t: CatPuestoLaboral): CatPuestoLaboral {
        return if (this.daoCat.existsById(t.id))
            this.daoCat.save(t)
        else
            throw EntityNotFoundException("El puesto laboral ${t.desc} con el identificador ${t.id} no se puede actualizar por que no existe en el catálogo")
    }

    override fun eliminarPorId(id: Int): CatPuestoLaboral {
        return this.obtenerPorId(id)?.apply {
            this@CatPuestoLaboralService.daoCat.deleteById(this.id)
        } ?: throw EntityNotFoundException("El puesto laboral con el identificador ${id} no se puede eliminar por que no existe en el catálogo")
    }
}