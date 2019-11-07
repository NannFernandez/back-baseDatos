package dominio;

@SuppressWarnings("all")
public class Contenido {
  private String idContenido;
  
  private String titulo;
  
  private String fechaPublicacion;
  
  private String extensionArchivo;
  
  private String tipoArchivo;
  
  public Contenido(final String contenido, final String _titulo, final String fecha, final String ext, final String tipo) {
    this.idContenido = contenido;
    this.titulo = _titulo;
    this.fechaPublicacion = fecha;
    this.extensionArchivo = ext;
    this.tipoArchivo = tipo;
  }
}
