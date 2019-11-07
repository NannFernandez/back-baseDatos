package repos

import dominio.VelocidadTransf
import java.util.List

class RepoVelocidad {
	
	List<VelocidadTransf> listaVelocidad = newArrayList
	static RepoVelocidad velocidades

	def static RepoVelocidad getInstance() {
		if (velocidades === null)
			velocidades = new RepoVelocidad
		velocidades
	}

	def create(VelocidadTransf velocidad) {

		listaVelocidad.add(velocidad)

	}
	
	
}