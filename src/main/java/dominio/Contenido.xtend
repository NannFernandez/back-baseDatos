package dominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Contenido {
	String idContenido 
	String titulo 
	String fechaPublicacion 
	String extensionArchivo 
    String url
	
	
	new(String contenido,String _titulo,String fecha, String ext,String _url){
		
	idContenido =contenido
	titulo = _titulo
	fechaPublicacion =fecha
	extensionArchivo =ext		
    url = _url		
	}
}