package com.arteno.saci.service

import com.arteno.saci.dao.GastoDao
import com.arteno.saci.model.Gasto
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class GastoService(private val dao: GastoDao):CrudSimple<Gasto, Int> {

    override fun obtenerTodos():List<Gasto> = this.dao.findAll()

    override fun obtenerPorId(id: Int): Gasto? = this.dao.findByIdOrNull(id)

    override fun guardar(t: Gasto): Gasto {
        return if (!this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw DuplicateKeyException("El gasto con el identificador ${t.id} ya existe")
    }

    override fun actualizar(t: Gasto): Gasto {
        return if (this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw EntityNotFoundException("El gasto con el identificador ${t.id} no se puede actualizar por que no existe")
    }

    override fun eliminarPorId(id: Int): Gasto {
        return this.obtenerPorId(id)?.apply {
            this@GastoService.dao.deleteById(this.id)
        } ?: throw EntityNotFoundException("El gasto con el identificador ${id} no se puede eliminar por que no existe")
    }
}