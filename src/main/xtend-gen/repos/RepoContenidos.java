package repos;

import dominio.Contenido;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
}
