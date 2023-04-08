package com.kt.di.ex2;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String fileName;
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(fileName);
		out.write(message);
		out.close();
	}
}
