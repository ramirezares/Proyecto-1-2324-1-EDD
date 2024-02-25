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

    UndirectedGraph GraphOfSimulation;
    LinkedSimpleList listOfAnts;
    int alfaValue, betaValue;
    double rhoValue;
    int numberOfCycle;
    Vertex StartVertex, EndVertex;
    LinkedSimpleList bestRouteArcs;
    double bestDistance, totalDistanceTraveled;
    double AmountOfPheromones;

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

    // Función para que la hormiga recorra el hormiguero completo
    public String completeAntRoute(Ant ant) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < this.GraphOfSimulation.getListofVertex().GetSize(); i++) {
            if (ant.getCurrentVertex().GetNumVertex() != this.EndVertex.GetNumVertex()) {
                LinkedSimpleList candidateVertexs = getCandidateArcsToVertexs(ant);
                if (!candidateVertexs.isEmpty()) {
                    LinkedSimpleList probability = probabilityList(candidateVertexs);
                    UndirectedGraphArc arc = chooseNextVertex(probability, candidateVertexs);
                    Vertex vertexToMove = this.GraphOfSimulation.SearchVertexInGraphWithNum(arc.GetDestination());
                    this.move(ant, vertexToMove, arc.GetWeight());
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

    // lista obtener ciudades candidatas recibe hormiga
    // Función para obtener una lista con ciudades que son candidatas para que la hormiga se mueva
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

    // probabilidades recibe las ciudades candidatas
    // Función de probabilidades
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

    // Función que resetea las hormigas de la lista de hormigas
    public void restartAnts() {
        for (int i = 0; i < this.listOfAnts.GetSize(); i++) {
            Ant antReset = (Ant) this.listOfAnts.GetValInIndex(i).GetData();
            
            antReset.setCurrentVertex(this.StartVertex);
            antReset.setVertexsTraveled(new LinkedSimpleList());
            antReset.setTotalDistanceTraveled(0.0);
            this.listOfAnts.SetValInIndex(i, antReset);
        }
    }

    //incrementar feromona 
    // Función de incrementación de feromonas en el camino
    public void increasePheromones(Ant ant) {
        double RoadVisibilityFactor = (1.0 / ant.getTotalDistanceTraveled());
        for (int i = 0; i < ant.getVertexsTraveled().GetSize()-1; i++) {
            Vertex auxVertex = (Vertex) ant.getVertexsTraveled().GetValInIndex(i).GetData();
            Vertex nextAuxVertex = (Vertex) ant.getVertexsTraveled().GetValInIndex(i+1).GetData();

            double totalPheromones = RoadVisibilityFactor + auxVertex.SearchArcwithNumOfVertexs(nextAuxVertex.GetNumVertex()).getPheromones();

            auxVertex.SearchArcwithNumOfVertexs(nextAuxVertex.GetNumVertex()).setPheromones(totalPheromones);
        }
    }

    //evaporar feromonas
// Función de evaporación de feromonas
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
