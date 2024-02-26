/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _04_Functions;

import _02_EDD.SimpleNode;
import _02_EDD.UndirectedGraph;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author AresR
 */
public class Function05ViewWithGraphStream {

    public Function05ViewWithGraphStream() {
    }

    /**
     * Muestra el grafo en un componente JFrame, implementando la libreria
     * GraphStream y deshabilitando el cerrado del programa cuando se le pulsa a
     * la X en la esquina superior de la ventana.
     *
     * @param GraphToVisualize grafo a visualizar con la libreria.
     * @return true si muestra la representacion grafica del grafo, false en
     * caso contrario.
     */
    public boolean visualizeGraphWindouw(UndirectedGraph GraphToVisualize) {
        boolean active = true;
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Demo");

        //Agrega cada vertice del grafo de la simulacion al grafo que se visualizará.
        for (SimpleNode pNode = GraphToVisualize.getListofVertex().GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            Vertex vertex = (Vertex) pNode.GetData();
            graph.addNode(Integer.toString(vertex.GetNumVertex()));
            Node node = graph.getNode(Integer.toString(vertex.GetNumVertex()));
            node.setAttribute("ui.label", Integer.toString(vertex.GetNumVertex()));
        }

        //Agrega cada arco el grafo de la simulacion al grafo que se visualizará.
        for (SimpleNode pNodeOfVertex = GraphToVisualize.getListofVertex().GetpFirst(); pNodeOfVertex != null; pNodeOfVertex = pNodeOfVertex.GetNxt()) {
            Vertex vertex = (Vertex) pNodeOfVertex.GetData();
            for (SimpleNode pNodeOfArcs = vertex.GetListAdy().GetpFirst(); pNodeOfArcs != null; pNodeOfArcs = pNodeOfArcs.GetNxt()) {
                UndirectedGraphArc arc = (UndirectedGraphArc) pNodeOfArcs.GetData();

                String nodeId = Integer.toString(arc.GetOrigin()) + "_" + Integer.toString(arc.GetDestination());
                if (graph.getEdge(nodeId) == null && graph.getEdge(Integer.toString(arc.GetDestination()) + Integer.toString(arc.GetOrigin())) == null) {
                    graph.addEdge(nodeId, Integer.toString(arc.GetOrigin()), Integer.toString(arc.GetDestination())).setAttribute("distance", arc.GetWeight());
                }
            }
        }

        //Asigna el texto a cada Arco y configura la visualizacion.
        graph.edges().forEach(edge -> {
            double distance = (double) edge.getAttribute("distance");
            edge.setAttribute("ui.label", String.valueOf(distance));
        });
        graph.setAttribute("ui.stylesheet", "edge { text-background-mode: plain; text-size: 30; }");

        //Asigna el texto a cada Vertice configura la de visualizacion.
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        graph.setAttribute("ui.stylesheet", "node { fill-color: red; text-color: blue;  text-size: 40px; }");

        //Crea el componente que será añadido al JFrame.
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD) {
        };
        viewer.enableAutoLayout();

        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false); // false indica que no se crea un JFrame

        // Configura un JFrame propio y añade el ViewPanel.
        JFrame frame = new JFrame("Mostrar grafo");
        frame.setLayout(new BorderLayout());
        frame.add(viewPanel, BorderLayout.CENTER);

        // Modifica el cierre para que no se cierre el programa cuando se cierre la ventana de visualizacion.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Muestra la ventana.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 450);
        return active;
    }
}
