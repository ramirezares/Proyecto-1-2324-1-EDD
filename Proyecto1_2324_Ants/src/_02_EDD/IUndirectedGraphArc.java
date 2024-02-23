/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase UndirectedGraphArc
 * @author AresR
 * @version 17/02/2024
 */
public interface IUndirectedGraphArc {
    
    public boolean IsEquals(UndirectedGraphArc Arc);
    
    public int GetOrigin();
    
    public void SetOrigin(int origin);
    
    public int GetDestination();
    
    public void SetDestination(int destination);
    
    public double GetWeight();
    
    public void SetWeight(double weight);
    
    public double getPheromones();
    
    public void setPheromones(double pheromones);
    
    //Revisar otros posibles metodos
}
