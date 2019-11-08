package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
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
  
  @Pure
  public String getTitulo() {
    return this.titulo;
  }
  
  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }
  
  @Pure
  public String getExtensionArchivo() {
    return this.extensionArchivo;
  }
  
  public void setExtensionArchivo(final String extensionArchivo) {
    this.extensionArchivo = extensionArchivo;
  }
  
  @Pure
  public String getIdDesacarga() {
    return this.idDesacarga;
  }
  
  public void setIdDesacarga(final String idDesacarga) {
    this.idDesacarga = idDesacarga;
  }
  
  @Pure
  public String getVelocidadTransf() {
    return this.velocidadTransf;
  }
  
  public void setVelocidadTransf(final String velocidadTransf) {
    this.velocidadTransf = velocidadTransf;
  }
}
