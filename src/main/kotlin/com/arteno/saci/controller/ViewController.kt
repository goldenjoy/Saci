package com.arteno.saci.controller

import com.arteno.saci.model.CatPeriodoNomina
import com.arteno.saci.model.CatProducto
import com.arteno.saci.model.CatPuestoLaboral
import com.arteno.saci.model.CatUnidadMedida
import com.arteno.saci.service.CatPeriodoNominaService
import com.arteno.saci.service.CatProductoService
import com.arteno.saci.service.CatPuestoLaboralService
import com.arteno.saci.service.CatUnidadMedidaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class InicioController {
    @GetMapping("/")
    fun inicioApp(model: Model) = "inicio"
}

@Controller
@RequestMapping("/periodoNomina")
class ViewCatPeriodoNominaController(serviceCat: CatPeriodoNominaService, nameView: String = "catPeriodoNomina"):
    GetAllComun<CatPeriodoNomina>(serviceCat, nameView)

@Controller
@RequestMapping("/producto")
class ViewCatProductoController(serviceCat: CatProductoService, nameView: String = "catProducto"):
    GetAllComun<CatProducto>(serviceCat, nameView)

@Controller
@RequestMapping("/puestoLaboral")
class ViewCatPuestoLaboralController(serviceCat: CatPuestoLaboralService, nameView: String = "catPuestoLaboral"):
    GetAllComun<CatPuestoLaboral>(serviceCat, nameView)

@Controller
@RequestMapping("/unidadMedida")
class ViewCatUnidadMedidaController(serviceCat: CatUnidadMedidaService, nameView: String = "catUnidadMedida"):
        GetAllComun<CatUnidadMedida>(serviceCat, nameView)
