/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _02_EDD;

/**
 *
 * @author AresR
 */
public class Vertex implements IVertex {
    
    String name;
    int numVertex;
    LinkedSimpleList listAdy;

    /**
     *
     * @param name
     */
    @Override
    public void Vertex(String name) {
        this.name=name;
        this.numVertex=-1;
        this.listAdy= new LinkedSimpleList();
        
    }

    @Override
    public String GetVertexName() {
        return this.name;
    }

    @Override
    public boolean IsEquals(Vertex n) {
        return java.util.Objects.equals(this.name, n.name);
    }

    @Override
    public void SetVertNumber(int n) {
        this.numVertex=n;
    }

    @Override
    public String ConvertToStringForPrint() {
        return "Nombre:"+this.name+" num. "+this.numVertex;
    }
    
}
