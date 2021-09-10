package com.wl.decorator.decorators;

import java.io.*;

/**
 * @author WL
 * @description: 简单数据读取器
 * @date 2021/9/10 15:14
 */
public class FileDataSource implements DataSource {

	private String name;

	public FileDataSource(String name){
		this.name = name;
	}
	@Override
	public void writeData(String data) throws IOException {
		File file = new File(name);
		OutputStream outputStream = new FileOutputStream(file);
		outputStream.write(data.getBytes(),0,data.length());
	}

	@Override
	public String readData() {
		char[] buffer = null;
		File file = new File(name);
		try(FileReader fileReader = new FileReader(file)) {
			buffer = new char[(int) file.length()];
			fileReader.read(buffer);
		}  catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new String(buffer);
	}
}
