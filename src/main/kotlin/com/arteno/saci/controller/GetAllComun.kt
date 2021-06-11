package com.arteno.saci.controller

import com.arteno.saci.service.CrudSimple
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

abstract class GetAllComun<T>(private val crudBasico: CrudSimple<T, Int>, private val nameView: String) {

    @GetMapping()
    fun mostrarTodos(model: Model):String{
        model.addAttribute("listado", crudBasico.obtenerTodos())
        return nameView
    }


}