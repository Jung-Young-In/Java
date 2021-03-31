package kr_or_ddit_basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class T03_PropertiesTest {
	
	//외부의 properties 파일을 읽어와 Properties 객체로 처리하기
	
	public static void main(String[] args) {
		//읽어온 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		
		//읽어올 파일명을 이용한 File 객체 생성
		File file = new File("res/db.properties");
		
		try {
			//파일 읽기를 수행할 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream(file);
			
			//Properties 객체로 파일 내용 읽기
			prop.load(fis); 	//파일 내용을 읽어와 key와 value 값으로 분류한 후 Properties 객체에 담아준다
			
			//읽어온 자료 출력하기
			
			//key값만 읽어와 Enumeration 객체로 변환하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			
			//key값 개수만큼 반복해서 값 출력하기
			
			//key.hasMoreElements() => 다음 포인터 위치에 자료가 있으면 true, 없으면 false 리턴
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " => " + value);
			}
			System.out.println("출력 완료");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
