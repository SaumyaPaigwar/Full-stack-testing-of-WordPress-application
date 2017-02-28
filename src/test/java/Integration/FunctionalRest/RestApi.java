package test.java.Integration.FunctionalRest;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import groovyx.net.http.ContentType;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.Integration.FunctionalRest.ReadCsv;

//import test.ReadFile;


import com.google.gson.stream.JsonWriter;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class RestApi 
{
	
 @Test
 public void GetUser() throws IOException 
 {
	 ReadCsv r = new ReadCsv();
	 List<String> rlist = r.csvRead();
	// System.out.println(list);
     String body = given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").when().get("http://localhost:85/wordpress/wp-json/users").thenReturn().asString();
    // int i=given().when().get("http://localhost:85/wordpress/wp-admin/users.php").thenReturn().statusCode();
     
     System.out.println(body);
  
 }

 @Test
 public void CreateUser() throws IOException
 {
	 ReadCsv r = new ReadCsv();
	 List<String> rlist = r.csvRead();
	 int listsize = rlist.size();
	 System.out.println("List size is :"+ listsize);
	 System.out.println(rlist);
	 String userdetails = given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").formParam("username", rlist.get(listsize-3)).formParam("password", rlist.get(listsize-2)).formParam("email", rlist.get(listsize-1)).request().post("http://localhost:85/wordpress/wp-json/users").asString();
	 //String userdetail = given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").formParam("username", rlist.get(6)).formParam("password", rlist.get(7)).formParam("email", rlist.get(8)).request().post("http://localhost:85/wordpress/wp-json/users").asString();
	 System.out.println(userdetails);
	 String []line = userdetails.split(",");
	 String []data = line[0].split(":");
	 System.out.println("New ID : "+data[1]);
	
	// System.out.println(userdetail);
 }
 
 
 
@Test
 public void DeleteUser()
 {
	 given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").when().delete("http://localhost:85/wordpress/wp-json/users").thenReturn().asString();
	 System.out.println("Delete Method");
 }
 
 /*
 @Test
 public void CreateUser1() 
 {
     given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").contentType("application/json").body("{\"username\":\"James Goslin\",\"email\":\"James@gmail.com\",\"password\":\"Jamespassord\"}")
     .when().post("http://localhost:85/wordpress/wp-json/users");
 }
 
 */
 /*
 @Test
 public void UpdateUser()
 {
	  given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").contentType("application/json").body("{\"first_name\":\"firstname\" ,\"last_name\":\"lastname\"}")
	     .when().put("http://localhost:85/wordpress/wp-json/users/61"); 
 }
 
 */
/* @Test
 public void urldata() throws IOException
 {
	 ReadFile r = new ReadFile();
	 List<String> rlist = r.csvRead();
	 //System.out.println("From Test"+rlist.get(0));
	 given().header("Authorization", "Basic cWVfYmF0Y2g6cWVfYmF0Y2gyMDE3").header("Content-Type", "application/x-www-form-urlencoded").formParam("email", rlist.get(2)).formParam("username", rlist.get(0)).formParam("password", rlist.get(1)).request().post("http://localhost:85/wordpress/wp-json/users");
	 
 }
*/

}