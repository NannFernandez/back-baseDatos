package conector;

import dominio.Encuesta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pure;
import repos.RepoEncuestas;

@Accessors
@SuppressWarnings("all")
public class QueryEncuesta {
  private RepoEncuestas encuestas = RepoEncuestas.getInstance();
  
  private String startDate = "01-02-1000";
  
  private SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
  
  private Date date1 = new Function0<Date>() {
    @Override
    public Date apply() {
      try {
        Date _parse = QueryEncuesta.this.sdf1.parse(QueryEncuesta.this.startDate);
        return _parse;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  private java.sql.Date sqlStartDate = new java.sql.Date(this.date1.getTime());
  
  private String finishDate = "01-02-9999";
  
  private Date date2 = new Function0<Date>() {
    @Override
    public Date apply() {
      try {
        Date _parse = QueryEncuesta.this.sdf1.parse(QueryEncuesta.this.finishDate);
        return _parse;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  private java.sql.Date sqlFinishDate = new java.sql.Date(this.date2.getTime());
  
  public void llenar(final String query, final int registros, final java.sql.Date fechaDesde, final java.sql.Date fechaHasta) {
    this.encuestas.vaciar();
    try {
      Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", 
        "mydogpupy170312");
      PreparedStatement unStatement = unaConexion.prepareStatement(query);
      unStatement.setInt(1, registros);
      unStatement.setDate(2, fechaDesde);
      unStatement.setDate(3, fechaHasta);
      ResultSet unResultSet = unStatement.executeQuery();
      while (unResultSet.next()) {
        {
          String titulo = unResultSet.getString("titulo");
          String ext = unResultSet.getString("extension");
          String fecha = unResultSet.getString("fecha");
          String mediaPuntaje = unResultSet.getString("media_puntaje");
          String cantEncuesta = unResultSet.getString("cantidad_encuestas");
          Encuesta encuesta = new Encuesta(titulo, ext, fecha, mediaPuntaje, cantEncuesta);
          this.encuestas.create(encuesta);
        }
      }
      unResultSet.close();
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
  public RepoEncuestas getEncuestas() {
    return this.encuestas;
  }
  
  public void setEncuestas(final RepoEncuestas encuestas) {
    this.encuestas = encuestas;
  }
  
  @Pure
  public String getStartDate() {
    return this.startDate;
  }
  
  public void setStartDate(final String startDate) {
    this.startDate = startDate;
  }
  
  @Pure
  public SimpleDateFormat getSdf1() {
    return this.sdf1;
  }
  
  public void setSdf1(final SimpleDateFormat sdf1) {
    this.sdf1 = sdf1;
  }
  
  @Pure
  public Date getDate1() {
    return this.date1;
  }
  
  public void setDate1(final Date date1) {
    this.date1 = date1;
  }
  
  @Pure
  public java.sql.Date getSqlStartDate() {
    return this.sqlStartDate;
  }
  
  public void setSqlStartDate(final java.sql.Date sqlStartDate) {
    this.sqlStartDate = sqlStartDate;
  }
  
  @Pure
  public String getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final String finishDate) {
    this.finishDate = finishDate;
  }
  
  @Pure
  public Date getDate2() {
    return this.date2;
  }
  
  public void setDate2(final Date date2) {
    this.date2 = date2;
  }
  
  @Pure
  public java.sql.Date getSqlFinishDate() {
    return this.sqlFinishDate;
  }
  
  public void setSqlFinishDate(final java.sql.Date sqlFinishDate) {
    this.sqlFinishDate = sqlFinishDate;
  }
}
