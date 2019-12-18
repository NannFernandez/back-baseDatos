package controller

import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.api.annotation.Controller
import repos.RepoVelocidad
import repos.RepoContenidos
import repos.RepoEncuestas
import repos.RepoCategorias
import repos.RepoTitulos
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Get
import org.omg.CORBA.UserException
import conector.QueryContenido
import conector.QueryCategoria
import conector.QueryVelocidad
import conector.QueryTitulos
import conector.QueryEncuesta
import java.text.SimpleDateFormat
import java.util.Date
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.http.ContentType
import dominio.Contenido
import conector.QueryDelete
import conector.QueryInsert
import conector.QueryUpdate

@Controller
class InfoMultimediaController {
	extension JSONUtils = new JSONUtils
	RepoVelocidad velocidades = RepoVelocidad.getInstance
	RepoContenidos contenidos = RepoContenidos.getInstance
	RepoEncuestas encuestas = RepoEncuestas.getInstance
	RepoCategorias categorias = RepoCategorias.getInstance
	RepoTitulos titulos = RepoTitulos.getInstance
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Get('/contenidos')
	def Result contenido() {

		var contenido = new QueryContenido
		contenido.llenar

		try {

			ok((contenidos.listaContenidos).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/contenidos/:id')
	def Result contenido() {

		var contenido = new QueryContenido
		contenido.llenar

		try {

			ok((contenidos.buscar(id)).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/categoria')
	def Result categoria() {

		var categoria = new QueryCategoria
		categoria.llenar

		try {

			ok((categorias.listaCategorias).toJson)
		} catch (UserException e) {
		}
	}

    
	
	@Put("/contenidos/borrar/:id") // polemico , ver mejor 
	def borrar() {
		var delete = new QueryDelete

		try {
			delete.borrar(id)
		} catch (Exception e) {
			badRequest(e.message)
		}

	}
	
	@Put("/contenidos/agregar") // polemico , ver mejor 
	/*Falta Probarlo */ def agregar(@Body String body) {
		response.contentType = ContentType.APPLICATION_JSON
		var agregar = new QueryInsert

		try {
			val actualizado = body.fromJson(Contenido)
			agregar.insert(actualizado)

			ok('{ "status" : "OK" }');
		} catch (Exception e) {
			badRequest(e.message)
		}

	}

	@Put("/contenidos/modificar") 
	/*Falta Probarlo */def modificar(@Body String body) {
		response.contentType = ContentType.APPLICATION_JSON
		var update = new QueryUpdate

		try {
			val actualizado = body.fromJson(Contenido)
			update.modificar(actualizado)
			ok('{ "status" : "OK" }');

		} catch (Exception e) {
			badRequest(e.message)
		}

	}

	@Get('/velTransfAsc/:registros')
	def Result velTransfAsc() {

		var velocidad = new QueryVelocidad
		velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_ASC(?)", Integer.parseInt(registros))

		try {

			ok((velocidades.listaVelocidad).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/velTransfDesc/:registros')
	def Result velTransfDesc() {

		var velocidad = new QueryVelocidad
		velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_DESC(?)", Integer.parseInt(registros))

		try {

			ok((velocidades.listaVelocidad).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/velTransfMediaAsc/:registros')
	def Result velTransfMediaAsc() {

		var titulo = new QueryTitulos
		
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_TRANSF(?)", Integer.parseInt(registros))
		
		
		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/velTransfMediaDesc/:registros')
	def Result velTransfMediaDesc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_TRANSF(?)", Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/velEdadMediaAsc/:registros')
	def Result velEdadMediaAsc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_EDAD(?)", Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/velEdadMediaDesc/:registros')
	def Result velEdadMediaDesc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_EDAD(?)", Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/mediaPuntajeAsc/:registros/:desde/:hasta')
	def Result mediaPuntajeAsc() {

		var fechaDesde = sdf.parse(desde);
		var fechaDesdeParser = new java.sql.Date(fechaDesde.getTime())
		var fechaHasta = sdf.parse(desde);
		var fechaHastaParser = new java.sql.Date(fechaHasta.getTime())

		var encuesta = new QueryEncuesta

		encuesta.llenar("CALL MEDIA_PUNTAJE_ASC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser,
			fechaHastaParser)

		try {

			ok((encuestas.listaEncuestas).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/mediaPuntajeDesc/:registros/:desde/:hasta')
	def Result mediaPuntajeDesc() {

		var fechaDesde = sdf.parse(desde);
		var fechaDesdeParser = new java.sql.Date(fechaDesde.getTime())
		var fechaHasta = sdf.parse(desde);
		var fechaHastaParser = new java.sql.Date(fechaHasta.getTime())

		var encuesta = new QueryEncuesta

		encuesta.llenar("CALL MEDIA_PUNTAJE_DESC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser,
			fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/mediaEncuestaDesc/:registros/:desde/:hasta')
	def Result mediaEncuestaDesc() {

		var fechaDesde = sdf.parse(desde);
		var fechaDesdeParser = new java.sql.Date(fechaDesde.getTime())
		var fechaHasta = sdf.parse(desde);
		var fechaHastaParser = new java.sql.Date(fechaHasta.getTime())

		var encuesta = new QueryEncuesta

		encuesta.llenar("CALL MEDIA_ENCUESTA_DESC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser,
			fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	@Get('/mediaEncuestaAsc/:registros/:desde/:hasta')
	def Result mediaEncuestaAsc() {

		var fechaDesde = sdf.parse(desde);
		var fechaDesdeParser = java.sql.Date.valueOf("1990-09-04")
		var fechaHasta = sdf.parse(hasta);
		var fechaHastaParser = java.sql.Date.valueOf("2019-09-04")

		var encuesta = new QueryEncuesta

		encuesta.llenar("CALL MEDIA_ENCUESTA_ASC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser,
			fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}

	

}
