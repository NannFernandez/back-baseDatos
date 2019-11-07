package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repos.RepoCategorias;
import repos.RepoContenidos;
import repos.RepoEncuestas;
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
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    //this.pageNotFound(baseRequest, request, response);
  }
}
