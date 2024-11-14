package datos;

public class FechaHora extends FechaDetallada{
    private int hora;
    private int minuto;
    private int segundo;

    public FechaHora(String sFecha, int hora, int min, int seg){
        super(sFecha);
        if (esHoraValida(hora, min, seg)) {
            this.hora = hora;
            this.minuto = min;
            this.segundo = seg;
        } else {
            throw new IllegalArgumentException("Hora no válida");
        }

    }

    private boolean esHoraValida(int hora, int min, int seg) {
        return (hora >= 0 && hora < 24) && (min >= 0 && min < 60) && (seg >= 0 && seg < 60);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (esHoraValida(hora, this.minuto, this.segundo)) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora no válida");
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (esHoraValida(this.hora, minuto, this.segundo)) {
            this.minuto = minuto;
        } else {
            throw new IllegalArgumentException("Minuto no válido");
        }
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (esHoraValida(this.hora, this.minuto, segundo)) {
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Segundo no válido");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %02d:%02d:%02d", super.toString(), hora, minuto, segundo);
    }
    
    
    
}
