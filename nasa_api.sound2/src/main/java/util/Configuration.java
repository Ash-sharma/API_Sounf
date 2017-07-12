package util;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public String BaseURI;
	public int WaitTimeout;

	public Configuration() {
		loadProperties();

	}

	private void loadProperties() {
		Properties props = new Properties();
		try {
			props.load(new FileReader(String.format("%s/restConfig.properties", System.getProperty("user.dir"))));
			WaitTimeout = Integer.parseInt(props.getProperty("wait-timeout"));
			BaseURI = props.getProperty("uri");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
