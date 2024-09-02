import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Datei
{

	public static void main(String[] args) throws IOException 
	{		
		
		// java-Datei bearbeiten und weiterhin ausführbar
		
		Path java = Paths.get("H://Java/2_03_File/Beispiel.java");
		Path erg = Paths.get("H://Java/2_03_File/Ergebnis.java");
		try(BufferedReader reader = Files.newBufferedReader(java,Charset.forName("utf-8"));
			BufferedWriter writer = Files.newBufferedWriter(erg,Charset.forName("utf-8")))
		{
			String line;
			int lineNumber = 1;
			
			while((line = reader.readLine()) != null)
			{
				writer.write("/*" +lineNumber + "*/" + line);
				writer.newLine();
				lineNumber++;
			}
			System.out.println("Fertig mit Bearbeiten!");
		}		
		catch(IOException ex)
		{
			ex.printStackTrace();
		}	
		
		try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.println("Bitte geben Die den Dateinamen (mit vollständigem Pfas) ein: ");
			String source = consoleReader.readLine();				
			if(fileExists(source))
			{
				System.out.println("Datei existiert!");
			}
			else
			{
				System.out.println("Datei existiert nicht!");
			}		
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}		
	}		
		private static boolean fileExists(String path) 
		{
	        try 
	        {	            
	        	FileReader fileReader = new FileReader(path);
	            return true;
	        } 
	        catch (IOException e) 
	        {
	            return false;
	        }
	    }	
}
