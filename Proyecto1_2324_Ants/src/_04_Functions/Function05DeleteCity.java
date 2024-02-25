/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.UndirectedGraph;
import _02_EDD.Vertex;

/**
 *
 * @author AresR
 */
public class Function05DeleteCity {

    public UndirectedGraph deleteVertexAndArcThatRefersToThat(UndirectedGraph GraphOfProgram, int numOfVertex) {
        boolean val;
        
        val = GraphOfProgram.DelArcInVertexInGraphWithNumberOfVertex(numOfVertex);
        Vertex temporalVertex = (Vertex) GraphOfProgram.SearchVertexInGraphWithNum(numOfVertex);
        
        if(temporalVertex!=null){
            val = GraphOfProgram.DelVertexInGraph(temporalVertex);
        } else {
            val = false;
        }
        
        if (val) {
            return GraphOfProgram;
        } else {
            return null;                // Esta dando true pero no elimina el vertice
        }
    }

}
