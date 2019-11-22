package conector;

import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoContenidos;

@Accessors
@SuppressWarnings("all")
public class QueryContenido {
  private RepoContenidos contenidos = RepoContenidos.getInstance();
  
  public void llenar() {
    this.contenidos.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      Statement unStatement = unaConexion.createStatement();
      ResultSet unResultSet = unStatement.executeQuery("CALL MOSTRAR_CONTENIDO()");
      while (unResultSet.next()) {
        {
          String idContenido = unResultSet.getString("idContenido");
          String titulo = unResultSet.getString("titulo");
          String fechaPublicacion = unResultSet.getString("fechaPublicacion");
          String extensionArchivo = unResultSet.getString("extensionArchivo");
          Contenido contenido = new Contenido(idContenido, titulo, fechaPublicacion, extensionArchivo);
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
}
