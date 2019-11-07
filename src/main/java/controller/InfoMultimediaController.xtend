package controller

import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.api.annotation.Controller
import repos.RepoVelocidad
import repos.RepoContenidos
import repos.RepoEncuestas
import repos.RepoCategorias

@Controller
class InfoMultimediaController {
	extension JSONUtils = new JSONUtils
	RepoVelocidad velocidades=	RepoVelocidad.getInstance
	RepoContenidos contenidos=	RepoContenidos.getInstance
	RepoEncuestas encuestas=	RepoEncuestas.getInstance
	RepoCategorias categorias = RepoCategorias.getInstance
}