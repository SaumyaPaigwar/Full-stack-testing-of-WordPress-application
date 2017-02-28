package test.java.Integration.FunctionalRest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.sf.json.JSONException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.SessionId;

import com.google.gson.JsonElement;

public class GridInfoExtractor{

	public static String[] getHostNameAndPort(String hostName, int port,
			SessionId session) {
		String[] hostAndPort = new String[2];
		String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";

		try {
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			HttpHost host = new HttpHost(hostName, port);
			
			System.out.println("****************************************");
			DefaultHttpClient client = new DefaultHttpClient();
			URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			JSONObject object = extractObject(response);
			
			System.out.println("--------------------------------------------"+ object.get("proxyId"));
		
			String url = (String) object.get("proxyId");
			URL myURL = new URL(url);
			if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
				hostAndPort[0] = myURL.getHost();
				hostAndPort[1] = Integer.toString(myURL.getPort());
			}
		} catch (Exception e) {
			//logger.log(Level.SEVERE, errorMsg, e);
			throw new RuntimeException(errorMsg, e);
		}
		return hostAndPort;
	}

	private static JSONObject extractObject(HttpResponse resp) throws IOException, JSONException, ParseException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer s = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			s.append(line);
		}
		rd.close();
		JSONParser parser = new JSONParser();
		JSONObject objToReturn = (JSONObject)parser.parse(s.toString());
		return objToReturn;
	}
}
