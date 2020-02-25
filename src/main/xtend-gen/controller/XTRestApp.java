package controller;

import controller.InfoMultimediaController;
import org.uqbar.xtrest.api.XTRest;

@SuppressWarnings("all")
public class XTRestApp {
  public static void main(final String[] Args) {
    InfoMultimediaController _infoMultimediaController = new InfoMultimediaController();
    XTRest.startInstance(9000, _infoMultimediaController);
  }
}
