
public class Mapa_C {
    private int ID_Mapa;
    private int ID_Pais;
    private String Pais;
    private int ID_Estado;
    private String Estado;
    private String Fecha_Mapa;
    // Constructor
    public Mapa_C(int idMapa, int idPais, String pais, int idEstado, String estado, String fechaMapa) {
        this.ID_Mapa = idMapa;
        this.ID_Pais = idPais;
        this.Pais = pais;
        this.ID_Estado = idEstado;
        this.Estado = estado;
        this.Fecha_Mapa = fechaMapa;
    }

    public int getID_Mapa() {
        return ID_Mapa;
    }

    public int getID_pais() {
        return ID_Pais;
    }

    public String getPais() {
        return Pais;
    }

    public int getID_estado() {
        return ID_Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public String getFecha_Mapa() {
        return Fecha_Mapa;
    }

    @Override
    public String toString(){
        return "ID_Mapa: "+ ID_Mapa+" ID_Pais: "+ID_Pais+" Pais: "+ Pais+" ID_Estado: "+ID_Estado+" Estado: "+Estado+" Fecha del Mapa: "+Fecha_Mapa;
    }
}
