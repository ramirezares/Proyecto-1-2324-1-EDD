/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase UndirectedGraph
 *
 * @author AresR
 * @version 17/02/2024
 */
public interface IUndirectedGraph {

    /**
     * Metodo a desarrollar para verificar si un grafo está vacio, es decir, no
     * tiene ni un solo vertive en su atributo listOfVertex
     *
     * @return true si el grafo no tiene vértices, false en caso contrario.
     */
    public boolean IsGraphEmpty();

    /**
     * Metodo a desarrollar para agregar un vertive al grafo.
     *
     * @return true si se agrega exitosamente, false en caso contrario cuando ya
     * esta presente en el grafo.
     */
    public boolean AddVertex(Vertex vertex);

    /**
     * Metodo a desarrollar para verificar si un vértice está presente en el
     * grafo.
     *
     * @param vertex El vértice a verificar.
     * @return true si el vértice está en el grafo, false en caso contrario.
     */
    public boolean IsVertexInGraph(Vertex vertex);

    /**
     * Metodo a desarrollar para buscar y obtener el nodo de un vertice en el
     * grafo.
     *
     * @param vertex El vértice a buscar.
     * @return Un nodo que contiene el vértice si se encuentra en el grafo, de
     * lo contrario un nodo vacío.
     */
    public SimpleNode SearchVertexInGraph(Vertex vertex);

    /**
     * Metodo a desarrollar para elimina un vértice del grafo.
     *
     * @param vertex El vértice a eliminar.
     * @return true si se eliminó con éxito, false si el vértice no está en el
     * grafo.
     */
    public boolean DelVertexInGraph(Vertex vertex);

    /**
     * Metodo a desarrollar para agregar un arco a un vértice en el grafo.
     *
     * @param vertex El vértice al que se le agregará el arco.
     * @param arc El arco a agregar.
     * @return true si se agregó con éxito, false si el vértice no está en el
     * grafo.
     */
    public boolean AddArcToVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    /**
     * Metodo a desarrollar para verificar si un arco está presente en un
     * vértice del grafo.
     *
     * @param vertex El vértice en el que se buscará el arco.
     * @param arc El arco a buscar.
     * @return true si el arco está presente en el vértice, False en caso
     * contrario.
     */
    public boolean IsArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    /**
     * Metodo a desarrollar para buscar un arco en un vértice del grafo.
     *
     * @param vertex El vértice en el que se buscará el arco.
     * @param arc El arco a buscar.
     * @return Un nodo que contiene el arco si se encuentra en el vértice, de lo
     * contrario un nodo vacío.
     */
    public SimpleNode SearchArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    /**
     * Metodo a desarrollar para eliminar un arco de un vértice en el grafo.
     *
     * @param vertex El vértice del que se eliminará el arco.
     * @param arc El arco a eliminar.
     * @return true si se eliminó con éxito, flse si el arco o el vértice no
     * están en el grafo.
     */
    public boolean DelArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc);

    /**
     * Metodo a desarrollar para obtener la cantidad de vértices en el grafo.
     *
     * @return Un entero que representa la cantidad de vértices en el grafo.
     */
    public int AmountOfVertex();

    /**
     * Metodo a desarrollar para obtener un resumen del grafo en forma de cadena
     * de texto.
     *
     * @return Un string con el resumen del grafo que incluye el numero de las
     * ciudades y la ciudad de origen, la de destino y el peso de las aristas.
     */
    public String ShowGraphSummary();

    /**
     * Metodo a desarrollar para obtener el atributo numVertices, que representa
     * el número máximo de vértices en el grafo.
     *
     * @return Un entero que representa el número máximo de vértices en el
     * grafo.
     */
    public int getNumVertexs();

    /**
     * Metodo a desarrollar para modificar el atributo el número máximo de
     * vértices en el grafo.
     *
     * @param numVertices El nuevo número máximo de vértices.
     */
    public void setNumVertexs(int numVertices);

    /**
     * Metodo a desarrollar para obtener la lista de vértices del grafo.
     *
     * @return El atributo de tipo LinkedSimpleList que contiene la lista de
     * vértices del grafo.
     */
    public LinkedSimpleList getListofVertex();

    /**
     * Metodo a desarrollar para modificar el atributo listOfVertex del grafo,
     * reemplazandolo por la nueva lista.
     *
     * @param ListofVertex
     */
    public void setListofVertex(LinkedSimpleList ListofVertex);
}
