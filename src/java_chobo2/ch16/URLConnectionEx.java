package java_chobo2.ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionEx {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://sports.news.naver.com/news.nhn?oid=109&aid=0004359424");
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream()));
				
				BufferedWriter bw =new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("test.html")))){
			
			String line =null;
			
			while((line = br.readLine()) !=null){
				System.out.println(line);
				bw.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	
	}

}
