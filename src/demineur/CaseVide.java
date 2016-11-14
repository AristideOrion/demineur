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
public class CaseVide extends Acase{
    //Liste des cases voisines
    List<Acase> voisins=new ArrayList<>();
   public CaseVide()
   {
       
   }
   public CaseVide(List<Acase> vois)
   {
       
       for(Acase v:vois)
       {
           voisins.add(v);
       }
       super.setType(Type.VIDE);
       
   }
   //Libere les cases autour
   void freeCaseNeigbhour()
   {
      
       for(Acase v:voisins)
       {
           if(v!=null){
               v.freeCase();
           System.out.println("liberez3");
           }
           
       }
   }

    @Override
    void freeCase() 
    {
        this.setDevoiler(Boolean.TRUE);
    }
}
