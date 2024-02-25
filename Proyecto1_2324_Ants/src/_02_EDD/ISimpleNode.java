/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase SimpleNode
 * @author AresR
 * @version 17/02/2024 (v2)
 * @param <A> Representa el tipo de dato que guardara el nodo, declarado general
 * Se usa "<>" para declararlo generico.
 */
public interface ISimpleNode<A> {
    
    /**
     * Metodo a desarrollar para acceder al valor del atributo Data de una 
     * instancia de la clase.
     * @return el valor almacenado en el atributo Data.
     */
    public A GetData();
    
    
    /**
     * Metodo a desarrollar para acceder al valor del atributo Nxt de una
     * instancia de la clase.
     * @return el valor almacenado en el atributo Nxt que es el siguiente nodo.
     */
    public SimpleNode GetNxt();
    
    /**
     * Metodo a desarrollar para modificar el valor almacenado en el atributo 
     * Nxt de una instancia de la clase.
     * @param NData dato a almacenar, representado con tipo generico A
     */
    public void SetData(A NData);
    
    /**
     * Metodo a desarrollar para modificar el valor almacenado en el atributo 
     * Nxt de una instancia de la clase.
     * @param NNxt Nodo que remplazará el contenido en el atributo next.
     */
    public void SetNxt(SimpleNode NNxt);
    
    //Verificar otros posibles metodos
}
