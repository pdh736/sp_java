package sp_java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	static public void PrintFile(String fileName) {
		String line = null;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferdReader = new BufferedReader(fileReader);
			
			while((line = bufferdReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferdReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public void CopyFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE = 4096;
		int readLen;
		//String[] paths = outputFile.split("\\\\"); //경로는 split \\\\ 으로 해야함
		try {
			InputStream inputStream = new FileInputStream(inputFile);
			OutputStream outputStream = new FileOutputStream(outputFile);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			while((readLen = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, readLen);;
			}
			inputStream.close();
			outputStream.close();
		}
		catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
