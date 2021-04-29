package server.gateway;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.LinkedHashMap;

import server.gateway.IGithubRestClient;

public class GithubRestClient implements IGithubRestClient {

    private final String url = "https://api.github.com";
    private Client client;
    private WebTarget webTarget;

    public GithubRestClient() {

      client = ClientBuilder.newClient();
    }

    public void changeAccessPoint(String accessPoint) {

      webTarget = client.target(String.format(this.url + "/" + accessPoint ));
    }

    private HashMap<String, String> makeGetRequest() throws Exception {

      WebTarget getRequestController = this.webTarget.path("");
      Invocation.Builder invocationBuilder = getRequestController.request(MediaType.APPLICATION_JSON);
      Response response = invocationBuilder.get();

      if (response.getStatus() == Status.OK.getStatusCode()) {

        JSONArray array = response.readEntity(JSONArray.class);
        HashMap<String, String> object1 = (HashMap<String, String>)array.get(0);
        return object1;

      } else {

          throw new Exception("BadAss error ");
      }
    }

    @Override
    public HashMap<String, String> obtenerUsuarios() throws Exception {

      this.changeAccessPoint("users");
      return this.makeGetRequest();
    }
}
