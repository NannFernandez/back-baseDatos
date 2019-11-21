package controller;

import conector.QueryCategoria;
import conector.QueryContenido;
import conector.QueryEncuesta;
import conector.QueryTitulos;
import conector.QueryVelocidad;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.omg.CORBA.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repos.RepoCategorias;
import repos.RepoContenidos;
import repos.RepoEncuestas;
import repos.RepoTitulos;
import repos.RepoVelocidad;

@Controller
@SuppressWarnings("all")
public class InfoMultimediaController extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private RepoVelocidad velocidades = RepoVelocidad.getInstance();
  
  private RepoContenidos contenidos = RepoContenidos.getInstance();
  
  private RepoEncuestas encuestas = RepoEncuestas.getInstance();
  
  private RepoCategorias categorias = RepoCategorias.getInstance();
  
  private RepoTitulos titulos = RepoTitulos.getInstance();
  
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  
  @Get("/contenidos")
  public Result contenido(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryContenido contenido = new QueryContenido();
      contenido.llenar();
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.contenidos.getListaContenidos()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/categoria")
  public Result categoria(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryCategoria categoria = new QueryCategoria();
      categoria.llenar();
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.categorias.getListaCategorias()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velTransfAsc/:registros")
  public Result velTransfAsc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryVelocidad velocidad = new QueryVelocidad();
      velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_ASC(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.velocidades.getListaVelocidad()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velTransfAsc/:registros")
  public Result velTransfDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryVelocidad velocidad = new QueryVelocidad();
      velocidad.llenar("CALL MOSTRAR_VELOC_TRANSF_DESC(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.velocidades.getListaVelocidad()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velTransfMediaDesc/:registros")
  public Result velTransfMediaDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryTitulos titulo = new QueryTitulos();
      titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_TRANSF(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velTransfMediaAsc/:registros")
  public Result velTransfMediaAsc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryTitulos titulo = new QueryTitulos();
      titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_TRANSF(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velEdadMediaAsc/:registros")
  public Result velEdadMediaAsc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryTitulos titulo = new QueryTitulos();
      titulo.llenar("CALL EDAD_TRANSF_MEDIA_ASC_POR_EDAD(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/velEdadMediaDesc/:registros")
  public Result velEdadMediaDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryTitulos titulo = new QueryTitulos();
      titulo.llenar("CALL EDAD_TRANSF_MEDIA_DESC_POR_EDAD(?)", Integer.parseInt(registros));
      Result _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/mediaPuntajeAsc/:registros/:desde/:hasta")
  public Result mediaPuntajeAsc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        Date fechaDesde = this.sdf.parse(desde);
        long _time = fechaDesde.getTime();
        java.sql.Date fechaDesdeParser = new java.sql.Date(_time);
        Date fechaHasta = this.sdf.parse(desde);
        long _time_1 = fechaHasta.getTime();
        java.sql.Date fechaHastaParser = new java.sql.Date(_time_1);
        QueryEncuesta encuesta = new QueryEncuesta();
        encuesta.llenar("CALL MEDIA_PUNTAJE_ASC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser, fechaHastaParser);
        Result _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
        } catch (final Throwable _t) {
          if (_t instanceof UserException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Get("/mediaPuntajeDesc/:registros/:desde/:hasta")
  public Result mediaPuntajeDesc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        Date fechaDesde = this.sdf.parse(desde);
        long _time = fechaDesde.getTime();
        java.sql.Date fechaDesdeParser = new java.sql.Date(_time);
        Date fechaHasta = this.sdf.parse(desde);
        long _time_1 = fechaHasta.getTime();
        java.sql.Date fechaHastaParser = new java.sql.Date(_time_1);
        QueryEncuesta encuesta = new QueryEncuesta();
        encuesta.llenar("CALL MEDIA_PUNTAJE_DESC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser, fechaHastaParser);
        Result _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
        } catch (final Throwable _t) {
          if (_t instanceof UserException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Get("/mediaEncuestaDesc/:registros/:desde/:hasta")
  public Result mediaEncuestaDesc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        Date fechaDesde = this.sdf.parse(desde);
        long _time = fechaDesde.getTime();
        java.sql.Date fechaDesdeParser = new java.sql.Date(_time);
        Date fechaHasta = this.sdf.parse(desde);
        long _time_1 = fechaHasta.getTime();
        java.sql.Date fechaHastaParser = new java.sql.Date(_time_1);
        QueryEncuesta encuesta = new QueryEncuesta();
        encuesta.llenar("CALL MEDIA_ENCUESTA_DESC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser, fechaHastaParser);
        Result _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
        } catch (final Throwable _t) {
          if (_t instanceof UserException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Get("/mediaEncuestaAsc/:registros/:desde/:hasta")
  public Result mediaEncuestaAsc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        Date fechaDesde = this.sdf.parse(desde);
        long _time = fechaDesde.getTime();
        java.sql.Date fechaDesdeParser = new java.sql.Date(_time);
        Date fechaHasta = this.sdf.parse(desde);
        long _time_1 = fechaHasta.getTime();
        java.sql.Date fechaHastaParser = new java.sql.Date(_time_1);
        QueryEncuesta encuesta = new QueryEncuesta();
        encuesta.llenar("CALL MEDIA_ENCUESTA_ASC(?, ?, ?)", Integer.parseInt(registros), fechaDesdeParser, fechaHastaParser);
        Result _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = ResultFactory.ok(this._jSONUtils.toJson(this.titulos.getListaTitulo()));
        } catch (final Throwable _t) {
          if (_t instanceof UserException) {
            _xtrycatchfinallyexpression = null;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/contenidos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = contenido(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/categoria").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = categoria(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velTransfAsc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velTransfAsc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velTransfAsc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velTransfDesc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velTransfMediaDesc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velTransfMediaDesc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velTransfMediaAsc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velTransfMediaAsc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velEdadMediaAsc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velEdadMediaAsc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/velEdadMediaDesc/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = velEdadMediaDesc(registros, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/mediaPuntajeAsc/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		String desde = matcher.group(2);
    		String hasta = matcher.group(3);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = mediaPuntajeAsc(registros, desde, hasta, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/mediaPuntajeDesc/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		String desde = matcher.group(2);
    		String hasta = matcher.group(3);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = mediaPuntajeDesc(registros, desde, hasta, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/mediaEncuestaDesc/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		String desde = matcher.group(2);
    		String hasta = matcher.group(3);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = mediaEncuestaDesc(registros, desde, hasta, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/mediaEncuestaAsc/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String registros = matcher.group(1);
    		String desde = matcher.group(2);
    		String hasta = matcher.group(3);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = mediaEncuestaAsc(registros, desde, hasta, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
