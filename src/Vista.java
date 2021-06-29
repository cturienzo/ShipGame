

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vista extends Canvas implements IVista, PropertyChangeListener {
    private int [][] tablero;
    private Graphics2D g2d;

    public Vista(Tablero modelo){
        this.tablero = modelo.getTablero();

    }

    public void paint(Graphics g){
        g2d = (Graphics2D) g;
        for(int x = 0; x<tablero.length; x++)
            for(int y = 0; y<tablero.length ; y++){
                g2d.setColor(Colores.getColor(tablero[x][y]));
                g2d.fillRect(COMIENZO_X + 30*x,COMIENZO_Y + 30*y,LADO-1, LADO-1);
            }

        //COORDENADAS
        for (int i=0; i<tablero.length;i++){
            g2d.setColor(Color.BLACK);
            g2d.drawString(" " + i,COMIENZO_X + 30*i + 10,COMIENZO_Y -2);

        }
        g2d.drawString("A"  ,COMIENZO_X -10,COMIENZO_Y + 30-10);
        g2d.drawString("B"  ,COMIENZO_X -10,COMIENZO_Y +30*2-10);
        g2d.drawString("C" ,COMIENZO_X -10 ,COMIENZO_Y + 30*3-10);
        g2d.drawString("D"  ,COMIENZO_X -10 ,COMIENZO_Y + 30*4-10);
        g2d.drawString("E"  ,COMIENZO_X -10 ,COMIENZO_Y + 30*5-10);
        g2d.drawString("F"  ,COMIENZO_X-10,COMIENZO_Y + 30*6-10);
        g2d.drawString("G"  ,COMIENZO_X -10,COMIENZO_Y + 30*7-10);
        g2d.drawString("H"  ,COMIENZO_X -10,COMIENZO_Y +30*8-10);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tablero = (int[][]) evt.getNewValue();
        repaint();

    }
}
