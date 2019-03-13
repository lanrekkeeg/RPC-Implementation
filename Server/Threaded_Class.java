import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Threaded_Class implements Runnable {
	protected Socket client;
	public Threaded_Class(Socket s) {
		this.client = s;
	}
	
	public void run() {
		
		try {
			
			BufferedReader in;
			InputStreamReader is = new InputStreamReader(client.getInputStream());
			in = new BufferedReader(is);
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			// Now Parser
			String data = in.readLine();
			server_stub(out, data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void server_stub(PrintWriter out, String in_data) {
		
		int num1 = 0,num2 = 0, sum = 0;
		List<Integer> param = new ArrayList<Integer>();
		String function_name = "";
		String integer_str = "";
		int result = 0;
		String out_data = "";
		int i = 0;
		
		//UNMARSHMALLING
		
		// for string 
		System.out.println("Data recieved by server stub" +in_data);
		for(; i < in_data.length(); i++) {
			
			function_name += in_data.charAt(i);
			if(in_data.charAt(i) == ')') {
				i++;
				break;
			}
		}
		
		// for integers
		for(; i < in_data.length(); i++) { 
			
			if(in_data.charAt(i) == 'I') {
				if(in_data.charAt(i+1) == 'C' || in_data.charAt(i+1) == 'E') {
					int integer_int = Integer.parseInt(integer_str);
					param.add(integer_int);
					integer_str = "";
					
					if(in_data.charAt(i+1) == 'E')
						break;
					i++;	
				}	
			}
			else
				integer_str += in_data.charAt(i);
					
		}
				
		
		System.out.println("RequesT For:"+function_name);
		if(function_name.equals("Add()")) {
			result = helper.add(param);
		}
		else if(function_name.equals("sub()")) {
			result = helper.sub(param);
		}
		else if(function_name.equals("Mull()")) {
			result = helper.mul(param);
		}
		else if(function_name.equals("div()")) {
	    	result = helper.div(param);
		}
			
		// MarshMalling
		
		/* Function name
		 * answer
		 */
		out_data += function_name + Integer.toString(result) + "R";
		out.println(out_data);
		out.flush();
		System.out.println(function_name+"::res == "+result+" is send to client Stub");
	}
}