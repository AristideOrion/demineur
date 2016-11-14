/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aristide
 */

public class Grille {
    /*
    Taille de la grille
    */
   Integer taille;
   /*
   Tableau des cases du jeu
   */
   public Acase[][] tableau;
   /*
   Nombre de mine
   */
   int nmbreMine;
   /*
   Stocke la position des mines
   */
  
   Integer[] posMineX;
   Integer[] posMineY;
   /*Liste des observeurs
   */
   List<Iobservateur> observgrill=new ArrayList<Iobservateur>() {};

    public Grille(Integer vtaille, int nbremine)
    {
        this.taille=vtaille;
        this.nmbreMine=nbremine;
        
    }
    /**
     *Genere la grille du jeu
     */
    public void genererGrill()
   {
       tableau=new Acase[taille][taille];
       insertionAleaMine(nmbreMine);
       insertionCaseVideChiffre();
       //afficheGrill();
   }
    /*
        Informe la vu des changements
    */

    /*
        Insere un nombre aléatoire de mine
    */
    public void insertionAleaMine(int nbremine)
    {
        //Variable de position des mines
        int aleaX;
        int aleaY;
        //Initialitaion des tableaux de positions
        posMineX=new Integer[nbremine];
        posMineY=new Integer[nbremine];
        
        for(int i=0;i<nbremine;i++)
        {
            aleaX=(int)( Math.random()*nbremine);
            aleaY=(int)( Math.random()*nbremine);
            if(tableau[aleaX][aleaY]==null)
            {
                tableau[aleaX][aleaY]=new CaseMine();
                  //Enregistre la position des mines
                 posMineX[i]=aleaX;
                 posMineY[i]=aleaY;
            }
            
          
           
        }
        
    }
    //Insertion des cases vides
    public void insertionCaseVideChiffre()
    {
        List<Acase> listTemporaire=new ArrayList<>();
        int compteurTemporaire=0;
        //Inserer les autres cases
        for(int i=0;i<tableau.length;i++)
        {
            for(int j=0;j<tableau.length;j++)
            {
               
                if(tableau[i][j]==null || tableau[i][j].getType()!=Type.MINE)
                {
                    for(int k=-1;k<2;k++)
                    {
                        for(int p=-1;p<2;p++)
                        {
                            if((i+k)>=0 && (i+k)<tableau.length )
                            {
                                if((j+p)>=0 &&(j+p)<tableau.length)
                                {
                                    if(k!=0 || p!=0)
                                    {
                                        listTemporaire.add(tableau[(i+k)][(j+p)]);
                                        if(tableau[(i+k)][(j+p)]!=null)
                                        {
                                            if(tableau[(i+k)][(j+p)].getType()==Type.MINE)
                                            {
                                                compteurTemporaire++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(compteurTemporaire>0)
                    {
                        tableau[i][j]=new CaseChiffre(listTemporaire,compteurTemporaire);
                        
                        
                    }
                    else
                    {
                        tableau[i][j]=new CaseVide(listTemporaire);
                    }
                    listTemporaire.clear();
                    compteurTemporaire=0;
                }
                
            }
        }
        
    }
       //Affiche ma grille en interne     
    private void afficheGrill()
       {
           //Affichage du tableau
           for (int i=0; i<tableau.length;i++) 
       {
           for (int j = 0; j<tableau.length; j++) 
           {
               System.out.print(tableau[i][j]);
           }
           System.out.println();
       }
           
       }
   //Ajouter un observateur
    public void addObservateur(Iobservateur obs){
        observgrill.add(obs);
    }
    //Notifier l'observateur
    public void notifyObservers(){
        for(Iobservateur obs : observgrill){
            obs.update(this);
        }
    }
}
