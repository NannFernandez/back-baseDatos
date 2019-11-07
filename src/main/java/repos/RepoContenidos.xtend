package repos

import java.util.List
import dominio.Contenido

class RepoContenidos {

	List<Contenido> listaContenidos = newArrayList
	static RepoContenidos contenidos

	def static RepoContenidos getInstance() {
		if (contenidos === null)
			contenidos = new RepoContenidos
		contenidos
	}

	def create(Contenido contenido) {

		listaContenidos.add(contenido)

	}
}
