package InOutputSream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class IOStream {

	public  static void main(String[] args) throws IOException {
		createFile();
		writteContentinFile();
		coppyFile();
		read();
		
		
  
	}
	public static void  read() throws IOException {
		FileInputStream bin = null;
		try {
			FileInputStream fi = new FileInputStream("D:\\Sky Moon\\Data Test\\dataReadWritteInOutPutStream1.txt");
		//	bin = new FileInputStream(fi);
			while (bin.available()>0) {
				System.out.println((char)bin.read());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void coppyFile(){
		try {
			
			File filea = new File("D:\\Sky Moon\\Data Test\\dat"
					
					+ "aReadWritteInOutPutStream3tocoppy.text");
			filea.createNewFile();
            File fileb = new File("D:\\dataReadWritteInOutPutStream4tocoppy.text");
			fileb.createNewFile();
			
			FileInputStream instream = new FileInputStream(filea);
			FileOutputStream outstream = new FileOutputStream(fileb);
			byte[] buffer = new byte[1024];
			int length;
//			while (length = instream.read(buffer)) {
//				
//				
//			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	};
	public static void writteContentinFile(){
		File file = new File("D:\\Sky Moon\\Data Test\\dataReadWritteInOutPutStream2.txt");
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("this is new content");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	public static void createFile() throws IOException{
		 try {
			   File file = new File("D:\\Sky Moon\\Data Test\\dataReadWritteInOutPutStream1.txt");
			if (file.createNewFile()){
				   System.out.println("file is created");
			   }
			else{
				System.out.println("file already exits");
				
				
				
			};
		} catch (IOException e) {
			System.out.println("Exception when create file");;
		}
		 finally {
			 BufferedReader buffRead = null;
				String scurrentLine;
			 try {
				buffRead = new BufferedReader(new FileReader("D:\\Sky Moon\\Data Test\\dataReadWritteInOutPutStream.txt"));
				while ((scurrentLine = buffRead.readLine()) != null) {
					System.out.println("not null");
					System.out.println(scurrentLine);
					
			
		};
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	};

	}
}
	
