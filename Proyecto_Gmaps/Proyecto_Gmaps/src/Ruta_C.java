import java.util.*;
public class Ruta_C {
    int V; // Número de vértices
    List<List<Distancias_C>> listaAdy; // Lista de adyacencia

    public Ruta_C(int V) {
        this.V = V;
        listaAdy = new ArrayList<>(V);

        // Inicializar la lista de adyacencia
        for (int i = 0; i < V; i++) {
            listaAdy.add(new ArrayList<>());
        }
    }

    // Método para agregar una arista con peso al grafo
    public void agregarArista(int origen, int destino, int peso) {
        Distancias_C arista = new Distancias_C(origen, destino, peso);
        listaAdy.get(origen).add(arista);
    }


    public void imprimirGrafo() {
        for (int i = 0; i < V; i++) {
            List<Distancias_C> aristas = listaAdy.get(i);
            if (!aristas.isEmpty()) {
                System.out.print("El vértice " + i + " está conectado a: ");
                for (Distancias_C arista : aristas) {
                    System.out.print("(" + arista.destino + ", " + arista.peso + ") ");
                }
                System.out.println();
            }
        }
    }

    /*public void imprimirGrafo_Nodos(int nodoInicio, int nodoDestino) {
        boolean[] visitados = new boolean[V];
        List<Integer> camino = new ArrayList<>();

        dfs(nodoInicio, nodoDestino, visitados, camino);

        if (!camino.isEmpty()) {
            System.out.print("El camino desde el vértice " + nodoInicio + " hasta el vértice " + nodoDestino + " es: ");
            for (int i = 0; i < camino.size(); i++) {
                System.out.print(camino.get(i));
                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No existe un camino desde el vértice " + nodoInicio + " hasta el vértice " + nodoDestino);
        }
    }*/


    public void imprimir_Ruta_Ciudades(int nodoInicio, int nodoDestino, String Ciudad_O, String Ciudad_D, List<Ciudad_C> L_Ciudad) {
        boolean[] visitados = new boolean[V];
        List<Integer> camino = new ArrayList<>();
        Ciudad_C ciudad = null;
        if(nodoInicio==0){
            nodoInicio++;
        }
        dfs(nodoInicio, nodoDestino, visitados, camino);

        if (!camino.isEmpty()) {
            System.out.println("Camino = "+camino.size());
            System.out.print("Para llegar a la ciudad de "+ Ciudad_D + " desde la ciudad de " + Ciudad_O+ " debe pasar por ");
            for (int i = 0; i < camino.size(); i++) {
                ;
                //System.out.println(L_Ciudad.get(camino.get(i)).getNombre_Ciudad());
                //System.out.print("i: "+i+ " camino get =" +camino.get(i));
                ciudad = L_Ciudad.get(camino.get(i)-1);
                System.out.println(ciudad.getNombre_Ciudad());
                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No existe un camino desde el vértice " + nodoInicio + " hasta el vértice " + nodoDestino);
        }
    }

    private boolean dfs(int actual, int destino, boolean[] visitados, List<Integer> camino) {
        visitados[actual] = true;
        camino.add(actual);

        if (actual == destino) {
            return true;
        }

        List<Distancias_C> aristas = listaAdy.get(actual);
        for (Distancias_C arista : aristas) {
            int siguiente = arista.destino;
            if (!visitados[siguiente] && dfs(siguiente, destino, visitados, camino)) {
                return true;
            }
        }

        camino.remove(camino.size() - 1);
        return false;
    }
}
