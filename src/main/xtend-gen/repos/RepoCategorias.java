package repos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import conector.QueryPerteneceCategoria;
import dominio.Categoria;
import dominio.Contenido;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoCategorias {
  private List<Categoria> listaCategorias = CollectionLiterals.<Categoria>newArrayList();
  
  private static RepoCategorias categorias;
  
  @JsonIgnore
  private int i;
  
  public static RepoCategorias getInstance() {
    RepoCategorias _xblockexpression = null;
    {
      if ((RepoCategorias.categorias == null)) {
        RepoCategorias _repoCategorias = new RepoCategorias();
        RepoCategorias.categorias = _repoCategorias;
      }
      _xblockexpression = RepoCategorias.categorias;
    }
    return _xblockexpression;
  }
  
  public boolean create(final Categoria categoria) {
    return this.listaCategorias.add(categoria);
  }
  
  public List<Categoria> vaciar() {
    return this.listaCategorias = CollectionLiterals.<Categoria>newArrayList();
  }
  
  public void insertarCategorias(final Contenido contenido) {
    QueryPerteneceCategoria pertenece = new QueryPerteneceCategoria();
    pertenece.llenar(contenido.getIdContenido());
    for (this.i = 0; (this.i < ((Object[])Conversions.unwrapArray(contenido.getListaCategorias(), Object.class)).length); this.i++) {
      pertenece.agregarRelacion(contenido.getIdContenido(), contenido.getListaCategorias().get(this.i));
    }
  }
  
  public void vaciarCategorias(final Contenido contenido, final int tamaño) {
    QueryPerteneceCategoria pertenece = new QueryPerteneceCategoria();
    pertenece.llenar(contenido.getIdContenido());
    for (this.i = 201; (this.i < (tamaño + 201)); this.i++) {
      pertenece.borrarRelacion(contenido.getIdContenido(), Integer.toString(this.i));
    }
  }
  
  @Pure
  public List<Categoria> getListaCategorias() {
    return this.listaCategorias;
  }
  
  public void setListaCategorias(final List<Categoria> listaCategorias) {
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
