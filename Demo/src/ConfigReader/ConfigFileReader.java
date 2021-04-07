package ConfigReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	 private final String propertyFilePath= "config.properties";
	 
	 
	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getURL()
	 {
		 String driverPath = properties.getProperty("URL");
		 if(driverPath!= null) 
			 return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	 
	 public String getFromCity()
	 {
		 String from = properties.getProperty("from");
		 if(from!= null) 
			 return from;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	 
	 public String getToCity()
	 {
		 String to = properties.getProperty("to");
		 if(to!= null) 
			 return to;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }

	 public String getDepDate()
	 {
		 String dep = properties.getProperty("depDate");
		 if(dep!= null) 
			 return dep;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }

	 public String getRetDate()
	 {
		 String ret = properties.getProperty("retDate");
		 if(ret!= null) 
			 return ret;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }

}
