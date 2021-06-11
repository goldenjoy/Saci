package com.arteno.saci.util

import com.arteno.saci.service.InventarioService
import com.arteno.saci.service.CatProductoService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CargarDatosDbArranque(
        private val inventarioService: InventarioService,
        private val catProductoService: CatProductoService
    ):ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        /*val producctoDefault = productoService.guardar(Producto(desc="Prodcuto test", medida="test", precioUnitario=5.0))

        listOf(
            Inventario(id=1, producto = producctoDefault, cantidad = 5.0),
            Inventario(id=2, producto = producctoDefault, cantidad = 10.0)
        ).forEach(){
            println("Cargar dato a la DB en arranque -> ${it.id}")
            inventarioService.guardar(it)
        }*/
    }
}