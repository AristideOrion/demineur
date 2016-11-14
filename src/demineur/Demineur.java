/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

/**
 *
 * @author aristide
 */
public class Demineur {

    /**
     * @param args the command line arguments
     */
    public Demineur()
    {
        //Création du modèle
                Grille testgrille= new Grille(4,3);
                testgrille.genererGrill();
        //Création du controlleur
        ControlDemineur ctrlDemineur= new ControlDemineur(testgrille);
        //Création de la vue
        VueDemineur vuDemineur=new VueDemineur(ctrlDemineur);
        //Ajout de l'observateur à la vue
        testgrille.addObservateur(vuDemineur);

    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Demineur dem= new Demineur();
        
        
    }
    
}
