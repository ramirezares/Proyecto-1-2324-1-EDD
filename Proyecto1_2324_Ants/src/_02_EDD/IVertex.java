/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package _02_EDD;

/**
 * Esta interfaz define la estructura basica para la clase Vertex
 *
 * @author AresR
 * @version 21/02/2024 (v2)
 */
public interface IVertex {

    /**
     * Metodo a desarrollar para comprobar si dos vértices son iguales.
     *
     * @param vertex El vértice con el que se comparará.
     * @return True si los vértices tienen el mismo número, False en caso
     * contrario.
     */
    public boolean IsEquals(Vertex vertex);

    /**
     * Metodo a desarrollar para convertir el vértice a un formato de cadena de
     * texto para ser guardado en un archivo de texto.
     *
     * @return El número del vértice en formato de cadena de texto.
     */
    public String ConvertToStringForTXT();

    /**
     * Metodo a desarrollar para verificar si un arco está presente en la lista
     * de arcos adyacentes del vértice.
     *
     * @param Arc El arco que se busca en la lista.
     * @return True si el arco está en la lista, False en caso contrario.
     */
    public boolean IsArcInVertex(UndirectedGraphArc Arc);

    /**
     * Metodo a desarrollar para agregar un arco a la lista de arcos adyacentes
     * del vértice.
     *
     * @param Arc El arco que se agrega a la lista.
     * @return true si se agregó el arco con éxito, false si el arco ya estaba
     * presente en la lista.
     */
    public boolean AddArc(UndirectedGraphArc Arc);

    /**
     * Metodo a desarrollar para eliminar un arco de la lista de arcos
     * adyacentes del vértice.
     *
     * @param Arc El arco que se eliminará de la lista.
     * @return True si se eliminó el arco con éxito, False si el arco no estaba
     * presente en la lista.
     */
    public boolean DelArc(UndirectedGraphArc Arc);

    /**
     * Metodo a desarrollar para obtener el número del vértice.
     *
     * @return El número del vértice.
     */
    public int GetNumVertex();

    /**
     * Metodo a desarrollar para modificar el número del vértice, reemplazandolo
     * por el nuevo numero que lo identificará
     *
     * @param numVertex El nuevo número del vértice.
     */
    public void SetNumVertex(int numVertex);

    /**
     * Metodo a desarrollar para obtener la lista de arcos adyacentes del
     * vértice.
     *
     * @return La lista de arcos adyacentes.
     */
    public LinkedSimpleList GetListAdy();

    /**
     * Metodo a desarrollar para modificar el atributo que representa la lista
     * enlazada de arcos del vértice, reemplazandola por la nueva lista que se
     * le indica.
     *
     * @param listAdy La nueva lista de arcos adyacentes.
     */
    public void SetListAdy(LinkedSimpleList listAdy);
}
