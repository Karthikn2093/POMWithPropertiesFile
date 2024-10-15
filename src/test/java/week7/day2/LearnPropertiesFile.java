package week7.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearnPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Set the file path for interaction
		
		FileInputStream fis = new FileInputStream("./src/test/resources/French.properties");
		
		//create object for Properties
		Properties prop = new Properties();
		
		//to load the properties file for interaction
		prop.load(fis);
		
		//to get a value from the properties file
		
		System.out.println(prop.getProperty("abc"));
		
		
		

	}

}
