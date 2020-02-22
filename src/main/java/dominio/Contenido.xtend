package dominio

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

@Accessors
class Contenido {
	String idContenido 
	String titulo 
	String fechaPublicacion 
	String extensionArchivo 
    String url
    List<String> categorias = newArrayList

	// Necesario para fromJSON
	new() {

	}
	
	// para metodos anteriores que no mandan lista de categorias
	new(String contenido, String _titulo, String fecha, String ext, String _url){
		idContenido =contenido
		titulo = _titulo
		fechaPublicacion =fecha
		extensionArchivo =ext		
	    url = _url		
	}

	new(String contenido,String _titulo,String fecha, String ext,String _url, List<String> _listaCategorias) {
		idContenido =contenido
		titulo = _titulo
		fechaPublicacion =fecha
		extensionArchivo =ext		
	    url = _url		
	    categorias = _listaCategorias
	}

}