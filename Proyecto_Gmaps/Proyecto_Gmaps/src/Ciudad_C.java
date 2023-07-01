public class Ciudad_C {

    private int ID_Estado;
    private int ID_Ciudad;
    private int Num_Zonas_Interes;
    private String Nombre_Ciudad;
    private double Area_Mostrada;
    private String Cordenadas;
    public Ciudad_C(int ID_Estado, int ID_Ciudad, int num_Zonas_Interes, String nombre_Ciudad, double area_Mostrada, String cordenadas) {
        this.ID_Estado = ID_Estado;
        this.ID_Ciudad = ID_Ciudad;
        this.Num_Zonas_Interes = num_Zonas_Interes;
        this.Nombre_Ciudad = nombre_Ciudad;
        this.Area_Mostrada = area_Mostrada;
        this.Cordenadas = cordenadas;
    }

    public int getID_Estado() {
        return ID_Estado;
    }

    public int getID_Ciudad() {
        return ID_Ciudad;
    }

    public int getNum_Zonas_Interes() {
        return Num_Zonas_Interes;
    }

    public double getArea_Mostrada() {
        return Area_Mostrada;
    }

    public String getNombre_Ciudad() {
        return Nombre_Ciudad;
    }

    public String getCordenadas() {
        return Cordenadas;
    }
}
