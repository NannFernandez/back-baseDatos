package conector;

import dominio.Encuesta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoEncuestas;

@Accessors
@SuppressWarnings("all")
public class QueryEncuesta {
  private RepoEncuestas encuestas = RepoEncuestas.getInstance();
  
  public void llenar(final String query, final int registros, final Date fechaDesde, final Date fechaHasta) {
    this.encuestas.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement unStatement = unaConexion.prepareStatement(query);
      unStatement.setInt(1, registros);
      unStatement.setDate(2, fechaDesde);
      unStatement.setDate(3, fechaHasta);
      ResultSet unResultSet = unStatement.executeQuery();
      while (unResultSet.next()) {
        {
          String titulo = unResultSet.getString("titulo");
          String ext = unResultSet.getString("extension");
          String fecha = unResultSet.getString("fecha");
          String mediaPuntaje = unResultSet.getString("media_puntaje");
          String cantEncuesta = unResultSet.getString("cantidad_encuesta");
          Encuesta encuesta = new Encuesta(titulo, ext, fecha, mediaPuntaje, cantEncuesta);
          this.encuestas.create(encuesta);
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
  public RepoEncuestas getEncuestas() {
    return this.encuestas;
  }
  
  public void setEncuestas(final RepoEncuestas encuestas) {
    this.encuestas = encuestas;
  }
}
