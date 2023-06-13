package sp_java;

import java.io.File;
import java.util.ArrayList;

public class FileDir {
	static void FileDirList() {
		File dir = new File(".");
		File[] fList = dir.listFiles();
		
		for (File file: fList) {
			if(file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");
			}
			else {
				System.out.println(file.getName());
			}
		}
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
}
