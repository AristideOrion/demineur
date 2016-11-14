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
public class CaseMine extends Acase {
    
    public CaseMine()
    {
        super.setType(Type.MINE);
       
    }

    @Override
    void freeCase() 
    {
        this.setDevoiler(Boolean.TRUE);
    }
   
}
