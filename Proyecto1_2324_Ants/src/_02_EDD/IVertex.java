/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase Vertice
 * @author AresR
 * @version 17/02/2024
 */

public interface IVertex {
    
    public boolean IsEquals(Vertex n);
    
    public String ConvertToStringForTXT(); 
    
    public boolean IsArcInVertex(UndirectedGraphArc Arc);
    
    public boolean AddArc(UndirectedGraphArc Arc);
    
    public boolean DelArc(UndirectedGraphArc Arc);
    
    public int GetNumVertex();
    
    public void SetNumVertex(int numVertex);
   
    public LinkedSimpleList GetListAdy();
    
    public void SetListAdy(LinkedSimpleList listAdy);
    
    //Revisar otros posibles metodos
}
