package dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dominio.Categoria;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Contenido {
  private String idContenido;
  
  private String titulo;
  
  private String fechaPublicacion;
  
  private String extensionArchivo;
  
  private String url;
  
  @JsonIgnore
  private List<String> categorias = CollectionLiterals.<String>newArrayList();
  
  private List<String> listaCategorias = CollectionLiterals.<String>newArrayList();
  
  @JsonIgnore
  private int i;
  
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
    this.categorias = _listaCategorias;
  }
  
  public List<String> asignarCategorias(final List<Categoria> _categorias) {
    List<String> _xblockexpression = null;
    {
      for (this.i = 0; (this.i < ((Object[])Conversions.unwrapArray(_categorias, Object.class)).length); this.i++) {
        this.listaCategorias.add(_categorias.get(this.i).getIdCategoria());
      }
      _xblockexpression = this.categorias = this.listaCategorias;
    }
    return _xblockexpression;
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
  public List<String> getCategorias() {
    return this.categorias;
  }
  
  public void setCategorias(final List<String> categorias) {
    this.categorias = categorias;
  }
  
  @Pure
  public List<String> getListaCategorias() {
    return this.listaCategorias;
  }
  
  public void setListaCategorias(final List<String> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }
  
  @Pure
  public int getI() {
    return this.i;
  }
  
  public void setI(final int i) {
    this.i = i;
  }
}
