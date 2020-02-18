package dominio;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Test {
  private String title = "aaaaaa";
  
  private int numero = 123;
  
  private List<String> lista = CollectionLiterals.<String>newArrayList();
  
  @Pure
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  @Pure
  public int getNumero() {
    return this.numero;
  }
  
  public void setNumero(final int numero) {
    this.numero = numero;
  }
  
  @Pure
  public List<String> getLista() {
    return this.lista;
  }
  
  public void setLista(final List<String> lista) {
    this.lista = lista;
  }
}
