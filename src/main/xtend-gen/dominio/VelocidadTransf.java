package dominio;

@SuppressWarnings("all")
public class VelocidadTransf {
  private String titulo = "";
  
  private String extensionArchivo = "";
  
  private String idDesacarga = "";
  
  private String velocidadTransf = "";
  
  public VelocidadTransf(final String _titulo, final String _extensionArchivo, final String _idDesacarga, final String _velocidadTransf) {
    this.titulo = _titulo;
    this.extensionArchivo = _extensionArchivo;
    this.idDesacarga = _idDesacarga;
    this.velocidadTransf = _velocidadTransf;
  }
}
