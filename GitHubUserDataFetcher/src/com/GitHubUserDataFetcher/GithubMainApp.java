package com.GitHubUserDataFetcher;


import java.util.Scanner;

//import com.GitHubUserDataFetcher.OptionsAndDisplay.HomeDisplay;
import com.GitHubUserDataFetcher.requestFiring.FireApiRequest;
import com.GitHubUserDataFetcher.requestFiring.ReadResult;

public class GithubMainApp 
{
	public static void main(String[] args) {
        System.out.println("=========== welcome to Github User Activity Fetcher============");

        Scanner sc = new Scanner(System.in);
        FireApiRequest fi = new FireApiRequest();
        
        ReadResult ri = new ReadResult();
        String eventsResponse = "";
        String userDataResponse = "";
        String repoDataResponse = "";

        
        
        System.out.print("Enter the username of the github user: ");
        String requiredUser = sc.next();
        sc.close();
        System.out.println();
        if(requiredUser != null) {
        	
        	//Read events
        	eventsResponse = fi.getEventInfo(requiredUser);
        	if(eventsResponse != "") {
        		ri.readEventResponse(eventsResponse);
        	}else {
        		System.out.println("Failed to fetch data\nReturned data : "+eventsResponse);
        	}
        	
        	//Read User Data
        	userDataResponse = fi.getUserInfo(requiredUser);
        	
        	if(userDataResponse != "") {
        		
        		ri.readUserInfoResponse(userDataResponse);
        		repoDataResponse = fi.getUserRepos(requiredUser);
        		if(repoDataResponse != "" || repoDataResponse != "null") {
        			System.out.println("=================== Repository Details =====================");
        			ri.readUsersRepoData(repoDataResponse);
        		}else {
        			System.out.println("Error Reading data. \nReturned Data : "+repoDataResponse);
        		}
        	}else {
        		System.out.println("Failed to fetch data. \nReturned Data : "+userDataResponse);
        	}
        	 	
        	
        }

        
     }
}
