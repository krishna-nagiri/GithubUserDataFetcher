package com.GitHubUserDataFetcher.OptionsAndDisplay;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class HomeDisplay {
    public boolean displayFeatures(){
        String FeatuersFile = "C:\\Users\\Krishna Nagiri\\IdeaProjects\\" +
                "FetchGitData\\GithubUserActivityFetcher\\Data\\AvaliableFeatures.json";

        ObjectMapper mapper = new ObjectMapper();

        try{
            JsonNode rootNode = mapper.readTree(new File(FeatuersFile));
            Integer i = 1;
            for(JsonNode item : rootNode){
                String id = i.toString();
                String value = item.get(id).asText();
                System.out.println(id + ". "+value);
            }
            return true;
        }catch(IOException ioe){
            System.out.println("IOException : " + ioe.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("Exception : "+e.getMessage());
            return false;
        }

    }

}
