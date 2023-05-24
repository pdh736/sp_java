package sp_java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProcessExample {
	static String getProcessOutput(List<String> cmdList) 
			throws IOException, InterruptedException{
		
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		Process process = builder.start();
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return (new String(buffer));
	}
	//String output = ProcessExample.getProcessOutput(Arrays.asList("processname", "arg1", "arg2")); 형태로 사용
}