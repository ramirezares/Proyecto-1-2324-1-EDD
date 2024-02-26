/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _03_Classes;

import _02_EDD.LinkedSimpleList;
import _02_EDD.UndirectedGraph;
import _02_EDD.UndirectedGraphArc;
import _02_EDD.Vertex;
import java.util.Random;

/**
 *
 * @author AresR
 */
public class AntSystemCycle {

    UndirectedGraph GraphOfSimulation;          //Grafo a recorrer
    LinkedSimpleList listOfAnts;                //Lista de hormigas que formaran parte de la simulacion
    int alfaValue, betaValue;                   //Valor de alfa para la simulacion
    double rhoValue;                            //Valor de beta para la simulacion
    int numberOfCycle;                          //Valor de rho para la simulacion
    Vertex StartVertex, EndVertex;              //Numero del ciclo 
    LinkedSimpleList bestRouteArcs;             //Vertice de partida para la simulacion
    double bestDistance, totalDistanceTraveled; //Vertice de llegada para la simulacion
    double AmountOfPheromones;                  //Cantidad de feromonas del ciclo

    /**
     * Instancia la clase AntSystemCycle con todos sus atributos vacios o en 0.
     */
    public AntSystemCycle() {
        this.GraphOfSimulation = new UndirectedGraph();
        this.listOfAnts = new LinkedSimpleList();
        this.alfaValue = 0;
        this.betaValue = 0;
        this.rhoValue = 0;
        this.numberOfCycle = 0;
        this.StartVertex = new Vertex(0);
        this.EndVertex = new Vertex(0);
        this.bestRouteArcs = new LinkedSimpleList();
        this.bestDistance = 0;
        this.totalDistanceTraveled = 0;
        this.AmountOfPheromones = 0;
    }

    /**
     * Instancia la clase AntSystemCycle con los valores iniciales obtenidos de
     * los datos para la simulacion
     *
     * @param GraphOfSimulation grafo a recorrer
     * @param listOfAnts lista de hormigas que formaran parte de la simulacion
     * @param alfaValue valor de alfa para la simulacion
     * @param betaValue valor de beta para la simulacion
     * @param rhoValue valor de rho para la simulacion
     * @param numberOfCycle numero del ciclo
     * @param StartVertex vertice de partida para la simulacion
     * @param EndVertex vertice de llegada para la simulacion
     */
    public AntSystemCycle(UndirectedGraph GraphOfSimulation,
            LinkedSimpleList listOfAnts, int alfaValue, int betaValue,
            double rhoValue, int numberOfCycle,
            Vertex StartVertex, Vertex EndVertex) {
        this.GraphOfSimulation = GraphOfSimulation;
        this.listOfAnts = listOfAnts;
        this.alfaValue = alfaValue;
        this.betaValue = betaValue;
        this.rhoValue = rhoValue;
        this.numberOfCycle = numberOfCycle;
        this.StartVertex = StartVertex;
        this.EndVertex = EndVertex;
        this.bestRouteArcs = new LinkedSimpleList();
        this.bestDistance = 0;
        this.totalDistanceTraveled = 0;
        this.AmountOfPheromones = 0;
    }

    /**
     * Realiza un ciclo, realizando el recorrido completo para cada hormiga de
     * la simulacion.
     *
     * @param listOfAntsToCycle lista de hormigas que forman parte del ciclo.
     * @param NumberOfCycle numero del ciclo para el resumen del ciclo
     * @return resumen del ciclo, con el numero del mismo y el resumen del
     * recorrido de cada hormiga
     */
    public String eachCycle(LinkedSimpleList listOfAntsToCycle, int NumberOfCycle) {
        StringBuilder summaryOfCycle = new StringBuilder();
        summaryOfCycle.append("Ciclo ").append(NumberOfCycle).append(". Resumen de las hormigas:\n");
        summaryOfCycle.append(" ");

        for (int i = 0; i < listOfAntsToCycle.GetSize(); i++) {
            Ant antN = (Ant) listOfAntsToCycle.GetValInIndex(i).GetData();
            this.completeAntRoute(antN);
            summaryOfCycle.append(completeAntRoute(antN)).append("\n");
        }
        evaporatePheromones();

        return summaryOfCycle.toString();
    }

    /**
     * Realiza un recorrido completo, moviendo a la hormiga por los vertices,
     * empleando los demas metodos.
     *
     * @param ant instancia de la clase Ant a ciclar.
     * @return el texto resumen del recorrido de la hormiga para ser mostrado en
     * la interfaz.
     */
    public String completeAntRoute(Ant ant) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < this.GraphOfSimulation.getListofVertex().GetSize(); i++) {
            if (ant.getCurrentVertex().GetNumVertex() != this.EndVertex.GetNumVertex()) {
                LinkedSimpleList candidateVertexs = getCandidateArcsToVertexs(ant);
                if (!candidateVertexs.isEmpty()) {
                    LinkedSimpleList probability = probabilityList(candidateVertexs);
                    UndirectedGraphArc arc = chooseNextVertex(probability, candidateVertexs);
                    Vertex vertexToMove = this.GraphOfSimulation.SearchVertexInGraphWithNum(arc.GetDestination());
                    if (!ant.verifyAmongVisitedVertexs(arc.GetDestination())) {
                        this.move(ant, vertexToMove, arc.GetWeight());
                    }

                }
            }
        }
        if (this.bestDistance == 0) {
            this.setBestDistance(ant.getTotalDistanceTraveled());
            this.setBestRouteArcs(ant.getVertexsTraveled());
        } else if (ant.getTotalDistanceTraveled() < this.getBestDistance() && ant.getCurrentVertex().GetNumVertex() == this.EndVertex.GetNumVertex()) {
            this.setBestDistance(ant.getTotalDistanceTraveled());
            this.setBestRouteArcs(ant.getVertexsTraveled());
        }
        this.increasePheromones(ant);
        txt.append(ant.ToSummary());
        return txt.toString();
    }

    /**
     * Construye y retorna la lista de arcos que dirigen a vertices que la
     * hormiga no ha visitado.
     *
     * @param ant instancia de la clase Ant a la cual se le genera la lista
     * @return la lista de arcos que la hormiga puede recorrer.
     */
    public LinkedSimpleList<UndirectedGraphArc> getCandidateArcsToVertexs(Ant ant) {

        LinkedSimpleList<UndirectedGraphArc> candidateVertexs = new LinkedSimpleList<>();
        Vertex vertex = ant.getCurrentVertex();

        for (int i = 0; i < vertex.GetListAdy().GetSize(); i++) {
            UndirectedGraphArc Arc = (UndirectedGraphArc) vertex.GetListAdy().GetValInIndex(i).GetData();
            if (!ant.verifyAmongVisitedVertexs(Arc.GetDestination())) {
                candidateVertexs.insertLast(Arc);
            }
        }
        return candidateVertexs;
    }

    /**
     * Construye y retorna la lista de probabilidades segun la lista de arcos
     * indicada y los atributos de cada arco.
     *
     * @param candidateVertexs lista de vertices a los cuales la hormiga puede
     * ir.
     * @return la lista de probabilidades con las probabilidades de cada
     * vertice.
     */
    public LinkedSimpleList probabilityList(LinkedSimpleList candidateVertexs) {
        LinkedSimpleList probabilitiesDivListToReturn = new LinkedSimpleList();
        LinkedSimpleList Probabilities = new LinkedSimpleList();

        double sumatory = 0;
        for (int i = 0; i < candidateVertexs.GetSize(); i++) {
            UndirectedGraphArc arc = (UndirectedGraphArc) candidateVertexs.GetValInIndex(i).GetData();

            double probability = Math.pow(arc.getPheromones(), this.alfaValue) * Math.pow(1 / arc.GetWeight(), this.betaValue);;
            Probabilities.insertLast(probability);
            sumatory += probability;
        }

        for (int i = 0; i < Probabilities.GetSize(); i++) {
            double probabilityOfVertex = ((double) Probabilities.GetValInIndex(i).GetData()) / sumatory;
            probabilitiesDivListToReturn.insertLast(probabilityOfVertex);
        }

        return probabilitiesDivListToReturn;
    }

    /**
     * Decide y retorna el nuevo vertice segun la lista de probabilidades y los
     * vertices candidatos para ir, por los cuales la hormiga no ha pasado.
     *
     * @param probabilitiesDivListToUse lista de probabilidades para decidir el
     * nuevo vertice.
     * @param candidateVertexs lista de vertices a los cuales puede ir la
     * hormiga.
     * @return el camino al vertice destino elegido.
     */
    public UndirectedGraphArc chooseNextVertex(LinkedSimpleList probabilitiesDivListToUse, LinkedSimpleList<UndirectedGraphArc> candidateVertexs) {
        LinkedSimpleList<Integer> indexs = new LinkedSimpleList();
        double MayorProbability = 0;
        for (int i = 0; i < probabilitiesDivListToUse.GetSize(); i++) {
            double probInIndex = (double) probabilitiesDivListToUse.GetValInIndex(i).GetData();
            if (probInIndex > MayorProbability || probInIndex == MayorProbability) {
                MayorProbability = probInIndex;
                indexs.insertLast(i);
            }
        }
        Random randomNumbers = new Random();
        int indexArc = randomNumbers.nextInt(indexs.GetSize());

        UndirectedGraphArc ArcChosed = (UndirectedGraphArc) candidateVertexs.GetValInIndex(indexArc).GetData();
        return ArcChosed;
    }

    /**
     * Reinicia el recorrido de las hormigas para un nuevo ciclo de la
     * simulacion. Devuelve a la hormiga al vertice de inicio, y borra su
     * trayectoria (lista de vertices) y distancia recorrida.
     */
    public void restartAnts() {
        for (int i = 0; i < this.listOfAnts.GetSize(); i++) {
            Ant antReset = (Ant) this.listOfAnts.GetValInIndex(i).GetData();

            antReset.setCurrentVertex(this.StartVertex);
            antReset.setVertexsTraveled(new LinkedSimpleList());
            antReset.setTotalDistanceTraveled(0.0);
        }
    }

    /**
     * Incrementa las feromonas para cada camino recorrido por una instancia de
     * la clase hormiga.
     *
     * @param ant instancia de la clase hormiga que recorre los caminos e
     * incrementa su atributo feromona.
     */
    public void increasePheromones(Ant ant) {
        double RoadVisibilityFactor = (1.0 / ant.getTotalDistanceTraveled());

        for (int i = 0; i < ant.getVertexsTraveled().GetSize() - 1; i++) {
            Vertex auxVertex = (Vertex) ant.getVertexsTraveled().GetValInIndex(i).GetData();
            Vertex nextAuxVertex = (Vertex) ant.getVertexsTraveled().GetValInIndex(i + 1).GetData();

            double totalPheromones = RoadVisibilityFactor + auxVertex.SearchArcwithNumOfVertexs(nextAuxVertex.GetNumVertex()).getPheromones();

            auxVertex.SearchArcwithNumOfVertexs(nextAuxVertex.GetNumVertex()).setPheromones(totalPheromones);
        }
    }

    /**
     * Evapora las feromonas de los arcos o caminos segun el valor de rho "p".
     */
    public void evaporatePheromones() {
        for (int i = 0; i < GraphOfSimulation.getListofVertex().GetSize(); i++) {
            Vertex currentVertex = (Vertex) this.GraphOfSimulation.getListofVertex().GetValInIndex(i).GetData();
            for (int j = 0; j < currentVertex.GetListAdy().GetSize(); j++) {
                UndirectedGraphArc currentArc = (UndirectedGraphArc) currentVertex.GetListAdy().GetValInIndex(j).GetData();
                double evaporatedPheromones = (1 - this.rhoValue) * currentArc.getPheromones();
                currentArc.setPheromones(evaporatedPheromones);
            }
        }
    }

    /**
     * Permite el movimiento de una instancia de la clase Ant, definiendo su
     * nuevo vertice actual, añadiendolo a su lista de vertices y modificando su
     * distancia recorrida.
     *
     * @param ant instancia de la clase hormiga a ser actualizada.
     * @param Destination vertice al cual se moverá hormiga.
     * @param distanceOfPath distancia a ser sumada a la distancia total
     * recorrida por la instancia
     */
    public void move(Ant ant, Vertex Destination, double distanceOfPath) {

        Vertex newCurrentVertex = this.GraphOfSimulation.SearchVertexInGraphWithNum(Destination.GetNumVertex());

        ant.setCurrentVertex(newCurrentVertex);
        ant.setTotalDistanceTraveled(ant.getTotalDistanceTraveled() + distanceOfPath);
        ant.getVertexsTraveled().insertLast(Destination);

    }

    public UndirectedGraph getGraphOfSimulation() {
        return GraphOfSimulation;
    }

    public void setGraphOfSimulation(UndirectedGraph GraphOfSimulation) {
        this.GraphOfSimulation = GraphOfSimulation;
    }

    public LinkedSimpleList getListOfAnts() {
        return listOfAnts;
    }

    public void setListOfAnts(LinkedSimpleList listOfAnts) {
        this.listOfAnts = listOfAnts;
    }

    public int getAlfaValue() {
        return alfaValue;
    }

    public void setAlfaValue(int alfaValue) {
        this.alfaValue = alfaValue;
    }

    public int getBetaValue() {
        return betaValue;
    }

    public void setBetaValue(int betaValue) {
        this.betaValue = betaValue;
    }

    public double getRhoValue() {
        return rhoValue;
    }

    public void setRhoValue(double rhoValue) {
        this.rhoValue = rhoValue;
    }

    public int getNumberOfCycle() {
        return numberOfCycle;
    }

    public void setAmountOfCycles(int NumberOfCycle) {
        this.numberOfCycle = NumberOfCycle;
    }

    public Vertex getStartVertex() {
        return StartVertex;
    }

    public void setStartVertex(Vertex StartVertex) {
        this.StartVertex = StartVertex;
    }

    public Vertex getEndVertex() {
        return EndVertex;
    }

    public void setEndVertex(Vertex EndVertex) {
        this.EndVertex = EndVertex;
    }

    public LinkedSimpleList getBestRouteArcs() {
        return bestRouteArcs;
    }

    public void setBestRouteArcs(LinkedSimpleList bestRouteArcs) {
        this.bestRouteArcs = bestRouteArcs;
    }

    public double getBestDistance() {
        return bestDistance;
    }

    public void setBestDistance(double bestDistance) {
        this.bestDistance = bestDistance;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    public double getAmountOfPheromones() {
        return AmountOfPheromones;
    }

    public void setAmountOfPheromones(double AmountOfPheromones) {
        this.AmountOfPheromones = AmountOfPheromones;
    }
}
