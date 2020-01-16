import java.net.*;
import java.io.*;

public class Connection extends Thread
{
    
    Thread t;

    private Socket outputLine;

    public Connection(Socket s)
    {
        outputLine = s;
        
    }

    public void run()
    {
       t = new Thread();

        // getOutputStream returns an OutputStream object	
        // allowing ordinary file IO over the socket.

        // create a new PrintWriter with auto flushing
        try {
            // create a new PrintWriter with auto flushing
            //PrintWriter pout = new PrintWriter(outputLine.getOutputStream(), true);
            DataOutputStream poutdata = new DataOutputStream(outputLine.getOutputStream());

            // now send a message to the client			
            //pout.println(" The Date and Time is " + new java.util.Date().toString());
            
            poutdata.writeDouble(0.1);
            
            System.out.println(t.getName());

            // now close the socket				
            outputLine.close();
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}
