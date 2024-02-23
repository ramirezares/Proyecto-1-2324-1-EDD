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
public class AntSystem {
    
    UndirectedGraph GraphOfSimulation;
    LinkedSimpleList listOfAnts;
    int alfaValue,betaValue;
    double rhoValue;
    int AmountOfCycles;
    Vertex StartVertex,EndVertex;
    LinkedSimpleList bestRouteArcs;
    double bestDistance, totalDistanceTraveled;
    double AmountOfPheromones;
    
   public AntSystem(UndirectedGraph GraphOfSimulation, LinkedSimpleList listOfAnts, int alfaValue, int betaValue, double rhoValue, int AmountOfCycles, Vertex StartVertex, Vertex EndVertex) {
        this.GraphOfSimulation = GraphOfSimulation;
        this.listOfAnts = listOfAnts;
        this.alfaValue = alfaValue;
        this.betaValue = betaValue;
        this.rhoValue = rhoValue;
        this.AmountOfCycles = AmountOfCycles;
        this.StartVertex = StartVertex;
        this.EndVertex = EndVertex;
        this.bestRouteArcs = new LinkedSimpleList();
        this.bestDistance = 0;
        this.totalDistanceTraveled = 0;
        this.AmountOfPheromones = 0;
    }
   
   public String Simulate(){
       StringBuilder toTextAreasummary = new StringBuilder();
       for (int i = 0; i < AmountOfCycles; i++) {
           toTextAreasummary.append(this.Cycle(this.listOfAnts,toTextAreasummary));
       }
       return toTextAreasummary.toString();
       
       // Replantear usando una clase para el historial con un metodo ToString
   }
   
   public String Cycle(LinkedSimpleList ListOfAnts, StringBuilder toTextAreasummary){
       int AmountOfAntsArrivedToEnd = 0;
       for (int i = 0; i < this.listOfAnts.GetSize(); i++) {
           System.out.println("a");
                      
       }
       return toTextAreasummary.toString();
       
       // Replantear usando una clase para el historial con un metodo ToString
   }
    
    // grafo, ciclo, lista de hormigas, alfa, beta, rho, vertice de inicio, vertice fin, lista de las mejores aristas(camino optimo)
    // mejor distancia, history, summary
    // history, camino recorrido por la hormiga, cantidad de feromonas, distancia recorrida
    
    //simulacion
   
    // recorrer completo recibe hormiga 
    
    // lista obtener ciudades candidatas recibe hormiga
    
    // probabilidades recibe las ciudades candidatas
    
    //decidir proxima ciudad recibe lista probalbilidades y lista ciudades candidatas
    
    //incrementar feromona 
    
    //evaporar feromonas

    
}
