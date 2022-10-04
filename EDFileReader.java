import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class EDFileReader {
    public static String getTextFromFile(File file) {

		StringBuffer completeData = new StringBuffer("");			
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));	
			String tempData = "";
			while ((tempData = br.readLine()) != null) {				
				completeData.append(tempData);
				completeData.append('\n');
			}   
		}catch(Exception e){
            System.out.println("Some Error Occured ");
        }
		return completeData.toString();
	}
}
