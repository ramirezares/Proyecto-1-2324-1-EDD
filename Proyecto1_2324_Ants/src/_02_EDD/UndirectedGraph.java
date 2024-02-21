/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 * Clase UndirectedGraph
 * Esta clase define el objeto grafo y su comportamiento, con sus atributos nombre,
 * numero de vertices y lista de vertices.
 * @author AresR
 * @version 17/02/2024
 */
public class UndirectedGraph implements IUndirectedGraph {
    int numVertices;
    LinkedSimpleList<Vertex> listOfVertex;   // Lista de adyacencia

   
    public UndirectedGraph() {
        this.numVertices=-1;
        this.listOfVertex=new LinkedSimpleList<>();
    }

    @Override
    public boolean IsGraphEmpty() {
        boolean val = true;
        if(listOfVertex.GetSize()>0){
            val=false;
        }
        return val;
    }

    @Override
    public boolean AddVertex(Vertex vertex) {
        boolean val=false;
        if(!IsVertexInGraph(vertex)){
            SimpleNode NNode=new SimpleNode(vertex);
            listOfVertex.insertLast(vertex);
            val=true;
        }
        return val;
    }
    

    @Override
    public boolean IsVertexInGraph(Vertex vertex) {
        boolean val=false;
        for(SimpleNode pNode=listOfVertex.GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
            if(pNode.GetData().equals(vertex)){
                val=true;
            }
        }
        return val;
    }

    @Override
    public SimpleNode SearchVertexInGraph(Vertex vertex) {
        SimpleNode nodeToReturn=new SimpleNode();
        if(IsVertexInGraph(vertex)){
            for(SimpleNode pNode=listOfVertex.GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
                if(pNode.GetData().equals(vertex)){
                    nodeToReturn=pNode;   
                }
                    
            }
        }
        return nodeToReturn;
    }
    
    @Override
    public boolean DelVertexInGraph(Vertex vertex) {
        boolean val=false;
        if(IsVertexInGraph(vertex)){
            for(SimpleNode pNode=listOfVertex.GetpFirst(), pPrev=null;
                    pNode!=null;
                    pPrev=pNode,pNode=pNode.GetNxt()){
                
                if(pNode.GetData().equals(vertex)){
                    pPrev.SetNxt(pNode.GetNxt());
                    val=true;
                }
            }
        }
        return val;
    }

    @Override
    public boolean AddArcToVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val=false;
        if(IsVertexInGraph(vertex)){
            Vertex VertexToAddArc=(Vertex)SearchVertexInGraph(vertex).GetData();
            val=VertexToAddArc.AddArc(arc);
        }
        return val;
    }

    @Override
    public boolean IsArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val=false;
        if (IsVertexInGraph(vertex)){
            Vertex VertexOfNode = (Vertex)SearchVertexInGraph(vertex).GetData();
            for(SimpleNode pNode=VertexOfNode.GetListAdy().GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
                if(pNode.GetData().equals(vertex)){
                    val=true;
                    }
                }
            }
        return val;        
    }

    @Override
    public SimpleNode SearchArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        SimpleNode pNodeArcToReturn= new SimpleNode();
        if(IsVertexInGraph(vertex)){
            Vertex VertexToReview = (Vertex) SearchVertexInGraph(vertex).GetData();
            for(SimpleNode pNode=VertexToReview.GetListAdy().GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
                if(pNode.GetData().equals(arc)){
                    pNodeArcToReturn=pNode;
                }
            }
        }
        return pNodeArcToReturn;
    }

    @Override
    public boolean DelArcInVertexInGraph(Vertex vertex, UndirectedGraphArc arc) {
        boolean val=false;
        if(IsVertexInGraph(vertex)){
            Vertex VertexToReview = (Vertex) SearchVertexInGraph(vertex).GetData();
            for(SimpleNode pNode=VertexToReview.GetListAdy().GetpFirst(),pPrev=null;
                pNode!=null;
                pPrev=pNode,pNode=pNode.GetNxt()){
                if(pNode.GetData().equals(arc)){
                    pPrev.SetNxt(pNode.GetNxt());
                }        
            }
        }
        return val;
    }

    @Override
    public int AmountOfVertex() {
        int count=0;
        for(SimpleNode pNode=this.listOfVertex.GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
            count++;
        }
        return count;
    }

    @Override
    public String ShowGraphSummary() {
        StringBuilder summary = new StringBuilder();
        
        summary.append("Ciudades\n");
        for(SimpleNode pNode=this.listOfVertex.GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
            Vertex VertexToAppend = (Vertex) pNode.GetData();
            String text = VertexToAppend.ConvertToStringForTXT();
            summary.append(text).append("\n");
        }
        summary.append("Aristas\n");
        for(SimpleNode pNodeOfVertex=this.listOfVertex.GetpFirst();pNodeOfVertex!=null;pNodeOfVertex=pNodeOfVertex.GetNxt()){
            Vertex vertex = (Vertex) pNodeOfVertex.GetData();
            for(SimpleNode pNodeOfArc=vertex.GetListAdy().GetpFirst();pNodeOfArc!=null;pNodeOfArc=pNodeOfArc.GetNxt() ){
                UndirectedGraphArc arc = (UndirectedGraphArc) pNodeOfArc.GetData();
                summary.append(Integer.toString(arc.GetOrigin())).append(",").append(Integer.toString(arc.GetDestination())).append("\n");            
            }       
        }
        return summary.toString();
    }
    
    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    @Override
    public LinkedSimpleList getListofVertex() {
        return listOfVertex;
    }

    @Override
    public void setListofVertex(LinkedSimpleList ListofVertex) {
        this.listOfVertex = ListofVertex;
    }    
}
