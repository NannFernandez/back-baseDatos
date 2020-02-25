package conector;

import conector.QueryCategoria;
import conector.QueryPerteneceCategoria;
import dominio.Contenido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import repos.RepoCategorias;

@SuppressWarnings("all")
public class QueryUpdate {
  private RepoCategorias repoCategorias = RepoCategorias.getInstance();
  
  public void modificar(final Contenido contenido) {
    this.repoCategorias.vaciar();
    QueryPerteneceCategoria pertenece = new QueryPerteneceCategoria();
    QueryCategoria categoria = new QueryCategoria();
    try {
      categoria.llenar();
      int tamaño = ((Object[])Conversions.unwrapArray(this.repoCategorias.getListaCategorias(), Object.class)).length;
      Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696");
      PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ACTUALIZAR_CONTENIDO(?, ?, ?, ?,?)");
      sentenciaSQL.setInt(1, Integer.parseInt(contenido.getIdContenido()));
      sentenciaSQL.setString(2, contenido.getTitulo());
      sentenciaSQL.setString(3, contenido.getFechaPublicacion());
      sentenciaSQL.setString(4, contenido.getExtensionArchivo());
      sentenciaSQL.setString(5, contenido.getUrl());
      sentenciaSQL.executeQuery();
      System.out.println("\nContenido modificado con exito ;)");
      this.repoCategorias.vaciarCategorias(contenido, tamaño);
      this.repoCategorias.insertarCategorias(contenido);
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
