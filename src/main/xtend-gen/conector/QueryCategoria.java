package conector;

import dominio.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoCategorias;

@Accessors
@SuppressWarnings("all")
public class QueryCategoria {
  private RepoCategorias categorias = RepoCategorias.getInstance();
  
  public void llenar() {
    this.categorias.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mydogpupy170312");
      Statement unStatement = unaConexion.createStatement();
      ResultSet unResultSet = unStatement.executeQuery("SELECT * FROM CATEGORIA");
      while (unResultSet.next()) {
        {
          String idCategoria = unResultSet.getString("idCategoria");
          String descCategoria = unResultSet.getString("categoriaDesc");
          Categoria categoria = new Categoria(idCategoria, descCategoria);
          this.categorias.create(categoria);
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
  
  @Pure
  public RepoCategorias getCategorias() {
    return this.categorias;
  }
  
  public void setCategorias(final RepoCategorias categorias) {
    this.categorias = categorias;
  }
}
