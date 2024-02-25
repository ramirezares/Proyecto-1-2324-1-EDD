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
public class Function06ViewWithGraphStream {

    public Function06ViewWithGraphStream() {
    }

    public boolean visualizeGraphWindouw(UndirectedGraph GraphToVisualize) {
        boolean active=true;
        System.setProperty("org.graphstream.ui", "swing"); 
        Graph graph = new SingleGraph("Demo"); 


        for (SimpleNode pNode = GraphToVisualize.getListofVertex().GetpFirst(); pNode != null; pNode = pNode.GetNxt()) {
            Vertex vertex = (Vertex) pNode.GetData();
            graph.addNode(Integer.toString(vertex.GetNumVertex()));
            Node node = graph.getNode(Integer.toString(vertex.GetNumVertex()));
            node.setAttribute("ui.label", Integer.toString(vertex.GetNumVertex()));
        }

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

        //Asignacion de texto a cada Arco y configuracion de visualizacion.
        graph.edges().forEach(edge -> {double distance = (double) edge.getAttribute("distance");
        edge.setAttribute("ui.label", String.valueOf(distance));});
        graph.setAttribute("ui.stylesheet", "edge { text-background-mode: plain; text-size: 30; }");

        //Asignacion de texto a cada Vertice y configuracion de visualizacion.
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        graph.setAttribute("ui.stylesheet", "node { fill-color: red; text-color: blue;  text-size: 40px; }");
        
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD) {};
        viewer.enableAutoLayout();

        // Crear un ViewPanel de este Viewer
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false); // false indica que no se crea un JFrame

        // Configurar un JFrame propio y añadir el ViewPanel a este JFrame
        JFrame frame = new JFrame("Mostrar grafo");
        frame.setLayout(new BorderLayout());
        frame.add(viewPanel, BorderLayout.CENTER);

        // Configurar la operación de cierre para que no cierre la aplicación
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Mostrar el JFrame
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 450);
        return active;
    }
}
