package repos;

import dominio.Titulo;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoTitulos {
  private List<Titulo> listaTitulo = CollectionLiterals.<Titulo>newArrayList();
  
  private static RepoTitulos titulos;
  
  public static RepoTitulos getInstance() {
    RepoTitulos _xblockexpression = null;
    {
      if ((RepoTitulos.titulos == null)) {
        RepoTitulos _repoTitulos = new RepoTitulos();
        RepoTitulos.titulos = _repoTitulos;
      }
      _xblockexpression = RepoTitulos.titulos;
    }
    return _xblockexpression;
  }
  
  public boolean create(final Titulo titulo) {
    return this.listaTitulo.add(titulo);
  }
  
  public List<Titulo> vaciar() {
    return this.listaTitulo = CollectionLiterals.<Titulo>newArrayList();
  }
  
  @Pure
  public List<Titulo> getListaTitulo() {
    return this.listaTitulo;
  }
  
  public void setListaTitulo(final List<Titulo> listaTitulo) {
    this.listaTitulo = listaTitulo;
  }
}
