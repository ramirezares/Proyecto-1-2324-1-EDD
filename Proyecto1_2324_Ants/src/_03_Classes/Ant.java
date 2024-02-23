/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _03_Classes;

import _02_EDD.LinkedSimpleList;
import _02_EDD.UndirectedGraph;
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
    private LinkedSimpleList VertexVisited;
    private double totalDistanceTraveled;

    public Ant() {
        this.currentVertex = null;
        this.VertexVisited = new LinkedSimpleList();
        this.totalDistanceTraveled = 0;
    }

    public void move(int numOfCity, double distance){   //Hacerlo con numOfCity. Usar la funcion de grafo 
        
                
    }
    
    // EL profe dijo que metodo para ciudades posibles
    
    
    public Vertex getCurrentCity() {
        return currentVertex;
    }

    public void setCurrentCity(Vertex nCurrentVertex) {
        this.currentVertex = nCurrentVertex;
    }

    public LinkedSimpleList getVertexVisited() {
        return VertexVisited;
    }

    public void setVertexVisited(LinkedSimpleList VertexVisited) {
        this.VertexVisited = VertexVisited;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }
    
    
}
