package com.gmail.s.granovskiy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		/* it creates a stream of class PrintWriter based on standard stream of output: System.out:  */
		PrintWriter pw = new PrintWriter(System.out, true);
		
		/*  Creating 3 files in the source folder  */
		File fileOne = new File("fileOne.docx");
		File fileTwo = new File("fileTwo.docx");
		File fileThree = new File("fileThree.txt");

		try {
			fileOne.createNewFile();
			fileTwo.createNewFile();
			fileThree.createNewFile();
			
		} catch (IOException e) {
			pw.println("ERROR" + e);
		}
		
		/*  Creating a folder NewCatalog  */
		File folderOut = new File("NewCatalog");
		folderOut.mkdirs();
		
		/*  see the state/content of the source folder  */
		File f1 = new File(".");
		if (f1.isDirectory()) {
			String[] filenames = f1.list(); // collection of objects with double values
			for (String filename : filenames) {
				pw.println(filename);
			}
		}
		
		/*  creating the exemplar of the class and giving it the extension "docx"  */
		MyFileFilter mFF = new MyFileFilter("docx");
		
		File folder = new File(".");  //  getting the link to the catalog
		File[] fileList = folder.listFiles(mFF);// the array fileList gets only files with extension "docx"
		
		System.out.println();
		System.out.println("These are the files in the array fileList that meet the criterion: ");
		
		/*  printing the content of the array fileList */
		for (File file : fileList) {
			try {
				FileOperation.copyFile(file, ("NewCatalog/" + file.getName()));
				System.out.println(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pw.close();
	}
}	
		
