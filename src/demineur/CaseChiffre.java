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
public class CaseChiffre extends Acase{
    //Liste des cases voisines
    List<Acase> voisins=new ArrayList<>();
    //Nombre de mine
    int chiffreMine;
    public CaseChiffre()
    {
        
    }
    public CaseChiffre(List<Acase> vois,int nmbremine)
    {
        voisins=vois;
        chiffreMine=nmbremine;
        super.setType(Type.CHIFFRE);
    }
    //Informe sur le nombre de mine autour
    public int mineAround()
    {
        return chiffreMine;
    }

    @Override
    void freeCase() 
    {
        this.setDevoiler(Boolean.TRUE);
        
    }
}
