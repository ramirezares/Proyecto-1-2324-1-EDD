/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.SimpleNode;
import _02_EDD.UndirectedGraph;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author AresR
 */
public class Function06ViewWithGraphStream {
    
    public ViewPanel visualizeGraph(UndirectedGraph myGraph) {

        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Demo");

        // Añadir vértices al grafo de GraphStream usando iteración de lista enlazada
        for (SimpleNode pNode = myGraph.getListofVertex().GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            Vertex vertex = (Vertex) pNode.GetData();
            graph.addNode(Integer.toString(vertex.GetNumVertex()));
            Node node = graph.getNode(Integer.toString(vertex.GetNumVertex()));// Obtiene el nodo recién añadido.
            node.setAttribute("ui.label", Integer.toString(vertex.GetNumVertex()));
        }

        for (SimpleNode pNodeOfVertex = myGraph.getListofVertex().GetpFirst(); pNodeOfVertex != null; pNodeOfVertex = pNodeOfVertex.GetNxt()) {
            Vertex vertex = (Vertex) pNodeOfVertex.GetData();
            for (SimpleNode pNodeOfArcs = vertex.GetListAdy().GetpFirst(); pNodeOfArcs != null; pNodeOfArcs = pNodeOfArcs.GetNxt()) {
                UndirectedGraphArc arc = (UndirectedGraphArc) pNodeOfArcs.GetData();

                String nodeId = Integer.toString(arc.GetOrigin()) + "_" + Integer.toString(arc.GetDestination());
                // Asegurar que el arco no esté duplicado
                if (graph.getEdge(nodeId) == null && graph.getEdge(Integer.toString(arc.GetDestination()) + Integer.toString(arc.GetOrigin())) == null) {
                    graph.addEdge(nodeId, Integer.toString(arc.GetOrigin()), Integer.toString(arc.GetDestination()));
                }
            }
        }

        graph.setAttribute("ui.stylesheet", "node { fill-color: blue; text-color: red;  text-size: 20px; }");

        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false); // false indica no crear un JFrame

        return viewPanel;
    }
}
