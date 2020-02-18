package dominio;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Contenido {
  private String idContenido;
  
  private String titulo;
  
  private String fechaPublicacion;
  
  private String extensionArchivo;
  
  private String url;
  
  private List<String> listaCategorias = CollectionLiterals.<String>newArrayList();
  
  public Contenido() {
  }
  
  public Contenido(final String contenido, final String _titulo, final String fecha, final String ext, final String _url) {
    this.idContenido = contenido;
    this.titulo = _titulo;
    this.fechaPublicacion = fecha;
    this.extensionArchivo = ext;
    this.url = _url;
  }
  
  public Contenido(final String contenido, final String _titulo, final String fecha, final String ext, final String _url, final List<String> _listaCategorias) {
    this.idContenido = contenido;
    this.titulo = _titulo;
    this.fechaPublicacion = fecha;
    this.extensionArchivo = ext;
    this.url = _url;
    this.listaCategorias = _listaCategorias;
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
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(final String url) {
    this.url = url;
  }
  
  @Pure
  public List<String> getListaCategorias() {
    return this.listaCategorias;
  }
  
  public void setListaCategorias(final List<String> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }
}
