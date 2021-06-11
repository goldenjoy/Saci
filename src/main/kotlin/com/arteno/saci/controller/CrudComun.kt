package com.arteno.saci.controller

import com.arteno.saci.service.CrudSimple
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

abstract class CrudComun<T, ID>(private val crudBasico: CrudSimple<T, ID>) {

    @GetMapping
    fun mostrarTodos() = crudBasico.obtenerTodos()

    @GetMapping("/{id}")
    fun mostrarPorId(@PathVariable id:ID): ResponseEntity<T> {
        val entity = crudBasico.obtenerPorId(id)
        return ResponseEntity.status(if (entity != null) HttpStatus.OK else HttpStatus.NO_CONTENT).body(entity)
    }

    @PostMapping
    fun guardar(@Valid @RequestBody body: T) = ResponseEntity.status(HttpStatus.CREATED).body(
        this.crudBasico.guardar(body)
    )

    @PutMapping
    fun actualizar(@Valid @RequestBody body: T) = this.crudBasico.actualizar(body)

    @DeleteMapping("/{id}")
    fun eliminarPorId(@PathVariable id:ID) = this.crudBasico.eliminarPorId(id)

}