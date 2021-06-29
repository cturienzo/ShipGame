import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controlador extends MouseAdapter {
    private Barquitos barquitos;
    public Controlador(Barquitos barquitos){
        this.barquitos=barquitos;

    }

    public void mousePressed(MouseEvent e){
        try {
            barquitos.disparo((e.getX() - Vista.COMIENZO_X) / Vista.LADO, (e.getY() - Vista.COMIENZO_Y) / Vista.LADO);
        }catch(Exception exc){

        }

    }

    public void mouseReleased(MouseEvent e){
       if(barquitos.finPartida()){
            barquitos.mostrarFinPartida();
        }
    }

}
