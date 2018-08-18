package com.gmail.s.granovskiy;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
	/*  The array for permitted file extensions   */
    private String[] arr;
    
    /* constructor class initialization  */
    public MyFileFilter(String ... arr) {
		super();
		this.arr = arr;
	}
	public MyFileFilter() {
		super();
	}

	private boolean check(String ext) {
		for (String stringExt : arr) {
			if (stringExt.equals(ext)) {
			return true;
		    }
		}return false;
	}
    
	@Override
	public boolean accept(File pathname) {
		int pointerIndex = pathname.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
			return false;
		}
		String ext = pathname.getName().substring(pointerIndex + 1);
		return check(ext);
	}
}
