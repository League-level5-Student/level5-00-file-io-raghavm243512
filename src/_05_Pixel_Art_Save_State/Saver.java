package _05_Pixel_Art_Save_State;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import _04_Serialization.SaveData;

public class Saver implements Serializable{
	HashMap<String, Pixel> coloredPixels = new HashMap<String, Pixel>();
	private static final String DATA_FILE = "src/_05_Pixel_Art_Save_State/";
	int w, h, r, c;
	public Saver() {
		
	}
	public Saver(int w, int h, int r, int c) {
		this.w=w;
		this.h=h;
		this.r=r;
		this.c=c;
	}
	public void addPixel(String position, Pixel p) {
		coloredPixels.put(position, p);
	}
	public void save(String filename) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE+filename+".dat"));
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Saver load(String file) {
		try (FileInputStream fis = new FileInputStream(new File(file));
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (Saver) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
