import java.net.*;
import java.io.*;

public class Client
{
    int counter = 0;

    public Client()
    {
        do {
            try {

                Socket s = new Socket("127.0.0.1", 5155);

                InputStream in = s.getInputStream();
                
                DataInputStream dataInput = new DataInputStream(in); 

                //BufferedReader bin = new BufferedReader(new InputStreamReader(in));

                //System.out.println(bin.readLine());

                System.out.println(dataInput.readDouble());
                
                counter++;
                
                System.out.println("Counter: " + counter);
                
                s.close();
                
                Thread.sleep(500);

            }

            catch (java.io.IOException e) {
                System.out.println(e);
                System.exit(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (true);

    }

    public static void main(String args[])
    {
        Client client = new Client();
    }

}
