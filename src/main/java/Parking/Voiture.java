/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parking;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class Voiture implements Runnable{
String nom;
Parking park; 
DefaultListModel model;  
long time ; 
JLabel place ; 
//    int i=0 ;
//    int j=1 ;
//    int k=1;
//int secondes , minutes , heures , delay=1000 ; 
public Voiture(String name, Parking park ,DefaultListModel model, JLabel place, long time ){
this.nom=name;
this.park=park;
this.model = model ; 
this.place = place ;
this.time = time ;
}
//ActionListener taskPerformer =new ActionListener(){
//    public void actionPerformed(ActionEvent evt){
//        secondes = i ;
//         System.out.println(secondes ); 
//        i++;
//            }};
//   Timer timer = new Timer(delay,taskPerformer);
private static final long referenceTime = System.currentTimeMillis();
private String getAccesVoitureDesc() {
        return "[" + (System.currentTimeMillis() - referenceTime) + "] (Proc : " + Thread.currentThread().getName() + ")";
   }


@Override
public void run(){
System.out.format("[%s]: Je débute ! \n", this.nom);
 try {
Thread.sleep((long) (3000*Math.random())); 
System.out.format("[%s]: Je demande à rentrer \n", this.nom);
System.out.println(this.getAccesVoitureDesc());
this.rentrer();
System.out.format("[%s]: Je viens d'entrer \n", this.nom);
System.out.println(this.getAccesVoitureDesc());
model.addElement(this);
place.setText(String.valueOf(this.park.places()));
Thread.sleep((long) (time*Math.random()));
System.out.format("[%s]: Je demande à sortir \n", this.nom);
System.out.println(this.getAccesVoitureDesc());
Thread.sleep((long) (3000*Math.random()));
this.park.leave(this);
model.removeElement(this);
place.setText(String.valueOf(this.park.places()));
}  catch (InterruptedException ex) {
        Logger.getLogger(Voiture.class.getName()).log(Level.SEVERE, null, ex);
    }
}
private void rentrer() throws InterruptedException{
while (!(this.park.accept(this)))
{
Thread.sleep((long) (1000* Math.random()));
System.out.format("[%s] : Je redemande à rentrer \n", this.nom);
}
}
  @Override
    public String toString(){
        return " La voiture " + nom + " est garde son palce dans le parking " ; 
    }
}

    


    

