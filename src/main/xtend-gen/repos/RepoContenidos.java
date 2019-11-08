package repos;

import dominio.Contenido;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoContenidos {
  private List<Contenido> listaContenidos = CollectionLiterals.<Contenido>newArrayList();
  
  private static RepoContenidos contenidos;
  
  public static RepoContenidos getInstance() {
    RepoContenidos _xblockexpression = null;
    {
      if ((RepoContenidos.contenidos == null)) {
        RepoContenidos _repoContenidos = new RepoContenidos();
        RepoContenidos.contenidos = _repoContenidos;
      }
      _xblockexpression = RepoContenidos.contenidos;
    }
    return _xblockexpression;
  }
  
  public boolean create(final Contenido contenido) {
    return this.listaContenidos.add(contenido);
  }
  
  public List<Contenido> vaciar() {
    return this.listaContenidos = CollectionLiterals.<Contenido>newArrayList();
  }
  
  @Pure
  public List<Contenido> getListaContenidos() {
    return this.listaContenidos;
  }
  
  public void setListaContenidos(final List<Contenido> listaContenidos) {
    this.listaContenidos = listaContenidos;
  }
}
