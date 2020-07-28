package com.example.utilities;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.entity.Company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class YahooWebServiceGet {   

    public static void main(String[] args) throws Exception {
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	//avg top 50 or 100 in past two weeks
//    	List<Company> list=new ArrayList<Company>();
//    	List<Company> list2=new ArrayList<Company>();
//    	topCompanies companyobj=new topCompanies();
//    	String topcompanies[]=companyobj.ListTop100();
//        int i=0;
//  
//            JsonParser parser = new JsonParser();
//            String inline;
//            for(i=0;i<topcompanies.length;i++)
//            {
//            inline=MyGETRequest(topcompanies[i]);
//            if(!inline.equals(" "))
//            {
//      JsonObject jsonObject = parser.parse(inline).getAsJsonObject();
//      JsonObject jobj=jsonObject.get("quoteSummary").getAsJsonObject();    
//      JsonObject price=jobj.getAsJsonObject().get("result").getAsJsonArray().get(0).getAsJsonObject().get("price").getAsJsonObject();
//      JsonObject defaultKeyStatistics=jobj.getAsJsonObject().get("result").getAsJsonArray().get(0).getAsJsonObject().get("defaultKeyStatistics").getAsJsonObject();
//      
//      Company dataobj = new Company();
//      dataobj.setSymbol(price.get("symbol").getAsString());
//      dataobj.setMarketCap(price.get("marketCap").getAsJsonObject().get("raw").getAsLong());
//      
//      if(defaultKeyStatistics.get("forwardPE").getAsJsonObject().get("raw")!=null)
//      dataobj.setForwardPE(defaultKeyStatistics.get("forwardPE").getAsJsonObject().get("raw").getAsDouble());
//      else 
//    	  dataobj.setForwardPE(0D);      
//      dataobj.setCompanyName(price.get("shortName").getAsString()); 
//      
//      if(defaultKeyStatistics.get("bookValue").getAsJsonObject().get("raw")!=null)
//      dataobj.setBookValue(defaultKeyStatistics.get("bookValue").getAsJsonObject().get("raw").getAsDouble());
//      else
//    	  dataobj.setBookValue(0D);
//      
//      if(defaultKeyStatistics.get("priceToBook").getAsJsonObject().get("raw")!=null)
//          dataobj.setPriceToBook(defaultKeyStatistics.get("priceToBook").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setPriceToBook(0D);
//      
//      if(defaultKeyStatistics.get("trailingEps").getAsJsonObject().get("raw")!=null)
//          dataobj.setTrailingEps(defaultKeyStatistics.get("trailingEps").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setTrailingEps(0D);
//      
//      if(defaultKeyStatistics.get("forwardEps").getAsJsonObject().get("raw")!=null)
//          dataobj.setForwardEps(defaultKeyStatistics.get("forwardEps").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setForwardEps(0D);
//      
//      if(defaultKeyStatistics.get("pegRatio").getAsJsonObject().get("raw")!=null)
//          dataobj.setPegRatio(defaultKeyStatistics.get("pegRatio").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setPegRatio(0D);
//      
//      if(defaultKeyStatistics.get("lastDividendValue").getAsJsonObject().get("raw")!=null)
//          dataobj.setLastDividendValue(defaultKeyStatistics.get("lastDividendValue").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setLastDividendValue(0D);
//      
//      if(price.get("regularMarketPrice").getAsJsonObject().get("raw")!=null)
//          dataobj.setRegularMarketPrice(price.get("regularMarketPrice").getAsJsonObject().get("raw").getAsDouble());
//          else
//        	  dataobj.setRegularMarketPrice(0D);
//      
//      list.add(dataobj);
//      System.out.println(price.get("marketCap").getAsJsonObject().toString());
//           
//             }
//            }
// list.stream().forEach(x -> System.out.println(x.getSymbol()+":"+x.getMarketCap()+":"+x.getForwardPE()+":"+x.getCompanyName()+":"+x.getBookValue()+":"+x.getPriceToBook()+":"+x.getTrailingEps()+":"+x.getForwardEps()+":"+x.getPegRatio()+":"+x.getLastDividendValue()+":"+x.getRegularMarketPrice()));
//    
//}
    
//public static String financeFetchData(String symbol) throws ClientProtocolException, IOException
//{
//	System.out.println("Starting data fetch for "+symbol);
//	CloseableHttpClient httpclient = HttpClients.createDefault();
//	String url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=arr[0]";
//	HttpGet httpget = new HttpGet(url);
//	URL urltry = new URL("https://query1.finance.yahoo.com/v10/finance/quoteSummary/AAPL?modules=financialData");
//	//URL urltry = new URL("http://finance.yahoo.com/d/quotes.csv?s={SYMBOLS}&f={DATA THAT WE WANT}");
//	//URL urltry = new URL("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-statistics?region=US&symbol="+symbol);
//
//	CloseableHttpResponse response = httpclient.execute(httpget);
//	try {
//	    HttpEntity entity = response.getEntity();
//	    InputStream is = entity.getContent();
//	
//	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String line, str = null;
//      
//        while ((line = br.readLine()) != null) {
//        	str=line;
//            //System.out.println(line);
//            str.concat(line);
//        }
//        String inline="";
//        Scanner sc= new Scanner(urltry.openStream());
//        while(sc.hasNext())
//        {
//        inline+=sc.nextLine();
//        }
//        return inline;
//	}  
//	finally {
//	    response.close();
//	}
//}
    }
public static String MyGETRequest(String symbol) throws IOException {
	System.out.println("Starting data fetch for "+symbol);
    URL urlForGetRequest = new URL("https://query1.finance.yahoo.com/v10/finance/quoteSummary/"+symbol+"?modules=price%2CdefaultKeyStatistics");
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
   
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
       // System.out.println("JSON String Result " + response.toString());
        //GetAndPost.POSTRequest(response.toString());
        return response.toString();
    } else {
        return(" ");
    }
}

public static List<Company> getCompanies() throws Exception
{
	
	List<Company> list=new ArrayList<Company>();
	List<Company> list2=new ArrayList<Company>();
	CompanySymbolList companyobj=new CompanySymbolList();
	String topcompanies[]=companyobj.ListTop100();
    int i=0;

        JsonParser parser = new JsonParser();
        String inline;
    for(i=0;i<topcompanies.length;i++)
    {
    inline=MyGETRequest(topcompanies[i]);
    if(!inline.equals(" "))
    {
JsonObject jsonObject = parser.parse(inline).getAsJsonObject();
JsonObject jobj=jsonObject.get("quoteSummary").getAsJsonObject();    
JsonObject price=jobj.getAsJsonObject().get("result").getAsJsonArray().get(0).getAsJsonObject().get("price").getAsJsonObject();
JsonObject defaultKeyStatistics=jobj.getAsJsonObject().get("result").getAsJsonArray().get(0).getAsJsonObject().get("defaultKeyStatistics").getAsJsonObject();

Company dataobj = new Company();
dataobj.setSymbol(price.get("symbol").getAsString());
dataobj.setMarketCap(price.get("marketCap").getAsJsonObject().get("raw").getAsLong());

if(defaultKeyStatistics.get("forwardPE").getAsJsonObject().get("raw")!=null)
dataobj.setForwardPE(defaultKeyStatistics.get("forwardPE").getAsJsonObject().get("raw").getAsDouble());
else 
  dataobj.setForwardPE(0D);      
dataobj.setCompanyName(price.get("shortName").getAsString()); 

if(defaultKeyStatistics.get("bookValue").getAsJsonObject().get("raw")!=null)
dataobj.setBookValue(defaultKeyStatistics.get("bookValue").getAsJsonObject().get("raw").getAsDouble());
else
  dataobj.setBookValue(0D);

if(defaultKeyStatistics.get("priceToBook").getAsJsonObject().get("raw")!=null)
  dataobj.setPriceToBook(defaultKeyStatistics.get("priceToBook").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setPriceToBook(0D);

if(defaultKeyStatistics.get("trailingEps").getAsJsonObject().get("raw")!=null)
  dataobj.setTrailingEps(defaultKeyStatistics.get("trailingEps").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setTrailingEps(0D);

if(defaultKeyStatistics.get("forwardEps").getAsJsonObject().get("raw")!=null)
  dataobj.setForwardEps(defaultKeyStatistics.get("forwardEps").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setForwardEps(0D);

if(defaultKeyStatistics.get("pegRatio").getAsJsonObject().get("raw")!=null)
  dataobj.setPegRatio(defaultKeyStatistics.get("pegRatio").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setPegRatio(0D);

if(defaultKeyStatistics.get("lastDividendValue").getAsJsonObject().get("raw")!=null)
  dataobj.setLastDividendValue(defaultKeyStatistics.get("lastDividendValue").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setLastDividendValue(0D);

if(price.get("regularMarketPrice").getAsJsonObject().get("raw")!=null)
  dataobj.setRegularMarketPrice(price.get("regularMarketPrice").getAsJsonObject().get("raw").getAsDouble());
  else
	  dataobj.setRegularMarketPrice(0D);

list.add(dataobj);
//System.out.println(price.get("marketCap").getAsJsonObject().toString());
   
     }
    }
//list.stream().forEach(x -> System.out.println(x.getSymbol()+":"+x.getMarketCap()+":"+x.getForwardPE()+":"+x.getCompanyName()+":"+x.getBookValue()+":"+x.getPriceToBook()+":"+x.getTrailingEps()+":"+x.getForwardEps()+":"+x.getPegRatio()+":"+x.getLastDividendValue()+":"+x.getRegularMarketPrice()));
return list;
}

	

}



