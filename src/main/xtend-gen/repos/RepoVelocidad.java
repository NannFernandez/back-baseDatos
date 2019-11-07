package repos;

import dominio.VelocidadTransf;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class RepoVelocidad {
  private List<VelocidadTransf> listaVelocidad = CollectionLiterals.<VelocidadTransf>newArrayList();
  
  private static RepoVelocidad velocidades;
  
  public static RepoVelocidad getInstance() {
    RepoVelocidad _xblockexpression = null;
    {
      if ((RepoVelocidad.velocidades == null)) {
        RepoVelocidad _repoVelocidad = new RepoVelocidad();
        RepoVelocidad.velocidades = _repoVelocidad;
      }
      _xblockexpression = RepoVelocidad.velocidades;
    }
    return _xblockexpression;
  }
  
  public boolean create(final VelocidadTransf velocidad) {
    return this.listaVelocidad.add(velocidad);
  }
}
