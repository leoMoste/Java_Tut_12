import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("test.txt");
		if(!file.exists())
			file.createNewFile();
		System.out.println("Existiert die Datei" + file.exists());
		System.out.println("Ist das ein verzeichnis " + file.isDirectory());
		System.out.println("Kann man die datei lesen" + file.canRead());
		System.out.println("Ist die Datei veränderbar" + file.canWrite());
		System.out.println("Ist die Datei ausführbar" + file.canExecute());
		System.out.println("Letzte Änderung" + file.lastModified());
		System.out.println();
		
		Path path = Path.of(file.getAbsolutePath());
		
		//Files.write(path, "Hallo Karim".getBytes());
		
		try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            Random random = new Random();
            for(int i = 1; i <= 1000000; i++){
                writer.write(Integer.toString(random.nextInt(10000))+"\n");
                //Files.write(path, Integer.toString(random.nextInt(10000)).getBytes());
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

        try{
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        }catch(IOException ex){
            ex.printStackTrace();
        }
		
	}

}
