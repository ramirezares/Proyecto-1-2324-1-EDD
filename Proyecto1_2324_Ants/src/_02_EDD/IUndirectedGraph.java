/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura para la clase UndirectedGraph
 * @author AresR
 * @version 17/02/2024
 */
public interface IUndirectedGraph {

    public boolean IsGraphEmpty();

    public boolean AddVertex(Vertex vertex);

    public boolean IsVertexInGraph(Vertex vertex);

    public SimpleNode SearchVertexInGraph(Vertex vertex);

    public boolean DelVertexInGraph(Vertex vertex);

    public boolean AddArcToVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    public boolean IsArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    public SimpleNode SearchArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    public boolean DelArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    public int AmountOfVertex();

    public String ShowGraphSummary();

    public int getNumVertices();

    public void setNumVertices(int numVertices);

    public LinkedSimpleList getListofVertex();

    public void setListofVertex(LinkedSimpleList ListofVertex);
    
//Otros metodos     
}
