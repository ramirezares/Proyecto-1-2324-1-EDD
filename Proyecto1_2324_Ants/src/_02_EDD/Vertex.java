/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 * Clase Vertex
 * Esta clase define el objeto grafo y su comportamiento, con sus atributos numVertex
 * y listAdy, que corresponden al identificador del vertice y a la lista de arcos.
 * @author AresR
 * @version 20/02/2024
 */
public class Vertex implements IVertex{
    
    // Número que identifica al vértice
    // Lista de arcos adyacentes al vértice    
    private int numVertex;
    private LinkedSimpleList<UndirectedGraphArc> listAdy;

    /**
     * Instancia la clase Vertex. Inicializa el número de vértice como el numero
     * indicado y la lista de arcos adyacentes como una lista vacia.
     * @param n El número que identificará al vértice.
     */
    public Vertex(int n) {
        this.numVertex=n;
        this.listAdy= new LinkedSimpleList<>();
    }
    
    /**
     * Comprueba si dos vértices son iguales.
     * @param vertex El vértice con el que se comparará.
     * @return True si los vértices tienen el mismo número, False en caso contrario.
     */
    @Override
    public boolean IsEquals(Vertex vertex) {
        boolean val=false;
        if(this.numVertex==vertex.numVertex){
            val=true;   
        }
        return val;
    }
    
    /**
     * Convierte el vértice a un formato de cadena de texto para ser guardado en un archivo de texto.
     * @return El número del vértice en formato de cadena de texto.
     */
    @Override
    public String ConvertToStringForTXT(){
        return Integer.toString(this.numVertex) ;
    }
    
    /**
     * Verifica si un arco está presente en la lista de arcos adyacentes del vértice.
     * @param Arc El arco que se busca en la lista.
     * @return True si el arco está en la lista, False en caso contrario.
     */
    @Override
    public boolean IsArcInVertex(UndirectedGraphArc Arc) {
        boolean val=false;
        for(SimpleNode pNode=this.listAdy.GetpFirst();pNode!=null;pNode=pNode.GetNxt()){
            
            UndirectedGraphArc ArcInNode = (UndirectedGraphArc) pNode.GetData();
            if(ArcInNode.IsEquals(Arc)){
                val=true;
                }
        }
        return val;
    }

    /**
     * Agrega un arco a la lista de arcos adyacentes del vértice.
     * @param Arc El arco que se agrega a la lista.
     * @return true si se agregó el arco con éxito, false si el arco ya estaba presente en la lista.
     */
    @Override
    public boolean AddArc(UndirectedGraphArc Arc) {
        boolean val=false;
        if (!this.IsArcInVertex(Arc)){
            SimpleNode NNode=new SimpleNode();
            NNode.SetData(Arc);
            this.listAdy.insertLast(Arc);
            val=true;
        }
        return val;
    }

    /**
     * Elimina un arco de la lista de arcos adyacentes del vértice.
     * @param Arc El arco que se eliminará de la lista.
     * @return True si se eliminó el arco con éxito, False si el arco no estaba presente en la lista.
     */
    @Override
    public boolean DelArc(UndirectedGraphArc Arc) {
        boolean val=false;
        if (this.IsArcInVertex(Arc)){
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

    /**
     * Obtiene el número del vértice.
     * @return El número del vértice.
     */
    @Override
    public int GetNumVertex() {
        return numVertex;
    }

    /**
     * Establece el número del vértice.
     * @param numVertex El nuevo número del vértice.
     */
    @Override
    public void SetNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    /**
     * Obtiene la lista de arcos adyacentes del vértice.
     * @return La lista de arcos adyacentes.
     */
    @Override
    public LinkedSimpleList GetListAdy() {
        return listAdy;
    }

    /**
     * Establece la lista de arcos adyacentes del vértice.
     * @param listAdy La nueva lista de arcos adyacentes.
     */
    @Override
    public void SetListAdy(LinkedSimpleList listAdy) {
        this.listAdy = listAdy;
    }
}