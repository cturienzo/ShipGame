import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends Frame {
    private int tamanio;


    public Ventana(int tamanio){
        super("BARQUITOS");
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );

        this.tamanio=tamanio;
        this.setSize(tamanio,tamanio);


    }

    public void insertarVista(Vista vista){
        this.add(vista);
        this.setVisible(true);
    }
}
