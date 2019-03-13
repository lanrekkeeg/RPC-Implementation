import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client_stub implements Runnable {

	String function_name;
	int num1, num2;
	Socket client;
	Result res;
	public client_stub(String str, int num1, int num2, Socket cli, Result res) {
		this.function_name = str;
		this.num1 = num1;
		this.num2 = num2;
		this.client = cli;
		this.res = res;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// need to call the 
		//Patter of the string will be the following
			/*
			* function name 
			* int variable
			* follow by the \IC then antother int variable .... (just implemented)
			* at the end \I mean end of the int variable .....(just implmented)
			* float variable
			* follow buy the \FC then another float variable ....(not implemented)
			* at the end \F mean end of the float variable ....(not implemented)
			* string message and each message end with \0 ....(not implemented)
			* at the end of each string \SC ...(not implemented)
			* at the end \S mean end of string variables ....(not implemented)
			* 
			* */
				
			String Data = "";
		//	DataInputStream is;  // didn't use as need bytes to write
			DataOutputStream os; 
			BufferedReader in = null;   // use it as just need to write string
			PrintWriter out = null;  // same as above ^
			String ret_function_name = "";
			int result = 0;
			String Dummy = "";
				
		//Marshmalling of Data
			Data +=  function_name + Integer.toString(num1)+ "IC" + Integer.toString(num2)+ "IE";
			
			try {
				
				in  = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(),true);
				out.println(Data);
				Data = in.readLine();
				
				
				int i = 0;
				// unmarshmalling
				for(; i < Data.length(); i++) {
					ret_function_name += Data.charAt(i);
					if(Data.charAt(i) == ')') {
						i++;
						break;
					}
				}
				
				for(; i < Data.length(); i++) {
					
					if(Data.charAt(i) == 'R') {
						result = Integer.parseInt(Dummy);
						break;
					}
					
					Dummy += Data.charAt(i);
				}
				
				res.set_result(ret_function_name, result);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
