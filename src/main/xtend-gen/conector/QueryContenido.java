package conector;

import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.xtext.xbase.lib.Exceptions;
import repos.RepoContenidos;

@SuppressWarnings("all")
public class QueryContenido {
  private RepoContenidos contenidos = RepoContenidos.getInstance();
  
  public void llenarContenidos() {
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
      Statement unStatement = unaConexion.createStatement();
      ResultSet unResultSet = unStatement.executeQuery("SELECT * FROM CONTENIDO");
      while (unResultSet.next()) {
        {
          String idContenido = unResultSet.getString("idContenido");
          String titulo = unResultSet.getString("titulo");
          String fechaPublicacion = unResultSet.getString("fechaPublicacion");
          String extensionArchivo = unResultSet.getString("extensionArchivo");
          String tipoArchivo = unResultSet.getString("tipoArchivo");
          Contenido contenido = new Contenido(idContenido, titulo, fechaPublicacion, extensionArchivo, tipoArchivo);
          this.contenidos.create(contenido);
        }
      }
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
}
