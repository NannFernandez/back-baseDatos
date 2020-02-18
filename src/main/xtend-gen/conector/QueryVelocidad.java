package conector;

import dominio.VelocidadTransf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoVelocidad;

/**
 * "CALL MOSTRAR_VELOC_TRANSF_DESC(?)"
 */
@Accessors
@SuppressWarnings("all")
public class QueryVelocidad {
  private RepoVelocidad velocidades = RepoVelocidad.getInstance();
  
  public void llenar(final String query, final int registros) {
    this.velocidades.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement unStatement = unaConexion.prepareStatement(query);
      unStatement.setInt(1, registros);
      ResultSet unResultSet = unStatement.executeQuery();
      while (unResultSet.next()) {
        {
          String titulo = unResultSet.getString("titulo");
          String extensionArchivo = unResultSet.getString("extensionarchivo");
          String idDescarga = unResultSet.getString("iddescarga");
          String velocidadTransf = unResultSet.getString("velocidadtransf");
          VelocidadTransf velocidad = new VelocidadTransf(titulo, extensionArchivo, idDescarga, velocidadTransf);
          this.velocidades.create(velocidad);
        }
      }
      unResultSet.close();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        System.out.println("No hubo conexion!!");
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Pure
  public RepoVelocidad getVelocidades() {
    return this.velocidades;
  }
  
  public void setVelocidades(final RepoVelocidad velocidades) {
    this.velocidades = velocidades;
  }
}
