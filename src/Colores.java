import java.awt.*;
public enum Colores {
    AGUA(Color.cyan,0),
    CUBIERTO(Color.GRAY,1),
    TOCADO(Color.YELLOW,2),
    HUNDIDO(Color.RED,3),
    BORDE(Color.WHITE,4);

    private Color color;
    private int valor;

    private Colores(Color c, int valor){
        this.color=c;
        this.valor=valor;
    }
    public Color getColor(){
        return this.color;
    }
    public int getValor(){
        return this.valor;
    }
    public static Color getColor(int valor){
        switch(valor){
            case 0: return AGUA.getColor();
            case 1: return CUBIERTO.getColor();
            case 2: return TOCADO.getColor();
            case 3: return HUNDIDO.getColor();
            case 4: return BORDE.getColor();
            default: return CUBIERTO.getColor();
        }
    }



}
