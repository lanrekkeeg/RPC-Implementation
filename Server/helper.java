import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.IntBuffer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class helper {

	
	public static int add( List<Integer>param) {
		
		int res = param.get(0) + param.get(1);
		return res;
    }
	public static int sub(List<Integer>param) {
		int res = param.get(0) - param.get(1);
		return res;
	 }
	public static int mul(List<Integer>param) {
		int res = param.get(0) * param.get(1);
		return res;
	 }
	public static int div(List<Integer>param) {
		int res = param.get(0) / param.get(1);
		return res;
	 }
}