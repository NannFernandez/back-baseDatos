package dominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Contenido {
	String idContenido 
	String titulo 
	String fechaPublicacion 
	String extensionArchivo 
	
	
	new(String contenido,String _titulo,String fecha, String ext){
		
	idContenido =contenido
	titulo = _titulo
	fechaPublicacion =fecha
	extensionArchivo =ext		
		
	}
}