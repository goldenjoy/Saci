package com.arteno.saci.service

import com.arteno.saci.dao.CatUnidadMedidaDao
import com.arteno.saci.model.CatUnidadMedida
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class CatUnidadMedidaService(private val daoCat: CatUnidadMedidaDao):CrudSimple<CatUnidadMedida, Int> {

    override fun obtenerTodos():List<CatUnidadMedida> = this.daoCat.findAll(Sort.by(Sort.Direction.DESC, "id"))

    override fun obtenerPorId(id: Int): CatUnidadMedida? = this.daoCat.findByIdOrNull(id)

    override fun guardar(t: CatUnidadMedida): CatUnidadMedida {
        return if (!this.daoCat.existsByDescripcion(t.descripcion))
            this.daoCat.save(t)
        else
            throw DuplicateKeyException("La unidad de medida ${t.descripcion} ya esta registrada en el sistema y no puede ser duplicada")
    }

    override fun actualizar(t: CatUnidadMedida): CatUnidadMedida {
        return if (this.daoCat.existsById(t.id))
            if (this.daoCat.findByDescripcionIgnoreCase(t.descripcion) == null)
                this.daoCat.save(t)
            else
                throw DuplicateKeyException("La unidad de medida ${t.descripcion} ya esta registrada en el sistema y no puede ser duplicada")
        else
            throw EntityNotFoundException("La unidad de medida ${t.descripcion} no puede ser actualizada por que no existe en el sistema")
    }

    override fun eliminarPorId(id: Int): CatUnidadMedida {
        return this.obtenerPorId(id)?.apply {
            this@CatUnidadMedidaService.daoCat.deleteById(this.id)
        } ?: throw EntityNotFoundException("La unidad de medida con el identificador ${id} no se puede eliminar por que no se encuentra en el sistema")
    }
}