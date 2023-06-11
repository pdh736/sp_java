package sp_java;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import sp_java.json.JsonWrapper;
import sp_java.json.Student;

public class Main {

	public static void main(String[] args) {
		JsonWrapper<Student> jw = new JsonWrapper<Student>() {};
		
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine(); //next는 공백으로도 끊음
		
		
		Path currentPath = Paths.get("");
        String absolutepath = currentPath.toAbsolutePath().toString();
        System.out.println("현재 작업 경로: " + absolutepath);
	
	}
}
