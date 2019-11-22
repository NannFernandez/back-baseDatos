package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class QueryDelete {
  public void borrar(final String id) {
    try {
      Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ELIMINAR_CONTENIDO(?)");
      sentenciaSQL.setInt(1, Integer.parseInt(id));
      sentenciaSQL.executeQuery();
      System.out.println("\nContenido eliminado con exito ;)");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        System.out.println("\nNO HUBO CONEXION!");
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
