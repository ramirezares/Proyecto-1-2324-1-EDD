/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 *
 * @author AresR
 */
public interface IVertex {
    
    public void Vertex(String name);
    
    public String GetVertexName();//return name
    
    public boolean IsEquals(Vertex n);
    
    public void SetVertNumber(int n); //Establece el numero de vertices
    
    public String ConvertToStringForPrint(); //Caracteristicas del vertice
    
    //Revisar otros posibles metodos
}
