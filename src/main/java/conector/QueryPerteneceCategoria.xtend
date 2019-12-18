package conector
import java.sql.*
import javax.swing.JOptionPane
import dominio.Contenido


class QueryPerteneceCategoria {
	def borrarRelacion(String idContenido ,String idCategoria) {
		try {
			var Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "150696")
				var PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ELIMINAR_CONTENIDO_PERTENECE_CATEGORIA(?, ?)")
			    sentenciaSQL.setInt(1, Integer.parseInt(idContenido))
         	    sentenciaSQL.setInt(2, Integer.parseInt(idCategoria))
         	    sentenciaSQL.executeQuery()
				} catch (Exception e) {
			System.out.println("\nNO HUBO CONEXION!")
			e.printStackTrace()
		}
				}
				
  def agregarRelacion(String idContenido ,String idCategoria) {
		try {
			var Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
				"150696")
				var PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO_PERTENECE_CATEGORIA(?, ?)")
			    sentenciaSQL.setInt(1, Integer.parseInt(idContenido))
         	    sentenciaSQL.setInt(2, Integer.parseInt(idCategoria))
				sentenciaSQL.executeQuery()
				} catch (Exception e) {
			System.out.println("\nNO HUBO CONEXION!")
			e.printStackTrace()
		}
				}
}