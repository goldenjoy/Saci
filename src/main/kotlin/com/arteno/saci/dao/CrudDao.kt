package com.arteno.saci.dao

import com.arteno.saci.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CatPeriodoNominaDao: JpaRepository<CatPeriodoNomina, Int>{
    fun existsByDesc(@Param("desc") desc: String): Boolean
}

@Repository
interface CatProductoDao: JpaRepository<CatProducto, Int>{
    fun existsByDesc(@Param("desc") desc: String): Boolean
}

@Repository
interface CatPuestoLaboralDao: JpaRepository<CatPuestoLaboral, Int>{
    fun existsByDesc(@Param("desc") desc: String): Boolean
}

@Repository
interface CatUnidadMedidaDao: JpaRepository<CatUnidadMedida, Int>{
    fun existsByDesc(@Param("desc") desc: String): Boolean
}

@Repository
interface EmpleadoDao: JpaRepository<Empleado, Int>

@Repository
interface GastoDao: JpaRepository<Gasto, Int>

@Repository
interface InventarioDao: JpaRepository<Inventario, Int>

@Repository
interface MermaDao: JpaRepository<Merma, Int>

@Repository
interface ProduccionDao: JpaRepository<Produccion, Int>

@Repository
interface NominaDao: JpaRepository<Nomina, Int>

@Repository
interface VentaDao: JpaRepository<Venta, Int>

