package dominio;

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
}
