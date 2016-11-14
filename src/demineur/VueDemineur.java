/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demineur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author aristide
 */
public class VueDemineur  extends JFrame implements Iobservateur{
    
    JTextField taille= new JTextField("Grille");
    //Instance du controlleur
    ControlDemineur instanceCtl;
    //Tableau de boutton
     JButton[][] tbt; 
     public VueDemineur()
    {
        
    }
    public VueDemineur(ControlDemineur ctl)
    {
       
        instanceCtl=ctl;
        this.setTitle("Démineur");
        this.setSize(400,100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        genereVue();
        this.setVisible(true);
        
    }
    public void genereVue()
    {
        //Le root
        JPanel root = new JPanel();
        BorderLayout bordlat= new BorderLayout();
        root.setLayout(bordlat);
        //Le menu
        JPanel menu= new JPanel();
        menu.setBackground(Color.red);
        GridLayout sousmenu = new GridLayout(1,4);
        menu.setLayout(sousmenu);
        JButton nouvPartie = new JButton("Nouvelle partie");
        //Ajoute l'élément qui écoute le bouton
        nouvPartie.addActionListener(new Boutonlistener());
        //Ajoute le nom de l'élément écouté
        nouvPartie.setActionCommand("new game");
        taille.addActionListener(new Boutonlistener());
        JLabel score = new JLabel("Score");
        JButton quit= new JButton("Quitter");
        menu.add(nouvPartie);
        menu.add(taille);
        menu.add(score);
        menu.add(quit);
        root.add(menu,"North");
        //Creation du visuel de la grille
        
        tbt=new JButton[4][4];
        JPanel zoneDeJeu= new JPanel(new GridLayout(4,4));
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                JButton bt= new JButton();
                bt.addActionListener(new Boutonlistener());
                bt.setActionCommand("case:"+i+","+j);
                //AJout des boutons au tableau de bouton
                tbt[i][j]=bt;
                zoneDeJeu.add(bt);
            }
        }
        root.add(zoneDeJeu,"Center");
        this.setContentPane(root);
        
    }
    
    @Override
    public void update(Grille g)
    {
        for(int i=0;i<g.taille;i++)
        {
            for(int j=0;j<g.taille;j++)
            {
                Acase ca= g.tableau[i][j];
                if(ca.getDevoiler())
                {
                    switch(ca.getType())
                    {
                        case VIDE:
                            tbt[i][j].setText("V");
                            break;
                        case MINE:
                         //Recupère les positions des mines  
                        Integer[] x=instanceCtl.instanceGrille.posMineX;
                        Integer[] y=instanceCtl.instanceGrille.posMineY;
                        //Affiche toutes les mines
                      for(int k=0;k<g.nmbreMine;k++)
                      {
                          tbt[x[k]][y[k]].setText("M");
                      }
                          
                            break;
                        case CHIFFRE:
                            CaseChiffre c = (CaseChiffre)ca;
                            tbt[i][j].setText(String.valueOf(c.mineAround()));
                            break;
                            
                    }
                }
            }
        }
    }
    public class Boutonlistener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("ok");
            String event=e.getActionCommand();
            String[] valeurEvent=event.split(":");
            String[] valeurPos=valeurEvent[1].split(",");
            int x=Integer.parseInt(valeurPos[0]);
            int y=Integer.parseInt(valeurPos[1]);
            
            switch (valeurEvent[0])
            {
                case "new game":
                    System.out.println("test1");
                    break;
                case "case":
                    instanceCtl.clickGauche(valeurEvent[1]);
                    System.out.println(tbt[x][y].getText());
                    
                    break;
            }
        }
        
    }
    
}

