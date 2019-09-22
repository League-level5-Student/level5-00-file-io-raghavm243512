package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter Something");
		try {
			FileWriter fw;
			if (s.length() > 10) {
				fw = new FileWriter(new File("").getAbsolutePath() + "/src/_02_File_Encrypt_Decrypt/"
						+ s.substring(0, 10) + ".txt");
			} else {
				fw = new FileWriter(
						new File("").getAbsolutePath() + "/src/_02_File_Encrypt_Decrypt/" + s + ".txt");
			}
			try {
				fw.write(encrypt(s.getBytes()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(byte[] strClearText) throws Exception {
		return Base64.getEncoder().encodeToString(strClearText);
	}	
}	
