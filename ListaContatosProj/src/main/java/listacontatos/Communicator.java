package listacontatos;

import java.util.Stack;


public class Communicator {
   
    public Stack<Object> stack;
    private static Communicator comInstance;
    
    private Communicator() {
        stack = new Stack();
    }
    
    public static Communicator getInstance() {
        if(comInstance == null)
            comInstance = new Communicator();
        
        return comInstance;
    }
}
