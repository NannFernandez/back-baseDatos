package conector

import java.sql.*
import javax.swing.JOptionPane
import dominio.Contenido

class QueryUpdateJava {
	def modificar(Contenido contenido) {
		try {
			var Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
				"mydogpupy170312")
			var PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ACTUALIZAR_CONTENIDO(?, ?, ?, ?, ?)")
			sentenciaSQL.setInt(1, Integer.parseInt(contenido.idContenido))
         	sentenciaSQL.setString(2, contenido.titulo)
			sentenciaSQL.setString(3, contenido.fechaPublicacion)
			sentenciaSQL.setString(4, contenido.extensionArchivo)
			sentenciaSQL.executeQuery()
			System.out.println("\nContenido modificado con exito ;)")
		} catch (Exception e) {
			System.out.println("\nNO HUBO CONEXION!")
			e.printStackTrace()
		}

	}
}
