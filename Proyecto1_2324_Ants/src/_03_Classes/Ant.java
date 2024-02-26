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

    private Vertex currentVertex;                       //Vertice actual
    private LinkedSimpleList<Vertex> VertexsTraveled;   //Lista de vertices visitados o recorridos.
    private double totalDistanceTraveled;               //Distancia total recorrida

    /**
     * Instancia la clase hormiga, definiendo su vertice actual con el vertice
     * indicado.
     *
     * @param currentVertex vertice indicado para ser el actual en una instancia
     * de la clase.
     */
    public Ant(Vertex currentVertex) {
        this.currentVertex = currentVertex;
        this.VertexsTraveled = new LinkedSimpleList();
        this.totalDistanceTraveled = 0;
    }

    /**
     * Obtiene el vertice actual de una instancia de la clase.
     *
     * @return el vertice actual, almacenado en el atributo currentVertex
     */
    public Vertex getCurrentVertex() {
        return currentVertex;
    }

    /**
     * Modifica el vertice actual de una instancia de la clase.
     *
     * @param nCurrentVertex el nuevo vertice que se almacenará en el atributo
     * currentVertex
     */
    public void setCurrentVertex(Vertex nCurrentVertex) {
        this.currentVertex = nCurrentVertex;
    }

    /**
     * Obtiene la lista enlazada de vertices por los que la hormiga ha pasado.
     *
     * @return la lista LinkedSimpleList, almacenada en el atributo
     * VertexsTraveled
     */
    public LinkedSimpleList getVertexsTraveled() {
        return VertexsTraveled;
    }

    /**
     * Modifica la lista enlazada de vertices de una instancia de la clase.
     *
     * @param VertexsTraveled la nueva lista LinkedSimpleList, que se almacenará
     * en el atributo VertexsTraveled
     */
    public void setVertexsTraveled(LinkedSimpleList VertexsTraveled) {
        this.VertexsTraveled = VertexsTraveled;
    }

    /**
     * Obtiene la distancia total recorrida por una instancia de la clase.
     *
     * @return el double almacenado en el atributo totalDistanceTraveled.
     */
    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    /**
     * Modifica la distancia total recorrida por una instancia de la clase.
     *
     * @param totalDistanceTraveled el nuevo double que sera almacenado en el
     * atributo totalDistanceTraveled.
     */
    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    /**
     * Comprueba si un vertice indicado se encuentra en la lista de vertices
     * visitados por una instancia de la clase.
     *
     * @param vertexToVerify vertice a comprobar si se encuentra en la lista.
     * @return true si se encuentra en la lista, si la hormiga estuvo en el
     * vertice, false en caso contrario.
     */
    public boolean isVisitedVertex(Vertex vertexToVerify) {
        boolean val = false;
        if (this.VertexsTraveled.GetSize() > 0) {
            for (SimpleNode pNodeOfVertexs = this.VertexsTraveled.GetpFirst();
                    pNodeOfVertexs != null;
                    pNodeOfVertexs = pNodeOfVertexs.GetNxt()) {
                Vertex vertexInNode = (Vertex) pNodeOfVertexs.GetData();
                if (vertexInNode.GetNumVertex() == vertexToVerify.GetNumVertex()) {
                    val = true;
                }
            }

        }
        return val;
    }

    /**
     * Comprueba si un vertice se encuentra en la lista de vertices de una
     * instancia de la clase.pero con el numero del vertice a comprobar
     *
     * @param numVertexToVerify numero del vertice a comprobar si se encuentra
     * en la lista.
     * @return true si se encuentra en la lista, si la hormiga estuvo en el
     * vertice, false en caso contrario.
     */
    public boolean verifyAmongVisitedVertexs(int numVertexToVerify) {
        for (int i = 0; i < this.VertexsTraveled.GetSize(); i++) {
            Vertex vertexInNode = (Vertex) this.VertexsTraveled.GetValInIndex(i).GetData();
            if (vertexInNode.GetNumVertex() == numVertexToVerify) {
                return true;
            }
        }
        return false;

    }

    /**
     * Crea y devuelve un resumen de la ciudad actual, la lista de vertices y la
     * distancia recorrida por una instancia de la clase.
     *
     * @return el texto (String) con la informacionguardada en los atributos de
     * la instancia de la clase
     */
    public String ToSummary() {
        return "Hormiga:" + "Ciudades recorridas=" + this.VertexsTraveled.SummaryOfListOfVertexs() + ". Distancia total recorrida=" + this.totalDistanceTraveled + ", Ultima ciudad visitad=" + this.currentVertex.GetNumVertex() + '.';
    }

}
