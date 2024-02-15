/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura para la clase SimpleNode
 * @author AresR
 * @version 13/02/2024
 * @param <A> Representa el tipo de dato que guardara el nodo.
 */
public interface ISimpleNode<A> {
    
    /**
     * Metodo a desarrollar para instanciar la clase SimpleNode otorgando un 
     * valor al atributo Data. Nxt se define como null. 
     * @param Data Representa el valor que guardara el nodo.
     */
    public void SimpleNode(A Data);
    
    /**
     * Metodo a desarrollar para instanciar la clase SimpleNode otorgando un 
     * valor a los atributos Data y Nxt
     * @param Data Representa el valor que guardara el nodo.
     * @param Nxt representa el puntero que guarda/apunta el siguiente nodo
     */
    public void SimpleNode(A Data,SimpleNode Nxt);
    
    /**
     * Metodo a desarrollar para acceder al valor del atributo Data de una 
     * instancia de la clase.
     * @return el valor almacenado en el atributo Data.
     */
    public A GetData();
    
    
    /**
     * Metodo a desarrollar para acceder al valor del atributo Nxt de una
     * instancia de la clase.
     * @return el valor almacenado en el atributo Nxt.
     */
    public SimpleNode GetNxt();
    
    /**
     * Metodo a desarrollar para modificar el valor almacenado en el atributo 
     * Nxt de una instancia de la clase.
     */
    public void SetData(A NData);
    
    /**
     * Metodo a desarrollar para modificar el valor almacenado en el atributo 
     * Nxt de una instancia de la clase.
     */
    public void SetNxt(SimpleNode NNxt);
    
    //Verificar otros posibles metodos
}
