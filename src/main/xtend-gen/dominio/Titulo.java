package dominio;

@SuppressWarnings("all")
public class Titulo {
  private String idContenido;
  
  private String titulo;
  
  private String edadMedia;
  
  private String trasnfMedia;
  
  public Titulo(final String _id, final String _titulo, final String _edad, final String _transf) {
    this.idContenido = _id;
    this.titulo = _titulo;
    this.edadMedia = _edad;
    this.trasnfMedia = _transf;
  }
}
