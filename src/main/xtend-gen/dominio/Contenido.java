package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
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
  
  @Pure
  public String getIdContenido() {
    return this.idContenido;
  }
  
  public void setIdContenido(final String idContenido) {
    this.idContenido = idContenido;
  }
  
  @Pure
  public String getTitulo() {
    return this.titulo;
  }
  
  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }
  
  @Pure
  public String getFechaPublicacion() {
    return this.fechaPublicacion;
  }
  
  public void setFechaPublicacion(final String fechaPublicacion) {
    this.fechaPublicacion = fechaPublicacion;
  }
  
  @Pure
  public String getExtensionArchivo() {
    return this.extensionArchivo;
  }
  
  public void setExtensionArchivo(final String extensionArchivo) {
    this.extensionArchivo = extensionArchivo;
  }
  
  @Pure
  public String getTipoArchivo() {
    return this.tipoArchivo;
  }
  
  public void setTipoArchivo(final String tipoArchivo) {
    this.tipoArchivo = tipoArchivo;
  }
}
