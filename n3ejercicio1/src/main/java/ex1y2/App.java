package ex1y2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class App {

    public static void main(String[]args){
        ArrayList<Month> Mesos=new ArrayList<>();
        Month gener =new Month("gener");
        Mesos.add(gener);
        Month febrer =new Month("febrer");
        Mesos.add(febrer);
        Month març =new Month("març");
        Mesos.add(març);
        Month abril =new Month("abril");
        Mesos.add(abril);
        Month maig =new Month("maig");
        Mesos.add(maig);
        Month juny =new Month("juny");
        Mesos.add(juny);
        Month juliol =new Month("juliol");
        Mesos.add(juliol);
        Month setembre =new Month("setembre");
        Mesos.add(setembre);
        Month octubre =new Month("octubre");
        Mesos.add(octubre);
        Month novembre =new Month("novembre");
        Mesos.add(novembre);
        Month desembre =new Month("desembre");
        Mesos.add(desembre);

        Month agost =new Month("agost");

        //Efectua la inserció en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte.
        Mesos.add(7,agost);
        System.out.println(Mesos);
       
        // Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.
        Set<Month> MesosSet = new HashSet<>();
        for (Month mes : Mesos) {
            MesosSet.add(mes);}
        MesosSet.add(agost);
        System.out.println(MesosSet);
        //Recorre la llista amb un for i amb un iterador.

        //For
        for (Month mes:MesosSet){
            System.out.println(mes);
        }

        //Iterador
        Iterator<Month> iterador = MesosSet.iterator();

        while (iterador.hasNext()) {
            System.out.print(iterador.next() + " ");
        }

}}
