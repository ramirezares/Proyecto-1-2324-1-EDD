/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura para la clase LinkedSimpleList
 * @author AresR
 * @version 15/02/2024 (V2)
 * @param <A> Representa el tipo de dato que guardara el nodo, declarado general
 * Se usa "<>" para declararlo generico.
 */
public interface ILinkedList<A> {
    
    /**
     * Metodo a desarrollar para verificar si una instancia de la clase LinkedSimpleList
     * se encuentra vacia
     * @return Devuelve true si la instancia de la clase LinkedSimpleList no contiene 
     * ni un nodo, es decir, los atributos pFirst y pLast apuntan a null. En caso
     * contrario devuelve false.
     */
    public boolean isEmpty();
    
    /**
     * Metodo a desarrollar para insertar un nuevo valor como primer elemento en 
     * una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que guardara el nodo que se insertara de primero.
     */
    public void insertHead(A Data);
    
    /**
     * Metodo a desarrollar para insertar un nuevo valor como ultimo elemento en
     * una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que guardara el nodo que se insertara de ultimo.
     */
    public void insertLast(A Data);
    
    /**
     * Metodo a desarrollar para verificar si un valor determinado se encuentra dentro
     * dentro de una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que se busca dentro del la lista enlazada
     * @return Retorna true si el valor que se busca se encuentra dentro de la lista. 
     * De lo contrario retorna false.
     */
    public boolean isDataInList(A Data);
    
    /**
     * Metodo a desarrollar para buscar el nodo que contiene un valor determinado
     * dentro de una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que se busca dentro del la lista enlazada
     * @return Retorna un puntero al nodo que contiene el valor buscado.
     */
    public SimpleNode locateData(A Data);
    
    /**
     * Metodo a desarrollar para eliminar el nodo que contiene un valor determinado 
     * dentro de una instancia de la clase LinkedSimpleList.
     * @param Data Representa el valor que se desea eliminar dentro del la lista enlazada
     */
    public void delNodewithVal(A Data);
    
    /**
     * Metodo a desarrollar para eliminar todos los nodos que se encuentran
     * dentro de una instancia de la clase LinkedSimpleList.
     */
    public void destroyer();
    
    /**
     * Metodo a desarrollar para obtener el nodo que se encuentra en un indice especifico
     * @param n Representa el numero del indice de la lista que se desea obtener
     * @return Retorna el nodo que se encuentra en la posicion indicada, si esta posicion
     * existe dentro de la lista, es decir, si la posicion indicada pertenece al conjunto 
     * de numeros que se encuentran entre 0 y el tamaño de la lista. De lo contrario, si 
     * la lista esta vacia o si el indice indicado no se encuentra en la lista, retorna null
     */
    public SimpleNode GetValInIndex(int n);
    
    /**
     * Metodo a desarrollar para obtener el nodo que se encuentra en la cabeza de una
     * instancia de la clase LinkedSimpleList.
     * @return Retorna el nodo correspondiente al puntero pFirst
     */
    public SimpleNode GetpFirst();
    
    /**
     * Metodo a desarrollar para obtener el nodo que se encuentra en la cola de una
     * instancia de la clase LinkedSimpleList.
     * @return Retorna el nodo correspondiente al puntero pLast
     */
    public SimpleNode GetpLast();
    
    /**
     * Metodo a desarrollar para obtener el tamaño de una instancia de la clase 
     * LinkedSimpleList.
     * @return Retorna el entero que corresponde al atributo Size
     */
    public int GetSize();
    
    /**
     * Metodo a desarrollar para modificar el atributo pFirst de una instancia 
     * de la clase LinkedSimpleList. 
     * @param nFirst Representa el nuevo nodo que almacenará a pFirst
     */
    public void SetpFirst(SimpleNode nFirst);
    
    /**
     * Metodo a desarrollar para modificar el atributo pLast de una instancia 
     * de la clase LinkedSimpleList. 
     * @param sLast Representa el nuevo nodo que almacenará a pLast
     */
    public void SetpLast(SimpleNode sLast);
    
    /**
     * Metodo a desarrollar para modificar el atributo Size de una instancia 
     * de la clase LinkedSimpleList.
     * @param nSize Representa el nuevo valor que almacenará Size.
     */
    public void SetSize(int nSize);
    
    //Verificar otros posibles metodos
}
