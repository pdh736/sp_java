package sp_java;

import java.io.File;

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
	
	static void FileSearchAll(String path) {
		File dir = new File(path);
		File[] fList = dir.listFiles();
		
		for (File file : fList) {
			if (file.isDirectory()) {
				FileSearchAll(file.getPath());
			}
			else {
				System.out.println(file.getName());
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
