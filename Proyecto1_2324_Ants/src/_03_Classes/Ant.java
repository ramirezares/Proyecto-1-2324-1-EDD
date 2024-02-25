/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _03_Classes;

import _02_EDD.LinkedSimpleList;
import _02_EDD.SimpleNode;
import _02_EDD.Vertex;

/**
 *
 * @author AresR
 */
public class Ant {

    // vertex vertice actual
    // linkedlist vertices visitados
    // double distancia recorrida
    private Vertex currentVertex;
    private LinkedSimpleList<Vertex> VertexsTraveled;
    private double totalDistanceTraveled;

    public Ant(Vertex currentVertex) {
        this.currentVertex = currentVertex;
        this.VertexsTraveled = new LinkedSimpleList();
        this.totalDistanceTraveled = 0;
    }

    public Vertex getCurrentVertex() {
        return currentVertex;
    }

    public void setCurrentVertex(Vertex nCurrentVertex) {
        this.currentVertex = nCurrentVertex;
    }

    public LinkedSimpleList getVertexsTraveled() {
        return VertexsTraveled;
    }

    public void setVertexsTraveled(LinkedSimpleList VertexsTraveled) {
        this.VertexsTraveled = VertexsTraveled;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    public boolean isVisitedVertex(Vertex vertexToVerify) {
        boolean val = false;
        if (this.VertexsTraveled.GetSize() > 0) {
            for (SimpleNode pNodeOfVertexs = this.VertexsTraveled.GetpFirst();
                    pNodeOfVertexs != null;
                    pNodeOfVertexs = pNodeOfVertexs.GetNxt()) {
                Vertex vertex = (Vertex) pNodeOfVertexs.GetData();
                if (vertex.GetNumVertex() == vertexToVerify.GetNumVertex()) {
                    val = true;
                }
            }

        }
        return val;
    }
    
    public boolean verifyAmongVisitedVertexs(int numVertexToVerify){
        for (int i = 0; i < this.VertexsTraveled.GetSize(); i++) {
            Vertex vertexInNode= (Vertex) this.VertexsTraveled.GetValInIndex(i).GetData();
            if(vertexInNode.GetNumVertex() == numVertexToVerify){
               return true;
           }
        }
        return false;
    
    }
    
    public String ToSummary() {
        return "Hormiga:" + "ciudadesRecorridas=" + this.VertexsTraveled.GetSize()+ ", distanciaRecorrida=" + this.totalDistanceTraveled + ", ciudadActual=" +this.currentVertex.GetNumVertex()+ '.';
    }

}
