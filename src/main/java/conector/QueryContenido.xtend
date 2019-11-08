package conector

import java.sql.*
import dominio.Contenido
import repos.RepoContenidos
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class QueryContenido {
	//def static void main(String[] args) {
		// TODO Auto-generated method stub
	RepoContenidos contenidos=	RepoContenidos.getInstance
	def llenar(){	 
		contenidos.vaciar
		
		try {
			// Creamos conexion
			var Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234")
			// Creamos objeto statement
			var Statement unStatement = unaConexion.createStatement()
			// Ejecutar instrucciones SQL
			var ResultSet unResultSet = unStatement.executeQuery("SELECT * FROM CONTENIDO")
			// Recorrer el ResultSet
			while (unResultSet.next()) {
				// mientras exista un proximo registro
				var String idContenido = unResultSet.getString("idContenido")
				var String titulo = unResultSet.getString("titulo")
				var String fechaPublicacion = unResultSet.getString("fechaPublicacion")
				var String extensionArchivo = unResultSet.getString("extensionArchivo")
				var String tipoArchivo = unResultSet.getString("tipoArchivo")
				var contenido= new Contenido (idContenido,titulo,fechaPublicacion,extensionArchivo,tipoArchivo)
				contenidos.create(contenido)
				
			}
		} catch (Exception e) {
			System.out.println("No hubo conexion!!")
			e.printStackTrace()
		}

	}
}
