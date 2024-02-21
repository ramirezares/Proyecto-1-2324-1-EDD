/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 *
 * @author AresR
 */
public class Vertex implements IVertex{
    
    private int numVertex;
    private LinkedSimpleList<UndirectedGraphArc> listAdy;

    /**
     *
     * @param n
     */
    public Vertex(int n) {
        this.numVertex=n;
        this.listAdy= new LinkedSimpleList<>();
    }
    
    //@Override
    public boolean IsEquals(Vertex vertex) {
        boolean val=false;
        if(this.numVertex==vertex.numVertex){
            val=true;   
        }
        return val;
    }
    
    //@Override
    public String ConvertToStringForTXT(){
        return Integer.toString(this.numVertex) ;
    }
    
    //@Override
    public boolean IsArcInGraph(UndirectedGraphArc Arc) {
        boolean val=false;
        for(SimpleNode pNode=this.listAdy.GetpFirst();
            pNode!=null;
            pNode=pNode.GetNxt()){
            
            UndirectedGraphArc ArcInNode = (UndirectedGraphArc) pNode.GetData();
            if(ArcInNode.IsEquals(Arc)){
                val=true;
                }
            
        }
        return val;
    }

    //@Override
    public boolean AddArc(UndirectedGraphArc Arc) {
        boolean val=false;
        if (!this.IsArcInGraph(Arc)){
            SimpleNode NNode=new SimpleNode();
            NNode.SetData(Arc);
            this.listAdy.GetpLast().SetNxt(NNode);
            this.listAdy.SetpLast(NNode);
            int NSize=this.listAdy.GetSize();
            NSize++;
            this.listAdy.SetSize(NSize);
            val=true;
        }
        return val;
    }

    //@Override
    public boolean DelArc(UndirectedGraphArc Arc) {
        boolean val=false;
        if (this.IsArcInGraph(Arc)){
            for(SimpleNode pNode=this.listAdy.GetpFirst(),pPrev=null;
                pNode!=null;
                pPrev=pNode,pNode=pNode.GetNxt())
                {
                if(pNode.GetData().equals(Arc)){
                    pPrev.SetNxt(pNode.GetNxt());
                    val=true;
                    break;
                    }
                }
        }
        return val;
    }

    //@Override
    public int GetNumVertex() {
        return numVertex;
    }

    //@Override
    public void SetNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    //@Override
    public LinkedSimpleList GetListAdy() {
        return listAdy;
    }

    //@Override
    public void SetListAdy(LinkedSimpleList listAdy) {
        this.listAdy = listAdy;
    }
}
