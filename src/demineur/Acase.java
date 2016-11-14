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
abstract class  Acase {
    //Vérifie le statut
    private Boolean devoiler=false;
    //Vérifie si il y a un objet sur la casse
    private Etat etat =Etat.RIEN;
    //Vérifie le type de case
    private Type type;
    
    /*
        Découvrir le contenu de la case
    */
    abstract void freeCase();
   

    /**
     * @return the devoiler
     */
    public Boolean getDevoiler() {
        return devoiler;
    }

    /**
     * @param devoiler the devoiler to set
     */
    public void setDevoiler(Boolean devoiler) {
        this.devoiler = devoiler;
    }

    /**
     * @return the etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
    
}
