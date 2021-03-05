package java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeSerializableEx {

	/**
	 * 역직렬화
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "Userinfo.ser"; 
		try(FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)){
			
//			UserInfo u1 = (UserInfo) ois.readObject();
//			UserInfo u2 = (UserInfo) ois.readObject();
			@SuppressWarnings("unchecked")
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject();
			
			System.out.println(list.get(0));
			System.out.println(list.get(1));
			System.out.println(list);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	} // main

}
