/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _01_proyecto1_2324_ants;
import _02_EDD.SimpleNode;

/**
 *
 * @author AresR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 8,b=10;
        SimpleNode pNode = new SimpleNode();
        pNode.SimpleNode(a);
        
        SimpleNode pNode2 = new SimpleNode();
        pNode2.SimpleNode(a, pNode);
        
        pNode2.SetData(b);
        System.out.println(pNode2.GetData());
    }
    
}
