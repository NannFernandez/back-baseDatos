package controller;

import conector.QueryDelete;
import conector.QueryInsert;
import conector.QueryUpdate;
import dominio.Contenido;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.api.annotation.Put;
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
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/categorias/:id")
  public Result categoriasContenido(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/contenidos/:id")
  public Result contenido(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/categoria")
  public Result categoria(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Put("/contenidos/borrar/:id")
  public Result borrar(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryDelete delete = new QueryDelete();
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          delete.borrar(id);
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          _xtrycatchfinallyexpression = ResultFactory.badRequest(e.getMessage());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/contenidos/agregar/:titulo/:ext/:url")
  public Result agregar(final String titulo, final String ext, final String url, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryInsert agregar = new QueryInsert();
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          double _random = Math.random();
          double _multiply = (_random * 200);
          double _plus = (_multiply + 1);
          double _floor = Math.floor(_plus);
          String _string = Integer.valueOf(((int) _floor)).toString();
          final Contenido actualizado = new Contenido(_string, titulo, "2020-02-07", ext, url);
          agregar.insert(actualizado);
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          _xtrycatchfinallyexpression = ResultFactory.badRequest(e.getMessage());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Post("/contenidos/agregar2")
  public Result agregar2(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryInsert agregar = new QueryInsert();
      final Contenido contenido = this._jSONUtils.<Contenido>fromJson(body, Contenido.class);
      System.out.println(contenido.getListaCategorias());
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          agregar.insert(contenido);
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          return ResultFactory.badRequest(e.getMessage());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Put("/contenidos/modificar/:titulo/:ext/:id/:url")
  public Result modificar(final String titulo, final String ext, final String id, final String url, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      QueryUpdate update = new QueryUpdate();
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          final Contenido actualizado = new Contenido(id, titulo, "2020-02-07", ext, url);
          update.modificar(actualizado);
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          _xtrycatchfinallyexpression = ResultFactory.badRequest(e.getMessage());
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
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/velTransfDesc/:registros")
  public Result velTransfDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/velTransfMediaAsc/:registros")
  public Result velTransfMediaAsc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/velTransfMediaDesc/:registros")
  public Result velTransfMediaDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/velEdadMediaAsc/:registros")
  public Result velEdadMediaAsc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/velEdadMediaDesc/:registros")
  public Result velEdadMediaDesc(final String registros, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/mediaPuntajeAsc/:registros/:desde/:hasta")
  public Result mediaPuntajeAsc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/mediaPuntajeDesc/:registros/:desde/:hasta")
  public Result mediaPuntajeDesc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  public String parsear(final String string) {
    final String ano = string.substring(0, 3);
    final String mes = string.substring(4, 5);
    final String dia = string.substring(6, 7);
    String _substring = string.substring(0, 4);
    String _plus = (_substring + "-");
    String _substring_1 = string.substring(4, 6);
    String _plus_1 = (_plus + _substring_1);
    String _plus_2 = (_plus_1 + "-");
    String _substring_2 = string.substring(6, 8);
    String _plus_3 = (_plus_2 + _substring_2);
    System.out.println(_plus_3);
    System.out.println(string.substring(4, 6));
    String _substring_3 = string.substring(0, 4);
    String _plus_4 = (_substring_3 + "-");
    String _substring_4 = string.substring(4, 6);
    String _plus_5 = (_plus_4 + _substring_4);
    String _plus_6 = (_plus_5 + "-");
    String _substring_5 = string.substring(6, 8);
    return (_plus_6 + _substring_5);
  }
  
  @Get("/mediaEncuestaDesc/:registros/:desde/:hasta")
  public Result mediaEncuestaDesc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
  }
  
  @Get("/mediaEncuestaAsc/:registros/:desde/:hasta")
  public Result mediaEncuestaAsc(final String registros, final String desde, final String hasta, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nUserException cannot be resolved to a type.");
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
    		Pattern.compile("/contenidos/agregar2").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = agregar2(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/categorias/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = categoriasContenido(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/contenidos/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = contenido(id, target, baseRequest, request, response);
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
    		Pattern.compile("/velTransfDesc/(\\w+)").matcher(target);
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
    		Pattern.compile("/contenidos/borrar/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Put") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = borrar(id, target, baseRequest, request, response);
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
    {
    	Matcher matcher = 
    		Pattern.compile("/contenidos/agregar/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String titulo = matcher.group(1);
    		String ext = matcher.group(2);
    		String url = matcher.group(3);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = agregar(titulo, ext, url, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/contenidos/modificar/(\\w+)/(\\w+)/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Put") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String titulo = matcher.group(1);
    		String ext = matcher.group(2);
    		String id = matcher.group(3);
    		String url = matcher.group(4);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = modificar(titulo, ext, id, url, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
