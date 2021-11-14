import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class MachineCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MachineCollection
{
    // instance variables 
    private ArrayList<TicketMachine> ticketMachine;

    /**
     * Constructor for objects of class MachineCollection
     */
    public MachineCollection()
    {
        ticketMachine = new ArrayList<TicketMachine>();
    }

    /**
     *stores the given machine to the collection.     
     */
    public void add(TicketMachine tm) 
    {
        ticketMachine.add(tm);    
        //System.out.println(ticketMachine);
    }

    public int numberOfMachines(){
        return ticketMachine.size();
    }

    public int collectMoney(){
        int total = 0;
        for(TicketMachine machine: ticketMachine){
            total += machine.getTotal();
            machine.resetTotal();
        }
        return total;
    }

    public int clearMachine(int minimumPrice){
        Iterator<TicketMachine> it = ticketMachine.iterator();
        int machineRemoved=0;
        while(it.hasNext()){
            TicketMachine i = it.next();
            if(i.getPrice() < minimumPrice){
                it.remove();
                machineRemoved ++;
            }
        }
        return machineRemoved;
    }
}