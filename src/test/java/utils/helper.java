package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class helper {
	
	
	public static List<String>  getLoginCredentials(String csvFile) throws FileNotFoundException, CsvValidationException {
		String[] cellData;
		List<String> response = new ArrayList<String>();
		
		// Retrieves test data
		String loginCsv= System.getProperty("user.dir")+"/resources/testdata/"+csvFile;
//		CSVReader reader = new CSVReader(new FileReader(loginCsv));
		
		try{
			CSVReader reader = new CSVReader(new FileReader(loginCsv));
			while((cellData = reader.readNext())!=null) {
				int dataLen = cellData.length;
				System.out.println(dataLen);
				for (int i =0; i < dataLen; i++) {
					response.add(cellData[i]);
					
				}
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(response);
		return response;
//		return new String[] { username,password,browserUrl };
	}
}
