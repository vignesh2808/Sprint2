package dataProviders;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static String getReportConfigPath() throws IOException{
		FileReader filer = new FileReader("Configuration.properties");
		Properties data = new Properties();
		data.load(filer);
		String reportConfigPath = data.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
		}
}
