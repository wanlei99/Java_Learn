package com.wl.decorator;

import com.wl.decorator.decorators.*;

import java.io.IOException;

/**
 * @author WL
 * @description: 测试
 * @date 2021/9/10 15:36
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
		FileDataSource fileDataSource = new FileDataSource("out/OutputDemo.txt");
		EncryptionDecorator encryptionDecorator = new EncryptionDecorator(fileDataSource);
		DataSourceDecorator encode = new CompressionDecorator(encryptionDecorator);
		encode.writeData(salaryRecords);
		DataSource plain = new FileDataSource("out/OutputDemo.txt");

		System.out.println("- Input ----------------");
		System.out.println(salaryRecords);
		System.out.println("- Encoded --------------");
		System.out.println(plain.readData());
		System.out.println("- Decoded --------------");
		System.out.println(encode.readData());

	}
}
