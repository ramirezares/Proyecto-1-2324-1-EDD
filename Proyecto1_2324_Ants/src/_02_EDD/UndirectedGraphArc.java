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
   
    
   
    /**
     * INstancia la clase UndirectedGraphArc. Inicializa el origen y destino del arco 
     * con los identificadores indicados (Enteros). El peso o largo del arco y las 
     * feromonas se inicializan en 0.
     * @param origin El vértice de origen del arco.
     * @param destination El vértice de destino del arco.
     */
    public UndirectedGraphArc(int origin,int destination) {
        this.origin=origin;
        this.destination=destination;
        this.weight=0;
        this.pheromones=0;
    }

    /**
     * Constructor de UndirectedGraphArc que inicializa el origen, destino y peso del arco.
     * Las feromonas se inicializan en 0 por defecto.
     * @param origin El vértice de origen del arco.
     * @param destination El vértice de destino del arco.
     * @param weight El peso del arco.
     */
    public UndirectedGraphArc(int origin,int destination, double weight) {
        this.origin=origin;
        this.destination=destination;
        this.weight=weight;
        this.pheromones=0;
    }
    
    
    /**
     * Comprueba si dos arcos son iguales.
     * @param Arc El arco con el que se comparará.
     * @return True si los arcos tienen el mismo origen y destino, False en caso contrario.
     */
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

    /**
     * Obtiene el vértice de origen del arco.
     * @return El vértice de origen del arco.
     */
    @Override
    public int GetOrigin() {
        return origin;
    }

    /**
     * Establece el vértice de origen del arco.
     * @param origin El nuevo vértice de origen del arco.
     */
    @Override
    public void SetOrigin(int origin) {
        this.origin = origin;
    }

    
    /**
     * Obtiene el vértice de destino del arco.
     * @return El vértice de destino del arco.
     */
    @Override
    public int GetDestination() {
        return destination;
    }
    
    /**
     * Establece el vértice de destino del arco.
     * @param destination El nuevo vértice de destino del arco.
     */
    @Override
    public void SetDestination(int destination) {
        this.destination = destination;
    }

    /**
     * Obtiene el peso del arco.
     * @return El peso del arco.
     */
    @Override
    public double GetWeight() {
        return weight;
    }

    
    /**
     * Establece el peso del arco.
     * @param weight El nuevo peso del arco.
     */
    @Override
    public void SetWeight(double weight) {
        this.weight = weight;
    }

    
    /**
     * Obtiene las feromonas del arco.
     * @return Las feromonas del arco.
     */
    @Override
    public double getPheromones() {
        return pheromones;
    }

    /**
     * Establece las feromonas del arco.
     * @param pheromones Las nuevas feromonas del arco.
     */
    @Override
    public void setPheromones(double pheromones) {
        this.pheromones = pheromones;
    }
    
    
}