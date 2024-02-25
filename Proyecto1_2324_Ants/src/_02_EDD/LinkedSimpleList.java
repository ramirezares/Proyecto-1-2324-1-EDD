/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 * Clase LinkedSimpleList
 * Esta clase define el objeto lista y su comportamiento, con sus atributos pFirst,
 * pLast y size. Siendo pFirst y pLast de la clase SimpleNode.
 * @author AresR
 * @version 17/02/2024
 * @param <A> Representa el tipo de dato que guardara el nodo, declarado general.
 * Se usa "<>" para declararlo generico.
 */
public class LinkedSimpleList<A> implements ILinkedList<A> {
    
    private SimpleNode pFirst;
    private SimpleNode pLast;
    private int size;
    
    /**
     * Instancia la clase LinkedSimpleList definiendo los atributos pFirst y pLast
     * como null y size como 0. Crea la lista vacia.
     */
    public LinkedSimpleList() {
        this.pFirst=this.pLast=null;
        size=0;
    }

    /**
     * Verifica si una instancia de la clase LinkedSimpleList se encuentra vacia
     * o no. Verifica si la lista tiene por lo menos un elemento.
     * @return Retorna True si la lista no tiene elementos. En caso contrario 
     * retorna false.
     */
    @Override
    public boolean isEmpty() {
        boolean val=false;
        if (this.size==0){
            val=true;
        }
        return val;
    }
    
    /**
     * Inserta un nuevo valor como primer elemento en una instancia de la clase 
     * LinkedSimpleList.
     * @param Data Representa el valor que guardara el nodo que se insertara de 
     * primero en la cabeza de la lista.
     */
    @Override
    public void insertHead(A Data) {
        SimpleNode NNode = new SimpleNode(Data);
        if(this.size<2){
            if(this.pFirst==null){
                this.pFirst=this.pLast=NNode;
            }else if(this.pFirst==this.pLast){
                NNode.SetNxt(this.pFirst);
                this.pFirst=NNode;
            }
        } else{
            SimpleNode aux = this.pFirst;
            NNode.SetNxt(aux);
            this.pFirst = NNode;
        }
        this.size++;
    }

    /**
     * Inserta un nuevo valor como ultimo elemento en una instancia de la clase 
     * LinkedSimpleList.
     * @param Data Representa el valor que guardara el nodo que se insertara en 
     * el final de la lista.
     */
    @Override
    public void insertLast(A Data) {
        SimpleNode NNode = new SimpleNode(Data);
        NNode.SetData(Data);
        if (size<2){
            if (this.pFirst==null){
                this.pFirst=this.pLast=NNode; 
            } else if(this.pFirst==this.pLast){
                this.pLast.SetNxt(NNode);
                this.pLast=NNode;
            }
        } 
        else{
            this.pLast.SetNxt(NNode);
            this.pLast=NNode;
        }
        this.size++;
    }

    /**
     * Verifica que un valor se encuentre en una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que se busca en la lista.
     * @return Retorna true si el valor buscado se encuentra en la lista. En caso
     * contrario retorna false.
     */
    @Override
    public boolean isDataInList(A Data) {
        boolean val=false;
        for(SimpleNode pNode=this.pFirst;pNode!=null;pNode=pNode.GetNxt()){
            if(java.util.Objects.equals(pNode.GetData(),Data)){
                val=true;
            }
        }
        return val;
    }
    
    /**
     * Busca el valor espeficicado en una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que se busca en la lista.
     * @return Retorna un puntero al nodo donde se encuenta, si el valor especificado
     * esta en la lista. En caso contrario muestra el mensaje "El valor no se 
     * encuentra en la lista" y retorna null.
     */
    @Override
    public SimpleNode locateData(A Data) {
        SimpleNode pMatched;
        if (isDataInList(Data)){
            for (SimpleNode pNode=this.pFirst; pNode!=null ;pNode=pNode.GetNxt())
                if(java.util.Objects.equals(pNode.GetData(), Data)){
                    pMatched=pNode;
                    return pMatched;
                }
        }
        System.out.println("El valor no se encuentra en la lista");
        return null;
    }
    
    /**
     * Elimina el nodo que contiene el valor especificado en una instancia de la
     * clase LinkedSimpleList. En caso de que el valor no se encuentre en la lista
     * muestra el mensaje: "El valor a eliminar no esta en la lista."
     * @param Data Representa el valor que tiene el nodo que se eliminara en la lista.
     * 
     */
    @Override
    public void delNodewithVal(A Data) {
        if (isDataInList(Data)){
            for(SimpleNode pPrev=null,pCurrent=this.pFirst;
                pCurrent!=null;
                pPrev=pCurrent,pCurrent=pCurrent.GetNxt()){
                
                if (java.util.Objects.equals(pCurrent.GetData(), Data)){
                    pPrev.SetNxt(pCurrent.GetNxt());
                    break;
                }
            }
        }
        else{
            System.out.println("El valor a eliminar no esta en la lista.");
        }
    }

    /**
     * Elimina todos los nodos que se encuentren dentro de una instancia 
     * de la clase LinkedSimpleList. 
     */
    @Override
    public void destroyer() {
        for (SimpleNode pNode=this.pFirst;pNode!=null;pNode=pNode.GetNxt()){
            this.pFirst=pNode.GetNxt();
        }
        System.out.println("Lista vaciada.");
    }

    /**
     * Busca y devuelve el nodo que se encuentra en un indice indicado.
     * @param index Representa el numero del indice de la lista que se desea obtener
     * @return  Retorna el nodo que se encuentra en la posicion indicada, si esta posicion
     * existe dentro de la lista, es decir, si la posicion indicada pertenece al conjunto 
     * de numeros que se encuentran entre 0 y el tamaño de la lista. De lo contrario, si 
     * la lista esta vacia o si el indice indicado no se encuentra en la lista, retorna null
     */
    @Override
    public SimpleNode GetValInIndex(int index) {
        SimpleNode matched;
        if (this.size>0){
            if(index<=this.size){
                int aux=0;
                for (SimpleNode pNode=this.pFirst;pNode!=null;pNode=pNode.GetNxt()){
                    if (aux==index){
                        matched=pNode;
                        return matched;
                    }
                    aux++;
                }
            }
        }
        return null;
    }
    
    public void SetValInIndex(int index,A newData){
        if (this.size>0){
            if(index<=this.size){
                int aux=1;
                for (SimpleNode pNode=this.pFirst;pNode!=null;pNode=pNode.GetNxt()){
                    if (aux==index){
                        pNode.SetData(newData);
                        break;
                    }
                    aux++;
                }
            }
        }
    }

    /**
     * Obtiene el nodo guardado en el atributo pFirst de una instancia de la
     * clase LinkedSimpleList.
     * @return Retorna el nodo guardado en el atributo pFirst
     */
    @Override
    public SimpleNode GetpFirst(){
        return this.pFirst;
    }

    /**
     * Obtiene el nodo guardado en el atributo pLast de una instancia de la
     * clase LinkedSimpleList.
     * @return Retorna el nodo guardado en el atributo pLast
     */
    @Override
    public SimpleNode GetpLast(){
        return this.pLast;
    }

    /**
     * Obtiene el valor guardado en el atributo Size de una instancia de la
     * clase LinkedSimpleList.
     * @return Retorna el entero guardado en el atributo Size que representa el 
     * largo de la lista
     */
    @Override
    public int GetSize() {
        return this.size;
    }

    /**
     * Modifica el atributo pFirst de una instancia de la clase LinkedSimpleList,
     * remplazandolo por un nuevo nodo.
     * @param nFirst
     */
    @Override
    public void SetpFirst(SimpleNode nFirst) {
        this.pFirst = nFirst;
    }

    /**
     * Modifica el atributo pLast de una instancia de la clase LinkedSimpleList,
     * remplazandolo por un nuevo nodo.
     * @param nLast
     */
    @Override
    public void SetpLast(SimpleNode nLast) {
        this.pLast = nLast;
    }

    /**
     * Modifica el atributo size de una instancia de la clase LinkedSimpleList,
     * remplazandolo por el nuevo valor que tendra size.
     * @param nSize
     */
    @Override
    public void SetSize(int nSize) {
        this.size = nSize;
    }
    
    // Crear metodo para obtener los contenidos de una lista segun el indice. Recorrer lista de hormigas
}
