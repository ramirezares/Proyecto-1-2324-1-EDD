/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _05_Validations;

/**
 *
 * @author CarlosL010 & AresR
 */
public class Validations {

    /**
     * Valida si un string esta vacio.
     *
     * @param sample_variable texto a validar
     * @return true si el string esta vacio, false en caso contrario.
     */
    public boolean StringIsEmpty(String sample_variable) {
        return sample_variable.isEmpty();
    }

    /**
     * Valida si un texto ingresado por el usuario es un numero y no una letra
     *
     * @param sample_variable texto a validar
     * @return true si el string es un numero, false en caso contrario.
     */
    public boolean InputIsNumeric(String sample_variable) {
        boolean val = false;
        if (!this.StringIsEmpty(sample_variable)) {
            for (char c : sample_variable.toCharArray()) {
                if (!Character.isDigit(c)) {
                    val = true;
                    break;
                }
            }
        }

        return val;
    }

    //
    /**
     * Valida si el texto ingresado es un numero y, de ser asi, si numero
     * introducido esta en el rango formado por dos numeros indicados. Los
     * extremos tambien se incluyen en el intervalo.
     *
     * @param sample_variable texto a validar
     * @param max extremo superior del intervalo
     * @param min extremo inferior del intervalo
     * @return true si el string es un numero y esta en el rango indicado, false
     * en caso contrario.
     */
    public boolean InputInRange(String sample_variable, int max, int min) {
        boolean val = false;
        if (!this.StringIsEmpty(sample_variable)) {
            try {
                int number = Integer.parseInt(sample_variable);
                return number >= min && number <= max;
            } catch (NumberFormatException e) {
                return val;
            }
        }
        return val;
    }

    /**
     * Valida si el texto indicado es un numero convertible a double, que
     * representa la distancia.
     *
     * @param sample_variable  texto a validar
     * @return true si el string es un numero y representa una distancia, false
     * en caso contrario.
     */
    public boolean isDistance(String sample_variable) {
        boolean val = false;
        if (!this.StringIsEmpty(sample_variable)) {
            try {
                double distance = Double.parseDouble(sample_variable);
                if (distance>0) {
                    val = true;
                    return val;
                }
                return val;
            } catch (NumberFormatException e) {
                return val;
            }
        }
        return val;
    }

    /**
     * Valida si los textos indicados son numeros y son distintos, para formar un arco.
     * 
     * @param numOfOrigin texto a validar que representa el numero del vertice origen
     * @param numOfDestination texto a validar que representa el numero del vertice destino
     * @return true si los string son un numero y son distintos, false
     * en caso contrario.
     */
    public boolean numsNotEquals(String numOfOrigin, String numOfDestination) {
        boolean val = false;
        if (!this.StringIsEmpty(numOfOrigin) && !this.StringIsEmpty(numOfDestination)) {
            try {
                int numOrigin = Integer.parseInt(numOfOrigin);
                int numDestinarion = Integer.parseInt(numOfDestination);
                if (numOrigin != numDestinarion) {
                    val = true;
                    return val;
                }
            } catch (NumberFormatException e) {
                return val;
            }
        }
        return val;
    }
    
    /**
     * Valida si el texto indicado es un numero y corresponde a Rho, es decir,
     * se encuentre en el intervalo [0,1).
     * 
     * @param sample_variable texto a validar que representa Rho "p"
     * @return true si el string es un numero y esta en el rango [0,1), false
     * en caso contrario.
     */
    public boolean RhoInRange(String sample_variable) {
        boolean val = false;
        int minimo0 = 0;
        int maximo1 = 1;
        if (!this.StringIsEmpty(sample_variable)) {
            try {
                double number = Double.parseDouble(sample_variable);
                return number >= minimo0 && number < maximo1;
            } catch (NumberFormatException e) {
                return val;
            }
        }
        return val;
    }

    
    /**
     * Valida si el texto indicado es un numero y corresponde al numero de ciclos,
     * es decir, un entero positivo.
     * 
     * @param sample_variable texto a validar
     * @return true si el string es un numero entero positivo, false
     * en caso contrario.
     */
    public boolean isNumOfCycles(String sample_variable) {
        boolean val = false;
        if (!this.StringIsEmpty(sample_variable)) {
            try {
                int number = Integer.parseInt(sample_variable);
                return number > 0;
            } catch (NumberFormatException e) {
                return val;
            }
        }

        return val;
    }
    
    /**
     * Valida si el texto indicado es un numero y corresponde al numero de hormigas,
     * es decir, un entero positivo.
     * 
     * @param sample_variable texto a validar
     * @return true si el string es un numero entero positivo, false
     * en caso contrario.
     */
    public boolean isNumOfAnts(String sample_variable) {
        boolean val = false;
        if (!this.StringIsEmpty(sample_variable)) {
            try {
                int number = Integer.parseInt(sample_variable);
                return number > 0;
            } catch (NumberFormatException e) {
                return val;
            }
        }
        return val;
    }
}
