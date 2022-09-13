package webscraperpack;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Crawler {

	private static List<String[]> createCsvDataSimple() {
		// TODO Auto-generated method stub
		List<String[]> list = new ArrayList<>();
		
		final String url = 
				"https://www.yellowpages.com/search?search_terms=Mexican+Restaurants&geo_location_terms=Los+Angeles%2C+CA";
		try {
			final Document document = Jsoup.connect(url).get();
			
			for (Element row : document.select(
					"div.search-results.organic")) {
				if (row.select(".n").text().equals("")) {
					break;
				}
				else {
					final String storeName = 
							row.select(".n").text();	
					String[] arrOfstore = storeName.split("\\s?\\d{1,2}+\\.\\s?");
//					for (String a : arrOfstore)
//			            System.out.println("name"+a);
			
					final String storePhone = 
							row.select(".info > .info-secondary.info-section > .primary.phone.phones").text();
					String[] arrOfPhone = storePhone.split("(?=[\\(])");
					
					final String openStatus = 
							row.select(".info > .info-secondary.info-section > .open-status").text();
					String[] arrOfStatus = openStatus.split(" NOW");
					
//					for (String a : arrOfStatus)
//			            System.out.println(a);
					
//					for (String a : arrOfPhone)
//		            System.out.println(a);
				
//					final String storeAddr = 
//						row.select(".info > .info-secondary.info-section > .adr > .street-address").text();
//					System.out.println(storeAddr);
//					String[] arrOfAddr = storeAddr.split( "[ ]");
//					for (String a : arrOfAddr)
//		            System.out.println(a);
				
//					final String storelocality = 
//						row.select(".info > .info-secondary.info-section > .adr > .locality").text();
//					System.out.println(storelocality);
//					String[] arrOfLocality = storelocality.split("(?=\\s?\\d{5}+\\s?)");
//					for (String a : arrOfLocality)
//		            System.out.println("Zip"+a);
			        

			        list.add(arrOfstore);
			        list.add(arrOfPhone);
			        list.add(arrOfStatus);
					
					
				}
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return list;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("result.csv"))) {
            writer.writeAll(csvData);
        }
	
		System.out.println("complete");
	}
	
	
	
	
	
	
	
	
	
	

}
