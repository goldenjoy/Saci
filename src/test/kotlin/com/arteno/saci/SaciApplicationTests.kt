package com.arteno.saci

import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
//@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SaciApplicationTests {
/*
	//@Autowired
	//private lateinit var mockMvc: MockMvc

	@Autowired
	private lateinit var webApplicationContext: WebApplicationContext

	private val mockMvc: MockMvc by lazy {
		MockMvcBuilders.webAppContextSetup(webApplicationContext)
			.alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print()).build()
	}

	@Autowired
	private lateinit var mapper: ObjectMapper

	@Autowired
	private lateinit var inventarioService: InventarioService

	private val inventarioEndPoint = "/inventario"

	@Test
	fun a_mostrarTodos() {
		val productosDelServicio = inventarioService.obtenerTodos()

		val productos:List<ProductoInvent> = mockMvc.perform(MockMvcRequestBuilders.get(inventarioEndPoint))
			.andExpect(status().isOk)
			.bodyTo(mapper)

		assertThat(productosDelServicio, Matchers.`is`(Matchers.equalTo(productos)))
	}

	@Test
	fun b_mostrarPorId() {
		val productosDelServicio = inventarioService.obtenerTodos()
		assert(productosDelServicio.isNotEmpty()){"La lista de los productos del inventario esta vacia"}
		val producto = productosDelServicio.first()

		mockMvc.perform(MockMvcRequestBuilders.get("$inventarioEndPoint/${producto.id}"))
			.andExpect(status().isOk)
			.andExpect(jsonPath("$.id", Matchers.`is`(producto.id)))
	}

	@Test
	fun c_mostrarPorIdVacio() {
		mockMvc.perform(MockMvcRequestBuilders.get("$inventarioEndPoint/${UUID.randomUUID()}"))
			.andExpect(status().isNoContent)
			.andExpect(jsonPath("$").doesNotExist())
	}

	@Test
	fun d_guardar() {
		val producto = ProductoInvent("3", "Sal", 4.0, "kilogramo")

		val result:ProductoInvent = mockMvc.perform(MockMvcRequestBuilders.post(inventarioEndPoint)
			.body(data = producto, mapper = mapper))
			//.content(mapper.writeValueAsBytes(producto)).contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isCreated)
			.bodyTo(mapper)

		assert(inventarioService.obtenerTodos().contains(result))
	}

	@Test
	fun d2_guardarChecarReglas() {
		val producto = ProductoInvent("3", "", -4.0, "kilogramo")

		mockMvc.perform(MockMvcRequestBuilders.post(inventarioEndPoint)
			.body(data = producto, mapper = mapper))
			//.content(mapper.writeValueAsBytes(producto)).contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isBadRequest)
			.andExpect(jsonPath("$.desc").exists())
			.andExpect(jsonPath("$.cantidad").exists())
	}

	@Test
	fun e_guardarErrorEntidadDuplicada() {
		val productosDelServicio = inventarioService.obtenerTodos()
		assert(productosDelServicio.isNotEmpty()){"La lista de los productos del inventario esta vacia"}
		val producto = productosDelServicio.first()

		mockMvc.perform(MockMvcRequestBuilders.post(inventarioEndPoint)
			.body(data = producto, mapper = mapper))
			.andExpect(status().isConflict)
			.andExpect(jsonPath("$.titulo", Matchers.`is`("DuplicateKeyException")))
	}

	@Test
	fun f_actualizar() {
		val productosDelServicio = inventarioService.obtenerTodos()
		assert(productosDelServicio.isNotEmpty()){"La lista de productos esta vacia"}
		val producto = productosDelServicio.first().copy(desc = "DescTest")

		val result:ProductoInvent = mockMvc.perform(MockMvcRequestBuilders.put(inventarioEndPoint)
			.body(data = producto, mapper = mapper))
			.andExpect(status().isOk)
			.bodyTo(mapper)

		assertThat(
			inventarioService.obtenerPorId(producto.id),
			Matchers.`is`(result)
		)
	}

	@Test
	fun g_actualizarErrorEntidadDuplicada() {
		val producto = ProductoInvent("${UUID.randomUUID()}", "Sal", 4.0, "kilogramo")

		mockMvc.perform(MockMvcRequestBuilders.put(inventarioEndPoint)
			.body(data = producto, mapper = mapper))
			.andExpect(status().isConflict)
			.andExpect(jsonPath("$.titulo", Matchers.`is`("EntityNotFoundException")))
	}

	@Test
	fun h_eliminarPorId() {
		val productosDelServicio = inventarioService.obtenerTodos()
		assert(productosDelServicio.isNotEmpty()){"La lista de productos esta vacia"}
		val producto = productosDelServicio.last()

		val result:ProductoInvent = mockMvc.perform(MockMvcRequestBuilders.delete("$inventarioEndPoint/${producto.id}"))
			.andExpect(status().isOk)
			.bodyTo(mapper)

		assert(!inventarioService.obtenerTodos().contains(result))
	}

	@Test
	fun i_eliminarPorIdErrorEntidadNoEncontrada() {
		mockMvc.perform(MockMvcRequestBuilders.delete("$inventarioEndPoint/${UUID.randomUUID()}"))
			.andExpect(status().isConflict)
			.andExpect(jsonPath("$.titulo", Matchers.`is`("EntityNotFoundException")))
	}
*/
}
