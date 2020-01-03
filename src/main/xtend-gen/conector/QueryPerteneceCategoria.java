package conector;

import dominio.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import repos.RepoCategorias;

@SuppressWarnings("all")
public class QueryPerteneceCategoria {
  private RepoCategorias categorias = RepoCategorias.getInstance();
  
  public void llenar(final String idContenido) {
    this.categorias.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mydogpupy170312");
      PreparedStatement unStatement = unaConexion.prepareStatement("CALL CONTENIDO_CATEGORIAS(?)");
      unStatement.setInt(1, Integer.parseInt(idContenido));
      ResultSet unResultSet = unStatement.executeQuery();
      while (unResultSet.next()) {
        {
          String idCategoria = unResultSet.getString("CATEGORIA_IDCATEGORIA");
          Categoria cat = new Categoria(idCategoria);
          this.categorias.create(cat);
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
  
  public ResultSet borrarRelacion(final String idContenido, final String idCategoria) {
    ResultSet _xtrycatchfinallyexpression = null;
    try {
      ResultSet _xblockexpression = null;
      {
        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mydogpupy170312");
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
