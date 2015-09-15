import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
 
public class Client
{
 
    private Socket socket;
 
    public void connect(String host, int port)
    {
        try
        {
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
    
    public void send(String msg){
    	 //Send the message to the server
        OutputStream os;
		
        try {
			os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
	        BufferedWriter bw = new BufferedWriter(osw);

	        String sendMessage = msg + "\n";
	        bw.write(sendMessage);
	        bw.flush();
	        System.out.println("Message sent to the server : "+sendMessage);

	        //Get the return message from the server
	        InputStream is = socket.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String message = br.readLine();
	        System.out.println("Message received from the server : " +message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}