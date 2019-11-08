package repos;

import dominio.Categoria;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoCategorias {
  private List<Categoria> listaCategorias = CollectionLiterals.<Categoria>newArrayList();
  
  private static RepoCategorias categorias;
  
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
  
  @Pure
  public List<Categoria> getListaCategorias() {
    return this.listaCategorias;
  }
  
  public void setListaCategorias(final List<Categoria> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }
}
