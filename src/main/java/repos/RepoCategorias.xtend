package repos

import dominio.Categoria
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
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
	
	def vaciar() {
		listaCategorias = newArrayList
	}
	
}