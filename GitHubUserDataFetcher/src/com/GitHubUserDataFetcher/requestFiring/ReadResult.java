package com.GitHubUserDataFetcher.requestFiring;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadResult {
    public void readEventResponse(String response){
        
        try {
        	ObjectMapper mapper = new ObjectMapper();
            JsonNode rootArray = mapper.readTree(response);
          //  System.out.println("Response : "+response);
            System.out.println("============Printing Json Body===============");

            // Loop through each event object in the array
            for (JsonNode item : rootArray) {
                // Fetch specific fields by their text keys instead of numbers
                String id = item.get("id").asText();
                String type = item.get("type").asText();
                String repoName = item.get("repo").get("name").asText();
                String createdAt = item.get("created_at").asText();
                int numberOfCommits = item.get("payload").get("number") != null ? item.get("payload").get("number").asInt() : 1;
                boolean typeOfRepo = item.get("public") != null && item.get("public").asBoolean();

                System.out.println("============================================");
                System.out.println("Event ID   : " + id);
                System.out.println("Event Type : " + type);
                System.out.println("Repository : " + repoName);
                System.out.println("Created At : " + createdAt);
                System.out.println("Number of Commits : "+ numberOfCommits);
                System.out.println("Is Public Repository : " +typeOfRepo);
                System.out.println("============================================");
            }

        } catch (NullPointerException npe) {
            System.out.println("NullPointerException caught! A field you tried to grab might not exist.");
            npe.printStackTrace();
        } catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        
    }
    
    public void readUserInfoResponse(String response) {
    	if(response != "" || response != null) {
    		try {
    			ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response);
                
                System.out.println("==============User Information ===================");
              
            	String username = root.get("name") != null ? root.get("name").asText() : "not found";
            	String company = root.get("company") != null ? root.get("company").asText() : "not found";
            	//String TwitterUsername = root.get("twitter_username") != null ? root.get("twitter_username").asText() : "not found";
            	int publicRepos = root.get("public_repos") != null ? root.get("public_repos").asInt() : 0;
            	int publicGists = root.get("public_gists") != null ? root.get("public_gists").asInt() : 0;
            	int followers = root.get("followers") != null ? root.get("followers").asInt() : 0;
            	int following = root.get("following") != null ? root.get("following").asInt() : 0;
            	String accountCreatedOn = root.get("created_at") != null ? root.get("created_at").asText() : "not Available";
            	String lastUpdatedOn = root.get("updated_at") != null ? root.get("updated_at").asText() : "not Available";
            	
            	
            	//Print the information.
            	System.out.println("Name of User : "+ username);
            	System.out.println("Company : "+ company);
            	System.out.println("Number of public repositories : "+publicRepos);
            	System.out.println("Number of public Gists : "+ publicGists);
            	System.out.println("Number of Followers : "+ followers);
            	System.out.println("Number of Users Following : "+following);
            	System.out.println("Account created on : "+ accountCreatedOn);
            	System.out.println("Account last updated on : "+lastUpdatedOn);
                	
            
    		}catch (NullPointerException npe) {
                System.out.println("NullPointerException caught! A field you tried to grab might not exist.");
                npe.printStackTrace();
            } catch(Exception e){
                System.out.println("Exception : " + e.getMessage());
            }
    	}
    }
    public void readUsersRepoData(String response) {
    	if(response != "" || response != "null" || response != null) {
    		try {
    			ObjectMapper mapper = new ObjectMapper();
    			JsonNode rootArray = mapper.readTree(response);
    			
    			for(JsonNode item : rootArray) {
    				
    				String repoName = item.get("name") != null ? item.get("name").asText() : "Not Found";
    				String description = item.get("description") != null ? item.get("description").asText() : "Not Found";
    				String createdOn = item.get("created_at") != null ? item.get("created_at").asText() : "Not Found";
    				String updatedOn = item.get("updated_at") != null ? item.get("updated_at").asText() : "Not Found";
    				int repoSize = item.get("size") != null ? item.get("size").asInt() : 0;
    				int watchersCount = item.get("watchers_count") != null ? item.get("watchers_count").asInt() : 0;
    				int stargazersCount = item.get("stargazers_count") != null ? item.get("stargazers_count").asInt() : 0;
    				String language = item.get("language") != null ? item.get("language").asText() : "Not Found";
    				String repoUrl = item.get("url") != null ? item.get("url").asText() : "Not Found";
    				
    				System.out.println("\n=================== Repository "+ repoName +" =======================\n");
    				System.out.println("Repository Name : "+ repoName);
    				System.out.println("Repository Description : "+description);
    				System.out.println("Created on : "+createdOn);
    				System.out.println("Last updated on : "+updatedOn);
    				System.out.println("Repository Size : "+repoSize);
    				System.out.println("Watchers : "+watchersCount);
    				System.out.println("Stars Count : "+stargazersCount);
    				System.out.println("Language used : "+language);
    				System.out.println("Repositoyr URL : "+repoUrl);
    			}
    		}catch(Exception e) {
    			System.out.println("Error reading response : "+e.getMessage());
    		}
    	}
    }
}
