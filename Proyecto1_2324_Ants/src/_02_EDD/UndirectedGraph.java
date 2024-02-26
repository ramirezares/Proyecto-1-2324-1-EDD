/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 * Clase UndirectedGraph Esta clase define el objeto grafo y su comportamiento,
 * con sus atributos nombre, numero de vertices y lista de vertices.
 *
 * @author AresR
 * @version 17/02/2024
 */
public class UndirectedGraph implements IUndirectedGraph {

    int numVertexs;                          // Número maximo de vertices 
    LinkedSimpleList<Vertex> listOfVertex;   // Lista de vertices

    /**
     * Instancia la clase UndirectedGraph. Inicializa el número de vértices en
     * -1 y crea una nueva lista de vértices. Crea un grafo vacio.
     */
    public UndirectedGraph() {
        this.numVertexs = -1;
        this.listOfVertex = new LinkedSimpleList<>();
    }

    /**
     * Verifica si el grafo está vacío.
     *
     * @return true si el grafo no tiene vértices, false en caso contrario.
     */
    @Override
    public boolean IsGraphEmpty() {
        boolean val = true;
        if (listOfVertex.GetSize() > 0) {
            val = false;
        }
        return val;
    }

    /**
     * Agrega un vértice al grafo.
     *
     * @param vertex El vértice a agregar.
     * @return true si se agregó con éxito, false si el vértice ya está presente
     * en el grafo.
     */
    @Override
    public boolean AddVertex(Vertex vertex) {
        boolean val = false;
        if (!IsVertexInGraph(vertex)) {
            listOfVertex.insertLast(vertex);
            val = true;
        }
        return val;
    }

    /**
     * Verifica si un vértice está presente en el grafo.
     *
     * @param vertex El vértice a verificar.
     * @return true si el vértice está en el grafo, false en caso contrario.
     */
    @Override
    public boolean IsVertexInGraph(Vertex vertex) {
        boolean val = false;
        for (SimpleNode pNode = listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            Vertex vertexInNode = (Vertex) pNode.GetData();
            if (vertexInNode.IsEquals(vertex)) {
                val = true;
            }
        }
        return val;
    }

    /**
     * Busca un vértice en el grafo.
     *
     * @param vertex El vértice a buscar.
     * @return Un nodo que contiene el vértice si se encuentra en el grafo, de
     * lo contrario un nodo vacío.
     */
    @Override
    public SimpleNode SearchVertexInGraph(Vertex vertex) {
        SimpleNode nodeToReturn = new SimpleNode();
        if (IsVertexInGraph(vertex)) {
            for (SimpleNode pNode = listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
                Vertex vertexInNode = (Vertex) pNode.GetData();
                if (vertexInNode.IsEquals(vertex)) {
                    nodeToReturn = pNode;
                }

            }
        }
        return nodeToReturn;
    }

    /**
     * Elimina un vértice del grafo.
     *
     * @param vertex El vértice a eliminar.
     * @return true si se eliminó con éxito, false si el vértice no está en el
     * grafo.
     */
    @Override
    public boolean DelVertexInGraph(Vertex vertex) {
        boolean val = false;
        if (IsVertexInGraph(vertex)) {
            for (SimpleNode pNode = listOfVertex.GetpFirst();
                    pNode != null;
                    pNode = pNode.GetNxt()) {

                Vertex vertexInNode = (Vertex) pNode.GetData();
                if (vertexInNode.IsEquals(vertex)) {
                    listOfVertex.delNodewithVal(vertex);
                    val = true;
                }
            }
        }
        return val;
    }

    /**
     * Agrega un arco a un vértice en el grafo.
     *
     * @param vertex El vértice al que se le agregará el arco.
     * @param arc El arco a agregar.
     * @return true si se agregó con éxito, false si el vértice no está en el
     * grafo.
     */
    @Override
    public boolean AddArcToVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val = false;
        if (IsVertexInGraph(vertex)) {
            Vertex VertexToAddArc = (Vertex) SearchVertexInGraph(vertex).GetData();
            if (!VertexToAddArc.IsArcInVertex(arc)) {
                VertexToAddArc.AddArc(arc);
                val = true;
            }
        }
        return val;
    }

    /**
     * Verifica si un arco está presente en un vértice del grafo.
     *
     * @param vertex El vértice en el que se buscará el arco.
     * @param arc El arco a buscar.
     * @return true si el arco está presente en el vértice, False en caso
     * contrario.
     */
    @Override
    public boolean IsArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val = false;
        if (IsVertexInGraph(vertex)) {
            Vertex VertexOfNode = (Vertex) SearchVertexInGraph(vertex).GetData();
            for (SimpleNode pNode = VertexOfNode.GetListAdy().GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
                if (pNode.GetData().equals(vertex)) {
                    val = true;
                }
            }
        }
        return val;
    }

    /**
     * Busca un arco en un vértice del grafo.
     *
     * @param vertex El vértice en el que se buscará el arco.
     * @param arc El arco a buscar.
     * @return Un nodo que contiene el arco si se encuentra en el vértice, de lo
     * contrario un nodo vacío.
     */
    @Override
    public SimpleNode SearchArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        SimpleNode pNodeArcToReturn = new SimpleNode();
        if (IsVertexInGraph(vertex)) {
            Vertex VertexToReview = (Vertex) SearchVertexInGraph(vertex).GetData();
            for (SimpleNode pNode = VertexToReview.GetListAdy().GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {

                UndirectedGraphArc arcInNode = (UndirectedGraphArc) pNode.GetData();
                if (arcInNode.IsEquals(arc)) {
                    pNodeArcToReturn = pNode;
                }
            }
        }
        return pNodeArcToReturn;
    }

    /**
     * Elimina un arco de un vértice en el grafo.
     *
     * @param vertex El vértice del que se eliminará el arco.
     * @param arc El arco a eliminar.
     * @return true si se eliminó con éxito, flse si el arco o el vértice no
     * están en el grafo.
     */
    @Override
    public boolean DelArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val = false;
        if (IsVertexInGraph(vertex)) {
            for (SimpleNode pNodeOfVertex = this.listOfVertex.GetpFirst(), pPrev = null;
                    pNodeOfVertex != null;
                    pPrev = pNodeOfVertex, pNodeOfVertex = pNodeOfVertex.GetNxt()) {
                Vertex VertexToReview = (Vertex) pNodeOfVertex.GetData();
                if (VertexToReview.GetNumVertex() == vertex.GetNumVertex()) {
                    for (SimpleNode pNodeOfArcs = VertexToReview.GetListAdy().GetpFirst(), pPrevOfArcs = null; pNodeOfArcs != null; pPrevOfArcs = pNodeOfArcs, pNodeOfArcs = pNodeOfArcs.GetNxt()) {

                        UndirectedGraphArc arcInNode = (UndirectedGraphArc) pNodeOfArcs.GetData();

                        if (arcInNode.IsEquals(arc)) {
                            if (pNodeOfArcs == VertexToReview.GetListAdy().GetpFirst()) {
                                VertexToReview.GetListAdy().SetpFirst(pNodeOfArcs.GetNxt());
                            } else {
                                pPrevOfArcs.SetNxt(pNodeOfArcs.GetNxt());
                            }

                            if (pNodeOfArcs == VertexToReview.GetListAdy().GetpLast()) {
                                VertexToReview.GetListAdy().SetpLast(pPrev);
                            }
                            val = true;
                            int nSize = VertexToReview.GetListAdy().GetSize();
                            nSize--;
                            VertexToReview.GetListAdy().SetSize(nSize);

                        }
                    }
                }
            }
        }
        return val;
    }

    /**
     * Obtiene la cantidad de vértices en el grafo.
     *
     * @return Un entero que representa la cantidad de vértices en el grafo.
     */
    @Override
    public int AmountOfVertex() {
        int count = 0;
        for (SimpleNode pNode = this.listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            count++;
        }
        return count;
    }

    /**
     * Obtiene un resumen del grafo en forma de cadena de texto.
     *
     * @return Un string con el resumen del grafo que incluye el numero de las
     * ciudades y la ciudad de origen, la de destino y el peso de las aristas.
     */
    @Override
    public String ShowGraphSummary() {
        StringBuilder summary = new StringBuilder();

        summary.append("Ciudades\n");
        for (SimpleNode pNode = this.listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            Vertex VertexToAppend = (Vertex) pNode.GetData();
            String text = VertexToAppend.ConvertToStringForTXT();
            summary.append(text).append("\n");
        }
        summary.append("Aristas\n");
        for (SimpleNode pNodeOfVertex = this.listOfVertex.GetpFirst(); pNodeOfVertex != null; pNodeOfVertex = pNodeOfVertex.GetNxt()) {
            Vertex vertex = (Vertex) pNodeOfVertex.GetData();
            for (SimpleNode pNodeOfArc = vertex.GetListAdy().GetpFirst(); pNodeOfArc != null; pNodeOfArc = pNodeOfArc.GetNxt()) {
                UndirectedGraphArc arc = (UndirectedGraphArc) pNodeOfArc.GetData();
                summary.append(Integer.toString(arc.GetOrigin())).append(",").append(Integer.toString(arc.GetDestination())).append(",").append(Double.toString(arc.GetWeight())).append("\n");
            }
        }
        return summary.toString();
    }

    /**
     * Obtiene el número máximo de vértices en el grafo.
     *
     * @return Un entero que representa el número máximo de vértices en el
     * grafo.
     */
    @Override
    public int getNumVertexs() {
        return numVertexs;
    }

    /**
     * Establece el número máximo de vértices en el grafo.
     *
     * @param numVertexs El nuevo número máximo de vértices.
     */
    @Override
    public void setNumVertexs(int numVertexs
    ) {
        this.numVertexs = numVertexs;
    }

    /**
     * Obtiene la lista de vértices del grafo.
     *
     * @return El atributo de tipo LinkedSimpleList que contiene la lista de
     * vértices del grafo.
     */
    @Override
    public LinkedSimpleList getListofVertex() {
        return listOfVertex;
    }

    /**
     * Modifica el atributo listOfVertex del grafo, reemplazandolo por la nueva
     * lista.
     *
     * @param ListOfVertex La nueva lista de vértices.
     */
    @Override
    public void setListofVertex(LinkedSimpleList ListOfVertex) {
        this.listOfVertex = ListOfVertex;
    }

    public boolean isVertexInGraphWithNum(int numOfVertex) {
        boolean val = false;
        Vertex vertexInNode;

        for (SimpleNode pNode = this.listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            vertexInNode = (Vertex) pNode.GetData();
            if (vertexInNode.GetNumVertex() == numOfVertex) {
                val = true;
            }

        }
        return val;
    }

    /**
     * Busca y devuelve un vertice en la lista de vertices del grafo, con el
     * numero del vertice.
     *
     * @param numOfVertex numero del vertice que se desea obtener.
     * @return El vertice encontrado que corresponde con el numero ingresado.
     */
    public Vertex SearchVertexInGraphWithNum(int numOfVertex) {
        Vertex vertexInNode, vertexToReturn = null;
        if (this.isVertexInGraphWithNum(numOfVertex)) {
            for (SimpleNode pNode = this.listOfVertex.GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
                vertexInNode = (Vertex) pNode.GetData();
                if (vertexInNode.GetNumVertex() == numOfVertex) {
                    vertexToReturn = vertexInNode;
                }
            }
        }
        return vertexToReturn;
    }

    /**
     * Elimina las aristas que apuntan al vertice indicado.
     *
     * @param numOfVertex El vertice al cual apuntan las aristas que se desean
     * eliminar.
     * @return
     */
    public boolean DelArcInVertexInGraphWithNumberOfVertex(int numOfVertex) {
        boolean val = false;
        for (SimpleNode pNodeOfVertexs = this.listOfVertex.GetpFirst(); pNodeOfVertexs != null; pNodeOfVertexs = pNodeOfVertexs.GetNxt()) {
            Vertex vertexInNode = (Vertex) pNodeOfVertexs.GetData();
            for (SimpleNode pNodeOfArc = vertexInNode.GetListAdy().GetpFirst(), pPrevArc = null;
                    pNodeOfArc != null;
                    pNodeOfArc = pNodeOfArc.GetNxt()) {

                UndirectedGraphArc arcInNode = (UndirectedGraphArc) pNodeOfArc.GetData();
                if (arcInNode.GetDestination() == numOfVertex) {
                    val = this.DelArcInVertexInGraph(vertexInNode, arcInNode);
                }
            }
        }
        return val;
    }
}
