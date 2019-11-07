package repos

import dominio.Categoria
import java.util.List

class RepoCategorias {
	List<Categoria> listaCategorias = newArrayList
	static RepoCategorias categorias

	def static RepoCategorias getInstance() {
		if (categorias === null)
			categorias = new RepoCategorias
		categorias
	}

	def create(Categoria categoria) {

		listaCategorias.add(categoria)

	}
}