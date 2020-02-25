package conector;

import conector.QueryCategoria;
import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.eclipse.xtext.xbase.lib.Exceptions;
import repos.RepoCategorias;

@SuppressWarnings("all")
public class QueryInsert {
  private RepoCategorias repoCategorias = RepoCategorias.getInstance();
  
  public void insert(final Contenido contenido) {
    this.repoCategorias.vaciar();
    QueryCategoria categoria = new QueryCategoria();
    try {
      categoria.llenar();
      Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO(?, ?, ?, ?, ?,?)");
      double _random = Math.random();
      double _multiply = (_random * 999);
      double _plus = (_multiply + 300);
      double _floor = Math.floor(_plus);
      contenido.setIdContenido(Integer.toString(((int) _floor)));
      sentenciaSQL.setInt(1, Integer.parseInt(contenido.getIdContenido()));
      sentenciaSQL.setString(2, contenido.getTitulo());
      sentenciaSQL.setString(3, contenido.getFechaPublicacion());
      sentenciaSQL.setString(4, contenido.getExtensionArchivo());
      sentenciaSQL.setString(5, "Descargable");
      sentenciaSQL.setString(6, contenido.getUrl());
      sentenciaSQL.executeQuery();
      this.repoCategorias.insertarCategorias(contenido);
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
