import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Barquitos extends Ventana implements IBarquitos {
    private int[] numBarcosLong;
    private int tamanioTablero;
    private Tablero tablero; //modelo
    private Tablero tableroCubierto;
    private Vista vista;
    private Controlador controlador;


    public Barquitos(int[] numBarcosLong, int tamanioTablero) {
        super(500);
        tableroCubierto = new Tablero(tamanioTablero);
        tableroCubierto.borra(1);
        tablero = new Tablero(tamanioTablero);


        vista = new Vista(tableroCubierto);


        this.numBarcosLong = numBarcosLong;
        this.tamanioTablero = tamanioTablero;

        controlador = new Controlador(this);


        vista.addMouseListener(controlador);
        insertarVista(vista);

        tableroCubierto.addPropertyChangeListener(vista);







    }

    @Override
    public void colocarBarcos() {

        Random rn = new Random();
        for (int i = 0; i < numBarcosLong.length; i++) {
            for (int j = numBarcosLong[i]; j > 0; j--) {
                try {
                    int rx = rn.nextInt(getTamanioTablero());
                    int ry = rn.nextInt(getTamanioTablero());
                    tablero.setPosicion(rx, ry, 3);
                    if (rn.nextBoolean()) {
                        for (int k = 0; k < i; k++) {
                            rx++;
                            tablero.setPosicion(rx, ry, 3);
                        }


                    } else {
                        for (int k = 0; k < i; k++) {
                            ry++;
                            tablero.setPosicion(rx, ry, 3);
                        }

                    }
                } catch (Exception ex) {

                }

            }


        }


    }

    @Override
    public void disparo(int x, int y) {

        tableroCubierto.setPosicion(x, y, tablero.getPosicion(x, y));



    }

    @Override
    public boolean finPartida() {
        int cont=0;
        int cont1=0;
        for(int x = 0; x<getTamanioTablero();x++){
            for(int y=0; y<getTamanioTablero();y++){
                if(tableroCubierto.getPosicion(x,y)==Colores.HUNDIDO.getValor())
                    cont++;
            }
        }
        for(int x = 0; x<getTamanioTablero();x++){
            for(int y=0; y<getTamanioTablero();y++){
                if(tablero.getPosicion(x,y)==Colores.HUNDIDO.getValor())
                    cont1++;
            }
        }
        return cont == cont1;
    }

    @Override
    public void mostrarFinPartida() {

            tableroCubierto.setTablero(this.tablero.getTablero());



    }

    public int getTamanioTablero() {
        return tamanioTablero;
    }

    public int getTamanioMaximoBarco() {
        return numBarcosLong.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        Barquitos b;
        b = new Barquitos(arr, 8);
        b.colocarBarcos();
        for (int i = 0; i < b.tablero.getTamanio(); i++) {
            for (int j = 0; j < b.tablero.getTamanio(); j++) {
                if (b.tablero.getPosicion(i, j) != 0)
                    System.out.println("(" + i + ", " + j + ")");

            }

        }










    }
}
