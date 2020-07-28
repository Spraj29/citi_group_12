package com.example.utilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

import com.example.entity.Company;

public class Recommendation {

public static List<Company> getTopFiveCompany(long marketCap) throws Exception{
List<Company> Company = new ArrayList<Company>();
Company=YahooWebServiceGet.getCompanies();
Map<Company,Double> finalList = new LinkedHashMap<Company,Double>();

for(Company comp: Company){
if(comp.getMarketCap() < marketCap){
System.out.println(comp.getCompanyName()+":"+comp.getTrailingEps()*0.35 + comp.getLastDividendValue()*0.35 + comp.getForwardPE()*0.30);
finalList.put(comp, comp.getTrailingEps()*0.35 + comp.getLastDividendValue()*0.35 + comp.getForwardPE()*0.30);
}
}
Map<Company,Double> sortedMap = new HashMap<Company,Double>();
sortedMap = sortByValue(finalList);
List<Company> topFiveCompany = new ArrayList<Company>();

topFiveCompany=topNKeys(finalList, 5);
//
//int i=0;
//for(Company C: sortedMap.keySet()){
//topFiveCompany.add(C);
//i++;
//if(i==5){
//break;
//}
//}
return topFiveCompany;
}

static Map<Company,Double> sortByValue(Map<Company,Double> map){  
//convert HashMap into List  
List<Entry<Company, Double>> list = new LinkedList<Entry<Company, Double>>(map.entrySet());  
//sorting the list elements  
Collections.sort(list, new Comparator<Entry<Company, Double>>()  
{  
public int compare(Entry<Company, Double> o1, Entry<Company, Double> o2)  
{  


return o2.getValue().compareTo(o1.getValue());  

}  
});  
//prints the sorted HashMap  
Map<Company, Double> sortedMap = new LinkedHashMap<Company, Double>();  
for (Entry<Company, Double> entry : list)  
{  
sortedMap.put(entry.getKey(), entry.getValue());  
}  
return map;
}  

public static List<Company> topNKeys(final Map<Company, Double> map, int n) {
    PriorityQueue<Company> topN = new PriorityQueue<Company>(n, new Comparator<Company>() {
        public int compare(Company s1, Company s2) {
            return Double.compare(map.get(s1), map.get(s2));
        }
    });

    for(Company key:map.keySet()){
        if (topN.size() < n)
            topN.add(key);
        else if (map.get(topN.peek()) < map.get(key)) {
            topN.poll();
            topN.add(key);
        }
    }
    return (List) Arrays.asList(topN.toArray());
}


public static void main(String[] args) throws Exception {
	
	List<Company> top5= new ArrayList<Company>();
	top5=getTopFiveCompany(20000000000L);
	
	top5.stream().forEach(x -> System.out.println(x.getSymbol()+":"+x.getMarketCap()+":"+x.getForwardPE()+":"+x.getCompanyName()+":"+x.getBookValue()+":"+x.getPriceToBook()+":"+x.getTrailingEps()+":"+x.getForwardEps()+":"+x.getPegRatio()+":"+x.getLastDividendValue()+":"+x.getRegularMarketPrice()));

	
	
}
}
