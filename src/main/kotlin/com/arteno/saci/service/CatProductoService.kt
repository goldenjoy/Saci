package com.arteno.saci.service

import com.arteno.saci.dao.CatProductoDao
import com.arteno.saci.model.CatProducto
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class CatProductoService(private val daoCat: CatProductoDao):CrudSimple<CatProducto, Int> {

    override fun obtenerTodos():List<CatProducto> = this.daoCat.findAll(Sort.by(Sort.Direction.DESC, "id"))

    override fun obtenerPorId(id: Int): CatProducto? = this.daoCat.findByIdOrNull(id)

    override fun guardar(t: CatProducto): CatProducto {
        return if (!this.daoCat.existsByDescripcion(t.descripcion))
            this.daoCat.save(t)
        else
            throw DuplicateKeyException("El producto ${t.descripcion} con el identificador ${t.id} ya existe en el catálogo")
    }

    override fun actualizar(t: CatProducto): CatProducto {
        return if (this.daoCat.existsById(t.id))
            this.daoCat.save(t)
        else
            throw EntityNotFoundException("El producto ${t.descripcion} con el identificador ${t.id} no se puede actualizar por que no existe en el catálogo")
    }

    override fun eliminarPorId(id: Int): CatProducto {
        return this.obtenerPorId(id)?.apply {
            this@CatProductoService.daoCat.deleteById(this.id)
        } ?: throw EntityNotFoundException("El producto con el identificador ${id} no se puede eliminar por que no existe en el catálogo")
    }
}