package conector;

import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class QueryInsert {
  public void insert(final Contenido contenido) {
    try {
      Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO(?, ?, ?, ?, ?)");
      sentenciaSQL.setInt(1, Integer.parseInt(contenido.getIdContenido()));
      sentenciaSQL.setString(2, contenido.getTitulo());
      sentenciaSQL.setString(3, contenido.getFechaPublicacion());
      sentenciaSQL.setString(4, contenido.getExtensionArchivo());
      sentenciaSQL.setString(5, "Descargable");
      sentenciaSQL.executeQuery();
      System.out.println("\nContenido agregado con exito ;)");
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
