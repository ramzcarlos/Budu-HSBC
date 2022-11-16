package proyecto_junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CommonMethods {

	public void redirectStdOutput(String path) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("aqui haciendo prueba: " +path);
		String mensaje="";
        File myObj = new File("A.txt");
        Scanner myReader = new Scanner(myObj);  
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
        
        System.out.println(mensaje);
    
		
	}

	public String readFileContents(String stdOutputPath) throws IOException {
		// TODO Auto-generated method stub
		
		
		  File archivo = new File (stdOutputPath);
		  FileReader fr = new FileReader (archivo);
		  BufferedReader br = new BufferedReader(fr);
		  
		  System.out.println(br); // Lectura del fichero String linea; String
		  String mensaje = ""; String linea;
		while((linea=br.readLine())!=null) { 
			//System.out.println(linea);
		  mensaje+=linea; 
		  }
		 
		return mensaje;
	}

}
