package Utility;
import java.io.*;  
 
public class PostmanRun {
	
	  
 public void runCommand(String commandline)
 {
			String[] command =
			    {
			        "cmd",
			    };
			    Process p;
				try {
					p = Runtime.getRuntime().exec(command);
				        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			                PrintWriter stdin = new PrintWriter(p.getOutputStream());
			                stdin.println(commandline);
	
			                stdin.close();
			                p.waitFor();
			              
			                
			               
			               
			    	} catch (Exception e) {
			 		e.printStackTrace();
				}
	  }
 
 public void writeReport (String value)
 {
 	 try {
          File file = new File("f:\\demo.html");
         
          PrintWriter writer = new PrintWriter(file);
          writer.write(value);
          writer.close();
      } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
 }
 
	}  

