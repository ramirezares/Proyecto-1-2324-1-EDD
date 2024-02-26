/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.LinkedSimpleList;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;
import _03_Classes.Ant;
import _03_Classes.AntSystemCycle;

/**
 *
 * @author AresR
 */
public class Function01Simulation {

    /**
     * Incializa la lista de hormigas a ser utilizada en la simulacion.
     * @param numberOfAnts numero de hormigas deseado
     * @param StartVertex vertice de partida de las hormigas
     * @return la lista de hormigas.
     */
    public LinkedSimpleList makeListOfAnts(int numberOfAnts, Vertex StartVertex) {
        LinkedSimpleList listOfAnts = new LinkedSimpleList();

        for (int i = 0; i < numberOfAnts; i++) {
            Ant antToAdd = new Ant(StartVertex);
            listOfAnts.insertLast(antToAdd);
        }
        return listOfAnts;
    }
    
    /**
     * Inicializa las feromonas de cada arco antes de iniciar la simulacion.
     * @param simulationN sistema que contiene el grafo en el que se inicializarán las feromonas.
     * @return el sistema con el grafo con sus feromonas ya inicializadas.
     */
    public AntSystemCycle inicializePheromones(AntSystemCycle simulationN) {
        int numVertexs = simulationN.getGraphOfSimulation().getListofVertex().GetSize();

        for (int i = 0; i < numVertexs; i++) {
            Vertex currentVertex = (Vertex) simulationN.getGraphOfSimulation().getListofVertex().GetValInIndex(i).GetData();
            for (int j = 0; j < currentVertex.GetListAdy().GetSize(); j++) {
                UndirectedGraphArc arc = (UndirectedGraphArc) currentVertex.GetListAdy().GetValInIndex(j).GetData();
                arc.setPheromones(numVertexs);
            }
        }
        return simulationN;
    }

    /**
     * Construye y devuelve el resumen de la mejor ruta encontrada por una hormiga.
     * @param BestRouteArcsList lista de vertices recorridos por la hormiga.
     * @return el resumen con los vertices visitados por cada hormiga.
     */
    public String FormatTxtToBestRouteArcs(LinkedSimpleList<Vertex> BestRouteArcsList) {
        StringBuilder txt = new StringBuilder();

        for (int i = 0; i < BestRouteArcsList.GetSize(); i++) {
            int aux = BestRouteArcsList.GetSize() - 1;
            if (i != aux) {
                Vertex v = (Vertex) BestRouteArcsList.GetValInIndex(i).GetData();
                txt.append(String.valueOf(v.GetNumVertex())).append("->");
            } else {
                Vertex v = (Vertex) BestRouteArcsList.GetValInIndex(i).GetData();
                txt.append(String.valueOf(v.GetNumVertex()));
            }
        }
        return txt.toString();
    }
}
