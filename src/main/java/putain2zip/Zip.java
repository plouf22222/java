package putain2zip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Enumeration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class Zip {
	
	public static void main(String[] args) throws IOException, FileNotFoundException, ArchiveException{
		System.out.println("Coucou");
		//InputStream fichier = new FileInputStream("D:\\Temp\\542097902FEC201507A.zip");
		String fichier = "D:\\Temp\\542097902FEC201507A.zip";
		String fec = "D:\\Temp\\54209790FEC201507A.txt";
		File f = new File(fec);
		FileReader fr = new FileReader(f);
		BufferedReader br  = new BufferedReader(fr);
		String s = null;
		int cptt = 0;
		while ((br.readLine())!=null) {

		// Do whatever u want to do with the content of the file.
			if (cptt == 14714953) {
				System.out.println(br.readLine());
				System.out.println(br.readLine());
				System.out.println(br.readLine());
				System.out.println(br.readLine());
				System.out.println(br.readLine());
			}
			cptt += 1;
			

		}
		System.out.println(cptt);
		br.close();
		
		
		
		ZipFile a = new ZipFile(fichier);
		System.out.println(a.getEncoding());
		Enumeration<ZipArchiveEntry> t = a.getEntries();
		ZipArchiveEntry b = t.nextElement();
		System.out.println(b.getName());
		System.out.println(b.isStreamContiguous());
		System.out.println(b.getMethod());
		//InputStream input = a.getInputStream(b);
		InputStreamReader input = new InputStreamReader(a.getInputStream(b));
		BufferedReader in = new BufferedReader(input);
		String header = in.readLine();
		System.out.println(header);
		String ligne = "";
		int cpt = 0;
		try {
			while ((ligne = in.readLine()) != null) {
				cpt += 1;
				if ((cpt % 1000000) == 0) {
					System.out.println(cpt);
				}
				}
		}
		catch (Exception e) {
			
				System.out.println(ligne);
				System.out.println("Error a la con");
			
		}

		System.out.print("nombre de lignes = ");
		System.out.print(cpt);
		/*
		System.out.println((char)input.read());
		System.out.println((char)input.read());
		System.out.println((char)input.read());
		System.out.println((char)input.read());
		System.out.println((char)input.read());
		*/


		
		
		/*
		ZipArchiveInputStream a = new ZipArchiveInputStream(fichier, "test.txt");
		System.out.println(a.read());
		byte[] buf = new byte[20];
		a.read(buf, 0, 20);
		System.out.println(buf.toString());
		*/
	}

}
