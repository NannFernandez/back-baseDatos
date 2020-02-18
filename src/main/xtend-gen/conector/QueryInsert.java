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
      PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO(?, ?, ?, ?, ?,?)");
      double _random = Math.random();
      double _multiply = (_random * 200);
      double _plus = (_multiply + 1);
      double _floor = Math.floor(_plus);
      sentenciaSQL.setInt(1, ((int) _floor));
      sentenciaSQL.setString(2, contenido.getTitulo());
      sentenciaSQL.setString(3, contenido.getFechaPublicacion());
      sentenciaSQL.setString(4, contenido.getExtensionArchivo());
      sentenciaSQL.setString(5, "Descargable");
      sentenciaSQL.setString(6, contenido.getUrl());
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
