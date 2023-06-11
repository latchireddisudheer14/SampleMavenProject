package selenium;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp  {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream ip= new FileInputStream("C:/Users/000QPC744/eclipse-workspace/SampleMavenProject/src/"
		+"main/java/selenium/config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("browser"));

	}

}
