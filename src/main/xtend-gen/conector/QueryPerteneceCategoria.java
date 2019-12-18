package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class QueryPerteneceCategoria {
  public ResultSet borrarRelacion(final String idContenido, final String idCategoria) {
    ResultSet _xtrycatchfinallyexpression = null;
    try {
      ResultSet _xblockexpression = null;
      {
        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
        PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ELIMINAR_CONTENIDO_PERTENECE_CATEGORIA(?, ?)");
        sentenciaSQL.setInt(1, Integer.parseInt(idContenido));
        sentenciaSQL.setInt(2, Integer.parseInt(idCategoria));
        _xblockexpression = sentenciaSQL.executeQuery();
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        System.out.println("\nNO HUBO CONEXION!");
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public ResultSet agregarRelacion(final String idContenido, final String idCategoria) {
    ResultSet _xtrycatchfinallyexpression = null;
    try {
      ResultSet _xblockexpression = null;
      {
        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", 
          "150696");
        PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO_PERTENECE_CATEGORIA(?, ?)");
        sentenciaSQL.setInt(1, Integer.parseInt(idContenido));
        sentenciaSQL.setInt(2, Integer.parseInt(idCategoria));
        _xblockexpression = sentenciaSQL.executeQuery();
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        System.out.println("\nNO HUBO CONEXION!");
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
