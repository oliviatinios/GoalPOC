import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoalHttpClient {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		GoalHttpClient http = new GoalHttpClient();

		// Save a goal
		System.out.println("/************************************ TEST 1 - ADD A GOAL ************************************/");
		JSONObject result = http.sendPost("Goal1", "Bob");
		String goal_id = result.getString("id");
		System.out.println(goal_id);
		
		Thread.sleep(50);
		
		// Get goal by id
		System.out.println("\n\n\n/************************************ TEST 2 - VIEW GOAL ************************************/");
		http.sendGet(goal_id);
		System.out.println(goal_id);
		
		// Update goal
		System.out.println("\n\n\n/************************************ TEST 3 - UPDATE GOAL ************************************/");
		http.sendPatch("GOAL1-UPDATED", "Bob", goal_id);
		System.out.println(goal_id);

		Thread.sleep(50);
		
		// Get updated goal by id
		System.out.println("\n\n\n/************************************ TEST 4 - VIEW UPDATED GOAL ************************************/");
		http.sendGet(goal_id);
		System.out.println(goal_id);
		
	}

	// HTTP GET request - get goal by id
	private void sendGet(String id) throws Exception {

		String url = "http://192.168.20.113:8082/goal/" + id;

		HttpClient client = HttpClientBuilder.create().build();

	
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println("Response : " + result.toString());
		
		
	}

	// HTTP POST request - save goal
	private JSONObject sendPost(String name, String createBy) throws Exception {

		String url = "http://192.168.20.113:8081/goal";

		HttpClient client = HttpClientBuilder.create().build();
		
		JSONObject json = new JSONObject();
        json.put("createBy", createBy);
        json.put("createOn", "string");
        json.put("goalId", "string");
        json.put("goalName", name);
        json.put("goalStatusCode", "string");
        json.put("goalSubtypeCode", "string");
        json.put("goalTypeCode", "string");
        json.put("modifiedBy", "string");
        json.put("modifiedOn", "string");
        json.put("note", "string");
       
        JSONObject primaryClient = new JSONObject();
        primaryClient.put("clientId", "string");
        primaryClient.put("clientTypeCode", "string");
        primaryClient.put("clientXRefId", "string");
        primaryClient.put("createBy", "string");
        primaryClient.put("createOn", "string");
        primaryClient.put("modifiedBy", "string");
        primaryClient.put("modifiedOn", "string");
    	json.put("primaryClient", primaryClient);
    	
    	JSONObject saveForAnythingDetails = new JSONObject();
    	saveForAnythingDetails.put("completeDate", "string");
    	saveForAnythingDetails.put("cost", "string");
    	saveForAnythingDetails.put("costFrequencyCode", "string");
    	saveForAnythingDetails.put("costTimeValue", "string");
    	saveForAnythingDetails.put("currencyCode", "string");
    	saveForAnythingDetails.put("investmentPropertyInd", "string");
    	saveForAnythingDetails.put("ownedHomeCanadaInd", "string");
    	saveForAnythingDetails.put("recurrence", "string");
    	saveForAnythingDetails.put("startDate", "string");
    	saveForAnythingDetails.put("targetDateCode", "string");
    	json.put("saveForAnythingDetails", saveForAnythingDetails);
		
        StringEntity params = new StringEntity(json.toString());

	    HttpPost request = new HttpPost(url);
	    
	   request.addHeader("content-type", "application/json");
	    request.setEntity(params);
	    HttpResponse response = client.execute(request);

		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + json);
		System.out.println("Response Code : " + 
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println("Response : " + result.toString());
		
		JSONObject json_result = new JSONObject(result.toString());
		return json_result;
	

	}
	
	// HTTP PATCH request - update goal
		private JSONObject sendPatch(String name, String createBy, String id) throws Exception {

			String url = "http://192.168.20.113:8081/goal/" + id;

			HttpClient client = HttpClientBuilder.create().build();
			
			JSONObject json = new JSONObject();
	        json.put("createBy", createBy);
	        json.put("createOn", "09/28/2018");
	        json.put("goalId", "12345");
	        json.put("goalName", name);
	        json.put("goalStatusCode", "12345");
	        json.put("goalSubtypeCode", "12345");
	        json.put("goalTypeCode", "12345");
	        json.put("modifiedBy", "Bob");
	        json.put("modifiedOn", "09/28/2018");
	        json.put("note", "");
	       
	        JSONObject primaryClient = new JSONObject();
	        primaryClient.put("clientId", "123456789");
	        primaryClient.put("clientTypeCode", "123456789");
	        primaryClient.put("clientXRefId", "123456789");
	        primaryClient.put("createBy", "Bob");
	        primaryClient.put("createOn", "09/28/2018");
	        primaryClient.put("modifiedBy", "Bob");
	        primaryClient.put("modifiedOn", "09/28/2018");
	    	json.put("primaryClient", primaryClient);
	    	
	    	JSONObject saveForAnythingDetails = new JSONObject();
	    	saveForAnythingDetails.put("completeDate", "09/28/2020");
	    	saveForAnythingDetails.put("cost", "10000");
	    	saveForAnythingDetails.put("costFrequencyCode", "12345");
	    	saveForAnythingDetails.put("costTimeValue", "5");
	    	saveForAnythingDetails.put("currencyCode", "1");
	    	saveForAnythingDetails.put("investmentPropertyInd", "1");
	    	saveForAnythingDetails.put("ownedHomeCanadaInd", "1");
	    	saveForAnythingDetails.put("recurrence", "1");
	    	saveForAnythingDetails.put("startDate", "09/28/2018");
	    	saveForAnythingDetails.put("targetDateCode", "1");
	    	json.put("saveForAnythingDetails", saveForAnythingDetails);
	    	
	        StringEntity params = new StringEntity(json.toString());

		    HttpPatch request = new HttpPatch(url);
		    
		   request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse response = client.execute(request);

			System.out.println("\nSending 'PATCH' request to URL : " + url);
			System.out.println("Post parameters : " + json);
			System.out.println("Response Code : " + 
	                                    response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println("Response : " + result.toString());
			
			JSONObject json_result = new JSONObject(result.toString());
			return json_result;

		}

}
