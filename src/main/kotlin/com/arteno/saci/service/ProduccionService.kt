package com.arteno.saci.service

import com.arteno.saci.dao.ProduccionDao
import com.arteno.saci.model.Produccion
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ProduccionService(private val dao: ProduccionDao):CrudSimple<Produccion, Int> {

    override fun obtenerTodos():List<Produccion> = this.dao.findAll()

    override fun obtenerPorId(id: Int): Produccion? = this.dao.findByIdOrNull(id)

    override fun guardar(t: Produccion): Produccion {
        return if (!this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw DuplicateKeyException("El registro de producción con el identificador ${t.id} ya existe")
    }

    override fun actualizar(t: Produccion): Produccion {
        return if (this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw EntityNotFoundException("El registro de producción con el identificador ${t.id} no se puede actualizar por que no existe")
    }

    override fun eliminarPorId(id: Int): Produccion {
        return this.obtenerPorId(id)?.apply {
            this@ProduccionService.dao.deleteById(this.id)
        } ?: throw EntityNotFoundException("El registro de producción con el identificador ${id} no se puede eliminar por que no existe")
    }
}