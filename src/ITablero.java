public interface ITablero {
    void borra();
    int getPosicion(int x, int y);
    int[][] getTablero();
    int getTamanio();
    int ocupacion();
    void setPosicion(int x, int y, int valor);
    void setTablero(int [][] tablero);
}
