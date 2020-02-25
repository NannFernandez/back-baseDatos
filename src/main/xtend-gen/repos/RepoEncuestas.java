package repos;

import dominio.Encuesta;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoEncuestas {
  private List<Encuesta> listaEncuestas = CollectionLiterals.<Encuesta>newArrayList();
  
  private static RepoEncuestas encuestas;
  
  public static RepoEncuestas getInstance() {
    RepoEncuestas _xblockexpression = null;
    {
      if ((RepoEncuestas.encuestas == null)) {
        RepoEncuestas _repoEncuestas = new RepoEncuestas();
        RepoEncuestas.encuestas = _repoEncuestas;
      }
      _xblockexpression = RepoEncuestas.encuestas;
    }
    return _xblockexpression;
  }
  
  public boolean create(final Encuesta encuesta) {
    return this.listaEncuestas.add(encuesta);
  }
  
  public List<Encuesta> vaciar() {
    return this.listaEncuestas = CollectionLiterals.<Encuesta>newArrayList();
  }
  
  @Pure
  public List<Encuesta> getListaEncuestas() {
    return this.listaEncuestas;
  }
  
  public void setListaEncuestas(final List<Encuesta> listaEncuestas) {
    this.listaEncuestas = listaEncuestas;
  }
}
