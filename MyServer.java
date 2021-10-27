import java.io.*;  
import java.net.*;  

public class MyServer extends Thread
{
	public static void main(String[] args)
	{
		public int[] clients;
		
        	try
		{
			//Start server
           		ServerSocket ss = new ServerSocket(7251);
			
			boolean listening = true;
			for(int i=0;i<2;i++)
			{
            			Socket cs = ss.accept();
				clients[i] = cs;
				
				System.out.println("[Client connected]");
		        
				MyServer thread = new MyServer();
				thread.start();
			}

			//Close server socket
			ss.close();
		} catch(Exception e){System.out.println(e);}
	}

	public void run()
	{
		handleConnection(cs);
	}

	public static void handleConnection(Socket cs)
	{
		try
		{
			//Create IO streams
			BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));			

			//Read message
			String line = in.readLine();
			boolean running = true;
			while((line != null)&&(running))
			{	
				if(line.equals("$Q"))
				{
					System.out.println("[Client quit]");
					running = false;
				} else {
					System.out.println(line);
					line = in.readLine();		
				}
			}

			//Close streams
			in.close();

		}catch(Exception e){System.out.println(e);}
	}	
}
