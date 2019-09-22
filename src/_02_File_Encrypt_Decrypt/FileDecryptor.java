package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JFileChooser;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String s = "";
			String str = br.readLine();
			while (str!=null) {
				s+=str;
				str = br.readLine();
			}
			br.close();
			try {
				System.out.println(decrypt(s.getBytes()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		} else System.exit(0);
	}
	public static String decrypt(byte[] strEncrypted) throws Exception{
		return new String(Base64.getDecoder().decode(strEncrypted));
		
	}
}
