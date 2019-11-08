package repos;

import dominio.VelocidadTransf;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
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
  
  @Pure
  public List<VelocidadTransf> getListaVelocidad() {
    return this.listaVelocidad;
  }
  
  public void setListaVelocidad(final List<VelocidadTransf> listaVelocidad) {
    this.listaVelocidad = listaVelocidad;
  }
}
