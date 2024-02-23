/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.UndirectedGraph;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;

/**
 *
 * @author AresR
 */
public class Function04AddCity {

    public UndirectedGraph AddCityToVertex(UndirectedGraph GraphOfProgram, String identifierNumberOfVertex) {
        boolean val;
        int n;

        n = Integer.parseInt(identifierNumberOfVertex);
        Vertex newVertex = new Vertex(n);
        val = GraphOfProgram.AddVertex(newVertex);

        if (val) {
            return GraphOfProgram;
        } else {
            return null;
        }
    }

    public UndirectedGraph AddArcToVertexWithAtributes(UndirectedGraph GraphOfProgram, UndirectedGraphArc Arc) {
        boolean val;
        int origin;
        Vertex temporalVertex;

        origin = Arc.GetOrigin();
        if (GraphOfProgram.isVertexInGraphWithNum(origin)) {
            temporalVertex = GraphOfProgram.SearchVertexInGraphWithNum(origin);
            val = GraphOfProgram.AddArcToVertexInGraph(temporalVertex, Arc);
            if (val) {
                return GraphOfProgram;
            } else {
                return null;
            }
        }
        return null;       
    }
}
