package conector;

import conector.QueryPerteneceCategoria;
import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoCategorias;
import repos.RepoContenidos;

@Accessors
@SuppressWarnings("all")
public class QueryContenido {
  private RepoContenidos contenidos = RepoContenidos.getInstance();
  
  private RepoCategorias categorias = RepoCategorias.getInstance();
  
  public void llenar() {
    this.contenidos.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      Statement unStatement = unaConexion.createStatement();
      ResultSet unResultSet = unStatement.executeQuery("CALL MOSTRAR_CONTENIDO()");
      while (unResultSet.next()) {
        {
          this.categorias.vaciar();
          QueryPerteneceCategoria pertenece = new QueryPerteneceCategoria();
          String idContenido = unResultSet.getString("idContenido");
          String titulo = unResultSet.getString("titulo");
          String fechaPublicacion = unResultSet.getString("fechaPublicacion");
          String extensionArchivo = unResultSet.getString("extensionArchivo");
          String url = unResultSet.getString("url");
          pertenece.llenar(idContenido);
          Contenido contenido = new Contenido(idContenido, titulo, fechaPublicacion, extensionArchivo, url);
          contenido.asignarCategorias(this.categorias.getListaCategorias());
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
  
  @Pure
  public RepoContenidos getContenidos() {
    return this.contenidos;
  }
  
  public void setContenidos(final RepoContenidos contenidos) {
    this.contenidos = contenidos;
  }
  
  @Pure
  public RepoCategorias getCategorias() {
    return this.categorias;
  }
  
  public void setCategorias(final RepoCategorias categorias) {
    this.categorias = categorias;
  }
}
