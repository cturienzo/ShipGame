import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tablero implements ITablero{
    private int [][] tablero;
    private int tamanio;
    private PropertyChangeSupport soporteTablero;
    public Tablero(int tamanio){
        this.tablero = new int[tamanio][tamanio];
        this.tamanio=tamanio;
        soporteTablero = new PropertyChangeSupport(this);

    }
    public void addPropertyChangeListener(PropertyChangeListener pcl){soporteTablero.addPropertyChangeListener(pcl);}
    public void borra(){
        borra(0);
    }

    public void borra(int valor){
        for(int x=0;x<tamanio;x++){
            for(int y=0;y<tamanio;y++){
                setPosicion(x,y,valor);
            }
        }

    }

    public int getPosicion(int x, int y){
        return this.tablero[x][y];
    }
    public int[][] getTablero(){
        return this.tablero;
    }
    public int getTamanio(){
    return this.tamanio;
    }
    public int ocupacion(){
        int cont=0;
        for(int x=0;x<tamanio;x++){
            for(int y=0;y<tamanio;y++){
                if(this.tablero[x][y]!=0)
                    cont++;
            }
        }
        return cont;

    }
    public void setPosicion(int x, int y, int valor){
        int [][] nuevoTablero = new int[tablero.length][tablero.length];
        copiarTablero(this.tablero,nuevoTablero);
        nuevoTablero[x][y]=valor;
        soporteTablero.firePropertyChange("tablero",this.tablero,nuevoTablero);
        this.tablero[x][y]=valor;





    }
    public void setTablero(int [][] tablero){
        this.tablero=tablero;
    }

    public void copiarTablero(int [][] tablero, int [][] nuevoTablero){
        for(int x=0;x<tamanio;x++) {
            for (int y = 0; y < tamanio; y++) {
                nuevoTablero[x][y]= tablero[x][y];
            }
        }


    }
}
