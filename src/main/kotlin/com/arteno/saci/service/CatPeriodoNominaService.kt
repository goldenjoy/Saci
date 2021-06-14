package com.arteno.saci.service

import com.arteno.saci.dao.CatPeriodoNominaDao
import com.arteno.saci.model.CatPeriodoNomina
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class CatPeriodoNominaService(private val daoCat: CatPeriodoNominaDao):CrudSimple<CatPeriodoNomina, Int> {

    override fun obtenerTodos():List<CatPeriodoNomina> = this.daoCat.findAll()

    override fun obtenerPorId(id: Int): CatPeriodoNomina? = this.daoCat.findByIdOrNull(id)

    override fun guardar(t: CatPeriodoNomina): CatPeriodoNomina {
        return if (!this.daoCat.existsByDesc(t.desc))
            this.daoCat.save(t)
        else
            throw DuplicateKeyException("El periodo de nomina ${t.desc} ya esta registrado en el sistema y no puede duplicarse")
    }

    override fun actualizar(t: CatPeriodoNomina): CatPeriodoNomina {
        return if (this.daoCat.existsById(t.id))
            this.guardar(t)
        else
            throw EntityNotFoundException("El periodo de nomina ${t.desc} con el identificador ${t.id} no se puede actualizar por que no existe")
    }

    override fun eliminarPorId(id: Int): CatPeriodoNomina {
        return this.obtenerPorId(id)?.apply {
            this@CatPeriodoNominaService.daoCat.deleteById(this.id)
        } ?: throw EntityNotFoundException("El periodo de nomina con el identificador ${id} no se puede eliminar por que no existe")
    }
}