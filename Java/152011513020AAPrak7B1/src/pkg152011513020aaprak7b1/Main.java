/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg152011513020aaprak7b1;

/**
 *
 * @author Agiftsany Azhar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Dist Kontinu");
        DistKontinu dk = new DistKontinu();
        Vektor mv = new Vektor();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(dk.unifKontinu(-5, 10));
        }        
        
    }
    
}
