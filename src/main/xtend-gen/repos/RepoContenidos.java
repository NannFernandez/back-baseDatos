package repos;

import com.google.common.base.Objects;
import dominio.Contenido;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public Contenido buscar(final String id) {
    final Function1<Contenido, Boolean> _function = (Contenido elemento) -> {
      String _idContenido = elemento.getIdContenido();
      return Boolean.valueOf(Objects.equal(_idContenido, id));
    };
    return IterableExtensions.<Contenido>findFirst(this.listaContenidos, _function);
  }
  
  @Pure
  public List<Contenido> getListaContenidos() {
    return this.listaContenidos;
  }
  
  public void setListaContenidos(final List<Contenido> listaContenidos) {
    this.listaContenidos = listaContenidos;
  }
}
