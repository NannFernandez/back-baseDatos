package repos;

import dominio.Encuesta;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
}
