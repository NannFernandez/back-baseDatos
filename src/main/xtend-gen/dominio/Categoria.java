package dominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Categoria {
  private String idCategoria;
  
  private String descCategoria;
  
  public Categoria(final String _id, final String _desc) {
    this.idCategoria = _id;
    this.descCategoria = _desc;
  }
  
  @Pure
  public String getIdCategoria() {
    return this.idCategoria;
  }
  
  public void setIdCategoria(final String idCategoria) {
    this.idCategoria = idCategoria;
  }
  
  @Pure
  public String getDescCategoria() {
    return this.descCategoria;
  }
  
  public void setDescCategoria(final String descCategoria) {
    this.descCategoria = descCategoria;
  }
}
