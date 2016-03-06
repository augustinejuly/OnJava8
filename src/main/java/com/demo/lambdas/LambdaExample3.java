package com.demo.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * This example is trying to filter all .xml files. 
 * Also, it demonstrates that lambda does not have it own scope
 */
public class LambdaExample3 {
	
	public static List<File> filterFiles(File [] files, FileFilter filter){
		List<File> fileList = new ArrayList<>();
		for (File file : files) {
			if(filter.accept(file)){
				fileList.add(file);
			}
		}
		return fileList;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int count = 0;

		File [] files = {new File("config.xml"),new File("invoice.txt"),new File("demo.pptx")};
		
		// anonymous inner class
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				int count = 1; 
				//to filter all xml files
				return file.getName().endsWith(".xml");
			}
		};
		System.out.println(filterFiles(files, fileFilter));
		
		// lambda filefilter
		FileFilter xmlFileFilter = (f) -> f.getName().endsWith(".xml");
		
		System.out.println(filterFiles(files,xmlFileFilter));
		
		/*FileFilter xmlFileFilterBlock = (f) -> {
			System.out.println(count);
			// lambda is in the same scope of the enclosing method. 
			//So it will not allow to create a variable which is already existing in the enclosing scope.
			//Try uncomment the below line, there will be an compilation error
			//int count = 1; 
			return f.getName().endsWith(".xml");
		};*/
		
	}

}
