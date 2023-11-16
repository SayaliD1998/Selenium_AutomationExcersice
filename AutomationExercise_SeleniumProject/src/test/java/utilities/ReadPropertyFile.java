package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {


	public static void main(String[] args) throws IOException {

		//Give path of src/test/resources : Configfiles : config.Properties File
	    FileReader fr = new FileReader("C:\\Users\\Acer\\Downloads\\Project2_AutomationExcercise-main\\Project2_AutomationExcercise-main\\Project2_AutomationExercise\\src\\test\\resources\\ConfigFiles") ;

		//Create Object of Properties Class
	    Properties p = new  Properties();

	    p.load(fr);

	    //It take values from config.Properties File
	    System.out.println(p.getProperty("Browser"));
	    System.out.println(p.getProperty("TestUrl"));


		}



}
