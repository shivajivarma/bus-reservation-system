package com.shivajivarma.brs.utility;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class IOHelpers {

	public static void printHTML(String html, String pageName) {
		FileWriter fw;
		try {
			fw = new FileWriter(System.getenv("APPDATA") + "\\" + pageName
					+ ".html");
			fw.write(html);
			fw.close();
			Runtime.getRuntime().exec(
					"rundll32 url.dll,FileProtocolHandler file:///"
							+ System.getenv("APPDATA") + "/" + pageName
							+ ".html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFileAsString(String filePath) {
		String content = new String("");
		try {
			InputStream in = IOHelpers.class.getClass().getResourceAsStream(
					filePath);
			BufferedReader input = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = input.readLine()) != null) {
				content = content + line;
			}
			input.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
}
