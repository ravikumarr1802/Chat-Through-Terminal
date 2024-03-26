import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Client()
    {
        try{
            
        System.out.println("Sending request to server");
        socket = new Socket("127.0.0.1",7788);
        System.out.println("Connection established");

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void startReading(){

        Runnable t1 = () ->{
            System.out.println("READER");
            try{
            while (true) {
              
                String msg = br.readLine();
                if(msg.equals("exit"))
                {
                    System.out.println("Server EXITED");
                    socket.close();
                    break;
                }
                System.out.println("Server : " + msg);
            }
        }
            catch(Exception e)
            {
                System.out.println("CLOSED");
            }
        };          
        
        new Thread(t1).start();
    }
    private void startWriting(){

        Runnable t2 = () ->{
            System.out.println("WRITER");
            try{

            while (!socket.isClosed()) {
                
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String content = br2.readLine();
                out.println(content);
                out.flush();
                if(content.equals("exit"))
                {
                    socket.close();
                    break;
                }
            }
        }
            catch(Exception e)
            {
                System.out.println("CLOSED");
            }
        };
        
        new Thread(t2).start();
    }
    public static void main(String args[])
    {
        System.out.println("CLIENT");
        new Client();
    }
}
