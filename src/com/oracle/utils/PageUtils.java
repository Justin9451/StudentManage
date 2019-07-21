package com.oracle.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageUtils {
	public static void readPage(PrintWriter pw, InputStream pagePath, Map<String, String> paramMap) throws IOException {
		List<String> lines = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(pagePath));
		String line = null;
		while((line = br.readLine()) != null) {
			lines.add(line);
		}
		br.close();
		
		lines = new ArrayList<>(lines);
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).contains("param")) {  
				Set<String> keySet = paramMap.keySet();
				for (String key : keySet) { 
					String value = paramMap.get(key);
					String newLine = lines.get(i).replaceAll(key, value);
					lines.set(i, newLine);
				}
			}
		}
		
		for (String str : lines) {
			pw.write(str);
		}
		
		pw.flush();
		
	}
	
}
