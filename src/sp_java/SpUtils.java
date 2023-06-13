package sp_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SpUtils {
	public static String getDateFormat(String format) {//"yyyy-mm-dd_hh-mm-ss"
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String strNowDate = simpleDateFormat.format(date); 
		
		return strNowDate;
	}
	
	static String getAbsolutePath() {
		Path currentPath = Paths.get("");
        String absolutepath = currentPath.toAbsolutePath().toString();
        return absolutepath;
	}
	
	static String getConsoleOneLine() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine(); //next는 공백으로도 끊음
		sc.close();
		return line;
	}
	
	static void FileSearchAll(String path, ArrayList<File> fileList) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isDirectory()) {
				FileSearchAll(file.getPath(), fileList);
			}
			else {
				fileList.add(file);
			}
		}
	}
	
	static void MakeDirAll(String path) {
		File dst = new File(path);
		if(!dst.exists() ) {
			dst.mkdirs();
		}
	}
	
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
