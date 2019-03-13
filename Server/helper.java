import java.util.ArrayList;
import java.util.List;

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
