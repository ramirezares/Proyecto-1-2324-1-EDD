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

    public LinkedSimpleList makeListOfAnts(int numberOfAnts, Vertex StartVertex) {
        LinkedSimpleList listOfAnts = new LinkedSimpleList();

        for (int i = 0; i < numberOfAnts; i++) {
            Ant antToAdd = new Ant(StartVertex);
            antToAdd.getVertexsTraveled().insertLast(StartVertex);
            listOfAnts.insertLast(antToAdd);
        }
        return listOfAnts;
    }

    //Funcion para inicializar feromonas
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
