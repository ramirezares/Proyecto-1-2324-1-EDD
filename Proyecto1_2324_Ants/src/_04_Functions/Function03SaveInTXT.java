package _04_Functions;

import _02_EDD.UndirectedGraph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author AresR
 */
public class Function03SaveInTXT {  //Convertir el grafo a txt 

    public void txtToSave(UndirectedGraph GraphOfProgram) {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            FileWriter fileWriter = null;
            try {
                File selectedFile = fileChooser.getSelectedFile();
                fileWriter = new FileWriter(selectedFile);
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    String graphString = GraphOfProgram.ShowGraphSummary();
                    bufferedWriter.write(graphString);
                }
                JOptionPane.showMessageDialog(null, "Guardado exitoso. Puede salir del programa.");
            } catch (IOException ex) {
                Logger.getLogger(Function03SaveInTXT.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Function03SaveInTXT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun archivo.");
        }
    }
}
