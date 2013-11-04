import static java.lang.System.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copier {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub]

		if (args.length != 2) {
			out.println("Usage: < arq1> <arq2>");
			exit(1);
		}

		copyStream(args[0], args[1]);
	}

	private static void copyStream(String arq1, String arq2) throws IOException {

		FileInputStream fin = null;  // lê os bytes.
		FileOutputStream fout = null;
		
		//FileReader       lida com os arquivos character por character
		//FileWriter
		
		try {

			fin = new FileInputStream(arq1); 
			fout = new FileOutputStream(arq2);

			for (int c = fin.read(); c != -1; c = fin.read()) {
				fout.write(c);
			}
		} finally {
			if (fin != null)
				fin.close();
			if (fout != null)
				fout.close();

		}
	}
}
/*
 copyLines (args[0], args[1]);

 copyLines(String arq1, String arq2) throws IOException {
 BufferedReader fin = null;
 PrintWriter fout = null;
 try{
 fin = new BufferedReader(new FileReader(arq1));  
 fout = new PrintWriter(new FileWriter (arq2));
 String l = fin.readerLine();
 While(l!=null){
 fout.println(l); l=fin.readLine();
 } finally{ 
 	if (fin!=null) fin.close();
 	if(fout!=null) fout.close();
 	}
 
 }

*/