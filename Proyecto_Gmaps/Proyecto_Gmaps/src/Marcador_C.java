public class Marcador_C {

    private String Calle_Principal;
    private String Calle_Secundaria;
    private String Coordenadas; //(ID_Mapa, ID_Ciudad, ID_Lugar)
    private String Refencias;

    public Marcador_C(String calle_Principal, String calle_Secundaria, String coordenadas, String refencias) {
        Calle_Principal = calle_Principal;
        Calle_Secundaria = calle_Secundaria;
        Coordenadas = coordenadas;
        Refencias = refencias;
    }

    public String getCalle_Principal() {
        return Calle_Principal;
    }

    public String getCalle_Secundaria() {
        return Calle_Secundaria;
    }

    public String getCoordenadas() {
        return Coordenadas;
    }

    public String getRefencias() {
        return Refencias;
    }

    @Override
    public String toString(){
        return "La calle principal es "+Calle_Principal+" su calle secundaria es "+Calle_Secundaria
                +".\n Sus coordenas son: "+Coordenadas+", su refencia es: "+Refencias;
    }
}
