/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import demineur.VueDemineur.Boutonlistener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aristide
 */
public class ControlDemineur {
    //Instance du controlleur
    Grille instanceGrille;
    public ControlDemineur(Grille grilleJeu)
    {
        instanceGrille=grilleJeu;
    }
    /*public JPanel nouvelPartie(int grille)
    {
        JPanel zoneDeJeu= new JPanel(new GridLayout(grille,grille));
        for(int i=0;i<grille;i++)
        {
            for(int j=0;j<grille;j++)
            {
                JButton bt= new JButton();
                //bt.addActionListener(Boutonlistener);
                
                zoneDeJeu.add(bt);
            }
        }
        return zoneDeJeu;
    }*/
    public void clickGauche(String cordonne)
    {
        String [] cordonneBt=cordonne.split(",");
        int x=Integer.parseInt(cordonneBt[0]);
        int y=Integer.parseInt(cordonneBt[1]);
        
        Acase c = instanceGrille.tableau[x][y];
        if(!c.getDevoiler())
        {      
            c.freeCase();
            System.out.println(c.getType());
            if(c.getType()==Type.VIDE)
            {
                
                CaseVide ca= (CaseVide)c;
                ca.freeCaseNeigbhour();
            }
            /*switch(c.getType())
            {
                case VIDE:
                    break;
                case MINE:
                    break;
                case CHIFFRE:
                    break;
                    
            }*/
            
            instanceGrille.notifyObservers();
        }
    }
    
}
