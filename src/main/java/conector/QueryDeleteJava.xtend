package conector

import java.sql.*
import javax.swing.JOptionPane

class QueryDeleteJava {
	def static void main(String[] args) {
		try {
			var Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
				"mydogpupy170312")
			var PreparedStatement sentenciaSQL = miConexion.prepareStatement("CALL ELIMINAR_CONTENIDO(?)")
			sentenciaSQL.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Id contenido: ")))
			sentenciaSQL.executeQuery()
			System.out.println("\nContenido eliminado con exito ;)")
		} catch (Exception e) {
			System.out.println("\nNO HUBO CONEXION!")
			e.printStackTrace()
		}

	}
}
