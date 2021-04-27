package server.appService;

import org.json.simple.JSONArray;
import server.remote.GithubRestClient;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

public class AppService {
  public String descarga(ArrayList<String> arrayParams) {

    // Example 1 -> List all users (one call retrieves 100 maximum)
    // https://docs.github.com/en/rest/reference/users#list-users
    JSONArray array =new JSONArray();
    String name = "";

    try {
      GithubRestClient c1 = new GithubRestClient("users");
      Response res1 = c1.makeGetRequest("");

      //Print the response, as it is
      System.out.println(res1);

      // Print the response as String
      // System.out.println(res1.readEntity(String.class));

      // Parse the response as JsonArray
      array = res1.readEntity(JSONArray.class);
      System.out.println(array.size());

      HashMap<String, String> object1 = (HashMap<String, String>)array.get(0);
      name = (String)object1.get("login");
      System.out.println(object1);


      // since and per_page parameters are also relevant
      // curl -H "Accept: application/vnd.github.v3+json" "https://api.github.com/users?per_page=2&since=5"

    } catch (Exception e) {

      System.out.println("Catched exception: " + e.getMessage());
    }
    return name;
  }
}

