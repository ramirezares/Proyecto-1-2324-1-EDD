/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 *
 * @author AresR
 */
public interface IUndirectedGraphArc {
    
    public void Arc(int destination);
    
    public void Arc(int destino,double peso);
    
    public int GetDestination();
    
    public boolean IsEquals(UndirectedGraphArc A); 
    
    //Revisar otros posibles metodos
}
