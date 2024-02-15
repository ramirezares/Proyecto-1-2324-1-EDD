/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura para la clase LinkedSimpleList
 * @author AresR
 * @version 13/02/2024
 * @param <A>
 */
public interface ILinkedList<A> {
    
    /**
     * Metodo a desarrollar para instanciar la clase LinkedSimpleList.
     */
    public void LinkedSimpleList();
    
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
    
    //Verificar otros posibles metodos
}
