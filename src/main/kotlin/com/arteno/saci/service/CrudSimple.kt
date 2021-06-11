package com.arteno.saci.service

interface CrudSimple<T, ID>{
    fun obtenerTodos():List<T>
    fun obtenerPorId(id:ID): T?
    fun guardar(t:T): T
    fun actualizar(t:T): T
    fun eliminarPorId(id:ID): T
}