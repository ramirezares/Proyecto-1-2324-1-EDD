/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 *
 * @author AresR
 */
public class UndirectedGraphArc implements IUndirectedGraphArc {

    private int origin;
    private int destination;
    private double weight; 
    private double pheromones;
   
    public UndirectedGraphArc(int origin,int destination) {
        this.origin=origin;
        this.destination=destination;
        this.pheromones=0;
    }

    public UndirectedGraphArc(int origin,int destination, double weight) {
        this.origin=origin;
        this.destination=destination;
        this.weight=weight;
        this.pheromones=0;
    }
    
    @Override
    public boolean IsEquals(UndirectedGraphArc Arc) {
        boolean val=false;
        if (this.GetOrigin()==Arc.GetOrigin()
                &&
            this.GetDestination()==Arc.GetDestination()){
            val=true;
        }
        return val;
    }

    @Override
    public int GetOrigin() {
        return origin;
    }

    @Override
    public void SetOrigin(int origin) {
        this.origin = origin;
    }

    @Override
    public int GetDestination() {
        return destination;
    }

    @Override
    public void SetDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public double GetWeight() {
        return weight;
    }

    @Override
    public void SetWeight(double weight) {
        this.weight = weight;
    }

    public double getPheromones() {
        return pheromones;
    }

    public void setPheromones(double pheromones) {
        this.pheromones = pheromones;
    }
    
    
}
