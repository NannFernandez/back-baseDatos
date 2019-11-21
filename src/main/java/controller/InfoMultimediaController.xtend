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

	@Get('/categoria')
	def Result categoria() {

		var categoria = new QueryCategoria
		categoria.llenar

		try {

			ok((categorias.listaCategorias).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velTransfAsc/:registros')
	def Result velTransfAsc() {

		var velocidad = new QueryVelocidad
		velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_ASC(?)",Integer.parseInt(registros))

		try {

			ok((velocidades.listaVelocidad).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velTransfAsc/:registros')
	def Result velTransfDesc() {

		var velocidad = new QueryVelocidad
		velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_DESC(?)",Integer.parseInt(registros))

		try {

			ok((velocidades.listaVelocidad).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velTransfMediaDesc/:registros')
	def Result velTransfMediaDesc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_TRANSF(?)",Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velTransfMediaAsc/:registros')
	def Result velTransfMediaAsc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_TRANSF(?)",Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velEdadMediaAsc/:registros')
	def Result velEdadMediaAsc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_EDAD(?)",Integer.parseInt(registros))

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/velEdadMediaDesc/:registros')
	def Result velEdadMediaDesc() {

		var titulo = new QueryTitulos
		titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_EDAD(?)",Integer.parseInt(registros))

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
		
		encuesta.llenar("CALL MEDIA_PUNTAJE_ASC(?, ?, ?)",Integer.parseInt(registros),fechaDesdeParser,fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
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
		
		encuesta.llenar("CALL MEDIA_PUNTAJE_DESC(?, ?, ?)",Integer.parseInt(registros),fechaDesdeParser,fechaHastaParser)

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
		
		encuesta.llenar("CALL MEDIA_ENCUESTA_DESC(?, ?, ?)",Integer.parseInt(registros),fechaDesdeParser,fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}
	
	@Get('/mediaEncuestaAsc/:registros/:desde/:hasta')
	def Result mediaEncuestaAsc() {
		
		var fechaDesde = sdf.parse(desde);
		var fechaDesdeParser = new java.sql.Date(fechaDesde.getTime())
		var fechaHasta = sdf.parse(desde);
		var fechaHastaParser = new java.sql.Date(fechaHasta.getTime())
		 
		var encuesta = new QueryEncuesta
		
		encuesta.llenar("CALL MEDIA_ENCUESTA_ASC(?, ?, ?)",Integer.parseInt(registros),fechaDesdeParser,fechaHastaParser)

		try {

			ok((titulos.listaTitulo).toJson)
		} catch (UserException e) {
		}
	}
	
	

}
