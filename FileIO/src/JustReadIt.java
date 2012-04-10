import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JustReadIt { 
  public static void main (String [] args) throws IOException {
	
	String file_name = "/Temp/Jabberwocky.txt";
	
	FileReader fr = new FileReader(file_name);
	BufferedReader br = new BufferedReader(fr);
	
	System.out.println("Copied from the file to the console:");
	
	while(br.ready()){	
	    System.out.println(br.readLine());
	}
  }
}