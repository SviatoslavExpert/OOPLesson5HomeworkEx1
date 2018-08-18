package com.gmail.s.granovskiy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileOperation {

	public static void copyFile(File in, String out) throws IOException {
		if (in == null || out == null) {
			throw new IllegalArgumentException("Null file pointer");
		}
		try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
			byte[] buffer = new byte[1024 * 1024];
			int readByte = 0;
			for (; (readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
