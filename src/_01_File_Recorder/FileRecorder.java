package _01_File_Recorder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String s=JOptionPane.showInputDialog("Enter Something");
		try {
			FileWriter fw = new FileWriter(new File("").getAbsolutePath()+"/src/_01_File_Recorder/" + s + ".txt");
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
