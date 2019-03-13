import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

class Result{
	int result;
	String assign_funct;
	
	Result(){
		result = 0;
		assign_funct = "";
	}
	
	void set_result(String func_name, int result) {
		
		this.result = result;
		this.assign_funct = func_name;
		
	}
	
	void print_result() {
		System.out.println("Result for "+ assign_funct + " is "+ result );
	}
}

public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cli1 = null, cli2 = null, cli3 = null, cli4 = null;
		Result res1 = new Result();
		Result res2 = new Result();
		Result res3 = new Result();
		Result res4 = new Result();
		
		cli1 = new Socket("127.0.0.1", 49159);
		cli2 = new Socket("127.0.0.1", 49159);
		cli3 = new Socket("127.0.0.1", 49159);
		cli4 = new Socket("127.0.0.1", 49159);
		
		boolean cl1_check = true;
		boolean cl2_check = true;
		boolean cl3_check = true;
		boolean cl4_check = true;
		
		DataInputStream is = null;
		BufferedReader in = null;
		client_stub s1 = new client_stub("Add()", 4, 2, cli1, res1);
		Thread c1 = new Thread(s1);
		c1.start();

		client_stub s2 = new client_stub("mul()", 4, 2, cli2, res2);
		Thread c2 = new Thread(s2);
		c2.start();
		
		client_stub s3 = new client_stub("sub()", 4, 2, cli3, res3);
		Thread c3 = new Thread(s3);
		c3.start();
		
		client_stub s4 = new client_stub("Div()", 4, 2, cli4, res4);
		Thread c4 = new Thread(s4);
		c4.start();
		
		while (true) {	
			
			if (!c1.isAlive() && cl1_check) {
				// sense the data 
			
				res1.print_result();
				cl1_check = false;
			}
			if (!c2.isAlive() && cl2_check) {
				
				res2.print_result();
				cl2_check = false;
			}
			if (!c3.isAlive() && cl3_check) {
				
				res3.print_result();
				cl3_check = false;
			}
			if (!c4.isAlive() && cl4_check) {
			
				res4.print_result();
				cl4_check = false;
			}
			
			if(!cl1_check && !cl2_check && !cl3_check && !cl4_check) {
				System.out.println("Processing is finish now exiting....");
				break;
			}
		}
	}
}
