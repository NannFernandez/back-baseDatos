package conector;

import dominio.Titulo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoTitulos;

@Accessors
@SuppressWarnings("all")
public class QueryTitulos {
  private RepoTitulos titulos = RepoTitulos.getInstance();
  
  public void llenar(final String query, final int registros) {
    this.titulos.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mydogpupy170312");
      PreparedStatement unStatement = unaConexion.prepareStatement(query);
      unStatement.setInt(1, registros);
      ResultSet unResultSet = unStatement.executeQuery();
      while (unResultSet.next()) {
        {
          String idContenido = unResultSet.getString("IDCONTENIDO");
          String tituloContenido = unResultSet.getString("TITULO");
          String edad = unResultSet.getString("EDAD_MEDIA");
          String transf = unResultSet.getString("TRANSF_MEDIA");
          Titulo titulo = new Titulo(idContenido, tituloContenido, edad, transf);
          this.titulos.create(titulo);
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
  public RepoTitulos getTitulos() {
    return this.titulos;
  }
  
  public void setTitulos(final RepoTitulos titulos) {
    this.titulos = titulos;
  }
}
