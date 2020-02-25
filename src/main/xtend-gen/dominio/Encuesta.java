package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Encuesta {
  private String titulo;
  
  private String ext;
  
  private String fecha;
  
  private String mediaPuntaje;
  
  private String cantEncuestas;
  
  public Encuesta(final String _titulo, final String _ext, final String _fecha, final String _mediaPuntaje, final String _cantEncuestas) {
    this.titulo = _titulo;
    this.ext = _ext;
    this.fecha = _fecha;
    this.mediaPuntaje = _mediaPuntaje;
    this.cantEncuestas = _cantEncuestas;
  }
  
  @Pure
  public String getTitulo() {
    return this.titulo;
  }
  
  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }
  
  @Pure
  public String getExt() {
    return this.ext;
  }
  
  public void setExt(final String ext) {
    this.ext = ext;
  }
  
  @Pure
  public String getFecha() {
    return this.fecha;
  }
  
  public void setFecha(final String fecha) {
    this.fecha = fecha;
  }
  
  @Pure
  public String getMediaPuntaje() {
    return this.mediaPuntaje;
  }
  
  public void setMediaPuntaje(final String mediaPuntaje) {
    this.mediaPuntaje = mediaPuntaje;
  }
  
  @Pure
  public String getCantEncuestas() {
    return this.cantEncuestas;
  }
  
  public void setCantEncuestas(final String cantEncuestas) {
    this.cantEncuestas = cantEncuestas;
  }
}
