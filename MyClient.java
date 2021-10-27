//Imports
import java.io.*;  
import java.net.*; 
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage: MyClient <server>");
			System.exit(0);
		}
		String server = args[0];

		System.out.println( "[Connecting to server: " + server+"]");

        	try
		{
			//Connect to server
			Socket s = new Socket(server,7251);

			//Create input and output streams
			PrintStream out = new PrintStream(s.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//Send message
			Scanner scan = new Scanner(System.in);
			String message = new String();
			boolean running = true;
			while(running)
			{
				message = scan.nextLine();
				System.out.println();

				if("$Q".equals(message))
				{
					System.out.println("[Quitting...]");
					out.println(message);
					running = false;
				} else {
					out.println(message);
					out.println();
				}
			}

			//Close streams & sockets
			in.close();
			out.close();  
			s.close();  
        	} catch(Exception e){System.out.println("\nException: "+e);}
	}

}
