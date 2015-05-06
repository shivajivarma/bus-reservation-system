package Bus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
	public static void main(String[] args) throws IOException {
		
		System.out.println(Integer.parseInt(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime())));
//		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ClassLoader.getSystemResource("av.jpg"));
		
		
	}
}
