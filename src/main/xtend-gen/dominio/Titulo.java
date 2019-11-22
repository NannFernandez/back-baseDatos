package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Titulo {
  private String idContenido = "";
  
  private String titulo = "";
  
  private String edadMedia = "";
  
  private String trasnfMedia = "";
  
  public Titulo(final String _id, final String _titulo, final String _edad, final String _transf) {
    this.idContenido = _id;
    this.titulo = _titulo;
    this.edadMedia = _edad;
    this.trasnfMedia = _transf;
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
  public String getEdadMedia() {
    return this.edadMedia;
  }
  
  public void setEdadMedia(final String edadMedia) {
    this.edadMedia = edadMedia;
  }
  
  @Pure
  public String getTrasnfMedia() {
    return this.trasnfMedia;
  }
  
  public void setTrasnfMedia(final String trasnfMedia) {
    this.trasnfMedia = trasnfMedia;
  }
}
