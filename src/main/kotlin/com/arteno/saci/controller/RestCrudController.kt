package com.arteno.saci.controller

import com.arteno.saci.model.*
import com.arteno.saci.service.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service/periodoNomina")
class CatPeriodoNominaController(serviceCat: CatPeriodoNominaService): CrudComun<CatPeriodoNomina, Int>(serviceCat)

@RestController
@RequestMapping("/service/producto")
class CatProductoController(serviceCat: CatProductoService): CrudComun<CatProducto, Int>(serviceCat)

@RestController
@RequestMapping("/service/puestoLaboral")
class CatPuestoLaboralController(serviceCat: CatPuestoLaboralService): CrudComun<CatPuestoLaboral, Int>(serviceCat)

@RestController
@RequestMapping("/service/unidadMedida")
class CatUnidadMedidaController(serviceCat: CatUnidadMedidaService): CrudComun<CatUnidadMedida, Int>(serviceCat)

@RestController
@RequestMapping("/service/empleado")
class EmpleadoController(service: EmpleadoService): CrudComun<Empleado, Int>(service)

@RestController
@RequestMapping("/service/gasto")
class GastoController(service: GastoService): CrudComun<Gasto, Int>(service)

@RestController
@RequestMapping("/service/inventario")
class InventarioController(service: InventarioService): CrudComun<Inventario, Int>(service)

@RestController
@RequestMapping("/service/merma")
class MermaController(service: MermaService): CrudComun<Merma, Int>(service)

@RestController
@RequestMapping("/service/produccion")
class ProduccionController(service: ProduccionService): CrudComun<Produccion, Int>(service)

@RestController
@RequestMapping("/service/nomina")
class NominaController(service: NominaService): CrudComun<Nomina, Int>(service)

@RestController
@RequestMapping("/service/venta")
class VentaController(service: VentaService): CrudComun<Venta, Int>(service)