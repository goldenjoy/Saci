package com.arteno.saci.service

import com.arteno.saci.dao.EmpleadoDao
import com.arteno.saci.model.Empleado
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class EmpleadoService(private val dao: EmpleadoDao):CrudSimple<Empleado, Int> {

    override fun obtenerTodos():List<Empleado> = this.dao.findAll()

    override fun obtenerPorId(id: Int): Empleado? = this.dao.findByIdOrNull(id)

    override fun guardar(t: Empleado): Empleado {
        return if (!this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw DuplicateKeyException("El empleado ${t.nombre} con el identificador ${t.id} ya existe")
    }

    override fun actualizar(t: Empleado): Empleado {
        return if (this.dao.existsById(t.id))
            this.dao.save(t)
        else
            throw EntityNotFoundException("El empleado ${t.nombre} con el identificador ${t.id} no se puede actualizar por que no existe")
    }

    override fun eliminarPorId(id: Int): Empleado {
        return this.obtenerPorId(id)?.apply {
            this@EmpleadoService.dao.deleteById(this.id)
        } ?: throw EntityNotFoundException("El empleado  con el identificador ${id}  no se puede eliminar por que no existe")
    }
}