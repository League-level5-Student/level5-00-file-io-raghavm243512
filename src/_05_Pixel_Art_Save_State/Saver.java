package _05_Pixel_Art_Save_State;

import java.io.Serializable;
import java.util.ArrayList;

public class Saver implements Serializable{
	ArrayList<String> coloredPixels = new ArrayList<String>();
	int w, h, r, c;
	public Saver(int w, int h, int r, int c) {
		this.w=w;
		this.h=h;
		this.r=r;
		this.c=c;
	}
	public void addPixel(String s) {
		coloredPixels.add(s);
	}
}
