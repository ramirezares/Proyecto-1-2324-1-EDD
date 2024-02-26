/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase UndirectedGraphArc
 *
 * @author AresR
 * @version 17/02/2024
 */
public interface IUndirectedGraphArc {

    /**
     * Metodo a desarrollar para comprobar si dos arcos son iguales.
     *
     * @param Arc El arco con el que se comparará.
     * @return true si los arcos tienen el mismo origen y destino, false en caso
     * contrario.
     */
    public boolean IsEquals(UndirectedGraphArc Arc);

    /**
     * Metodo a desarrollar para obtener el vértice de origen del arco.
     *
     * @return El vértice de origen del arco.
     */
    public int GetOrigin();

    /**
     * Metodo a desarrollar para modificar el vértice de origen del arco. El
     * valor del argumento sera su nuevo valor.
     *
     * @param origin El nuevo vértice de origen del arco.
     */
    public void SetOrigin(int origin);

    /**
     * Metodo a desarrollar para obtener el vértice de destino del arco.
     *
     * @return El vértice de destino del arco.
     */
    public int GetDestination();

    /**
     * Metodo a desarrollar para modificar el vértice de destino del arco. El
     * valor del argumento sera su nuevo valor.
     *
     * @param destination El nuevo vértice de destino del arco.
     */
    public void SetDestination(int destination);

    /**
     * Metodo a desarrollar para obtener el peso del arco.
     *
     * @return El peso del arco.
     */
    public double GetWeight();

    /**
     * Metodo a desarrollar para modificar el peso del arco. El valor del
     * argumento sera su nuevo valor.
     *
     * @param weight El nuevo peso del arco.
     */
    public void SetWeight(double weight);

    /**
     * Metodo a desarrollar para obtener las feromonas del arco.
     *
     * @return Las feromonas del arco.
     */
    public double getPheromones();

    /**
     * Metodo a desarrollar para modificar las feromonas del arco. El valor del
     * argumento sera su nuevo valor.
     *
     * @param pheromones Las nuevas feromonas del arco.
     */
    public void setPheromones(double pheromones);
}
