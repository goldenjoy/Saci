package com.arteno.saci.service

import com.arteno.saci.dao.VentaDao
import com.arteno.saci.model.Venta
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class VentaService(private val dao: VentaDao):CrudSimple<Venta, Int> {

    override fun obtenerTodos():List<Venta> = this.dao.findAll()

    override fun obtenerPorId(id: Int): Venta? = this.dao.findByIdOrNull(id)

    override fun guardar(t: Venta): Venta {
        return if (!this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw DuplicateKeyException("La venta con el identificador ${t.id} ya existe")
    }

    override fun actualizar(t: Venta): Venta {
        return if (this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw EntityNotFoundException("La venta con el identificador ${t.id} no se puede actualizar por que no existe")
    }

    override fun eliminarPorId(id: Int): Venta {
        return this.obtenerPorId(id)?.apply {
            this@VentaService.dao.deleteById(this.id)
        } ?: throw EntityNotFoundException("La venta con el identificador ${id} no se puede eliminar por que no existe")
    }
}