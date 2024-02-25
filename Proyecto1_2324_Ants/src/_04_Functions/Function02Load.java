/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.SimpleNode;
import _02_EDD.UndirectedGraph;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;
import javax.swing.JOptionPane;

/**
 *
 * @author AresR
 */
public class Function02Load { // desde un txt convertirlo a grafo

    public UndirectedGraph graphToReturn(String textToGraph) {
        UndirectedGraph graphToReturn = new UndirectedGraph();

        textToGraph = textToGraph.replace("\r", "");

        String[] lines = textToGraph.split("\n");

        boolean readVertices = true;

        if (!textToGraph.isBlank()) {
            for (String line : lines) {
                if (line.equals("aristas")) {
                    readVertices = false;
                    continue;
                }
                if (readVertices) {
                    if (!line.equals("ciudad")) {
                        int vertexNum = Integer.parseInt(line);
                        Vertex v = new Vertex(vertexNum);
                        graphToReturn.AddVertex(v);
                    }

                } else {
                    String[] ForArc = line.split(",");
                    int origin = Integer.parseInt(ForArc[0]);
                    int destination = Integer.parseInt(ForArc[1]);
                    double weight = Double.parseDouble(ForArc[2]);

                    for (SimpleNode pNode = graphToReturn.getListofVertex().GetpFirst();
                            pNode != null;
                            pNode = pNode.GetNxt()) {
                        Vertex vertex = (Vertex) pNode.GetData();
                        if (vertex.GetNumVertex() == origin) {
                            UndirectedGraphArc Arc = new UndirectedGraphArc(origin, destination, weight);
                            graphToReturn.AddArcToVertexInGraph(vertex, Arc);
                        }

                    }
                }
            }
        }
        return graphToReturn;
    }
}
