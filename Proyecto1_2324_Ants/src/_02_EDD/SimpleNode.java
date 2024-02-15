/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 * Clase SimpleNode
 * Esta clase define el objeto nodo y su comportamiento, con sus atributos Data y Nxt
 * @author AresR
 * @version 13/02/2024
 * @param <A> Representa el tipo de dato que guardara el nodo. 
 * Se usa "<>" para declararlo generico.
 */
public class SimpleNode<A> implements ISimpleNode<A> {

    private A Data;
    private SimpleNode Nxt;
    
    /**
     * Instancia la clase SimpleNode otorgando un valor al atributo Data,
     * Nxt se define como null. 
     * @param Data Representa el tipo de dato que guardara el nodo.
     */
    @Override
    public void SimpleNode(A Data){
        this.Data=Data;
        this.Nxt=null;
    }
    
    /**
     * Instancia la clase SimpleNode otorgando un valor a los atributos Data y Nxt.
     * @param Data Representa el tipo de dato que guardara el nodo.
     * @param Nxt representa el puntero que guarda/apunta el siguiente nodo
     */
    @Override
    public void SimpleNode(A Data,SimpleNode Nxt){
        this.Data=Data;
        this.Nxt=Nxt;
    }
    
    /**
     * Permite acceder al valor almacenado en el atributo Data de una instancia 
     * de la clase SimpleNode
     * @return El valor almacenado en el atributo Data.
     */
    @Override
    public A GetData(){
        return this.Data;
    }
    
    /**
     * Permite acceder al valor almacenado en el atributo Nxt de una instancia 
     * de la clase SimpleNode, el cual representa el siguiente nodo.
     * @return El valor almacenado en el atributo Nxt.
     */
    @Override
    public SimpleNode GetNxt(){
        return this.Nxt;
    }
    
    /**
     * Permite modificar el valor almacenado en el atributo Data de una instancia 
     * de la clase SimpleNode.
     */
    @Override
    public void SetData(A NData) {
        this.Data=NData;
    }
    
    /**
     * Permite modificar el valor almacenado en el atributo Nxt de una instancia 
     * de la clase SimpleNode, el cual representa el siguiente nodo. Realiza la 
     * asignacion del nuevo nodo al que apunta.
     */
    @Override
    public void SetNxt(SimpleNode NNxt) {
        this.Nxt=NNxt;
    }
    
}
