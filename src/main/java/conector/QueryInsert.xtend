package conector

import java.sql.*
import javax.swing.JOptionPane
import dominio.Contenido
import java.util.Date;

class QueryInsert {
	
	
	def insert(Contenido contenido) {
	
	
		try {
			var Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mydogpupy170312")
			var PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL AGREGAR_CONTENIDO(?, ?, ?, ?, ?,?)")
			sentenciaSQL.setInt(1,Integer.parseInt(contenido.idContenido))
			sentenciaSQL.setString(2,contenido.titulo)
			sentenciaSQL.setString(3,contenido.fechaPublicacion)
			sentenciaSQL.setString(4,contenido.extensionArchivo)
			sentenciaSQL.setString(5, "Descargable")
			sentenciaSQL.setString(6, contenido.url)
			sentenciaSQL.executeQuery()
			System.out.println("\nContenido agregado con exito ;)")
		} catch (Exception e) {
			System.out.println("\nNO HUBO CONEXION!")
			e.printStackTrace()
		}

	}
}
