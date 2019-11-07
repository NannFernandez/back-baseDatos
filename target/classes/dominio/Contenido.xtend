package dominio

class Contenido {
	String idContenido 
	String titulo 
	String fechaPublicacion 
	String extensionArchivo 
	String tipoArchivo
	
	
	new(String contenido,String _titulo,String fecha, String ext,String tipo){
		
	idContenido =contenido
	titulo = _titulo
	fechaPublicacion =fecha
	extensionArchivo =ext
	tipoArchivo=tipo
		
		
	}
}