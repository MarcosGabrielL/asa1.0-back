package com.softsaj.AsaSpring.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.softsaj.AsaSpring.models.Torrent;
import com.softsaj.AsaSpring.util.convertHtmlIntoData;

public class SearchMoviesTorrent {
	
	
	public List<Torrent>  SearchTorrents(String query,String query_en, int category ) {
		
		//Envia request
		String url = "https://www1.thepiratebay3.to/s/?q="+query.replace(" ", "+")+"&category="+category;
		
		String url_en = "https://www1.thepiratebay3.to/s/?q="+query_en.replace(" ", "+")+"&category="+category;
		
		//convert  HTML response par aLista de Object
		List<Torrent> torrents = new ArrayList<>();
		torrents.addAll(new convertHtmlIntoData(executeGet(url, " ")).convert(0));
		torrents.addAll(new convertHtmlIntoData(executeGet(url_en, " ")).convert(1));
		
		
		return torrents;
		
	}
	
	public String translate(String query) {
		
		return query; //executeGet("https://libretranslate.com/?source=pt&target=en&q=texto"," ");
		/*Translator translate = Translator.getInstance();
		String query_traduzida = translate.translate("Hello!", Language.ENGLISH, Language.ROMANIAN);
		System.out.println(query_traduzida); // "Bună ziua!" 
		return query_traduzida;*/
	}
	
	public static String executeGet(String targetURL, String urlParameters) {
		  HttpURLConnection connection = null;

		  try {
		    //Create connection
		    URL url = new URL(targetURL);
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		    connection.setRequestProperty("Content-Length", 
		        Integer.toString(urlParameters.getBytes().length));
		    connection.setRequestProperty("Content-Language", "en-US");  

		    connection.setUseCaches(false);
		    connection.setDoOutput(true);

		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		        connection.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		     // response.append('\r');
		    }
		    rd.close();
		    return response.toString();
		  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }
		}
}
