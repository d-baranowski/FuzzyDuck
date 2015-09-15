import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server implements Runnable
{
    private static Socket socket;
     
    @Override
	public void run() {
		try
        {
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port " + port);
 
            //Server is running always. This is done using this while(true) loop

                //Reading the message from the client
                socket = serverSocket.accept();
                
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String msg = br.readLine();
                System.out.println("Message received from client is "+msg);
                reply("Server reply is " + msg);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
	}
    
    public void reply(String msg){
        String returnMessage = msg;
       
        //Sending the response back to the client.
        OutputStream os;
		try {
			os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
	        bw.write(returnMessage);
	        System.out.println("Message sent to the client is "+returnMessage);
	        bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}