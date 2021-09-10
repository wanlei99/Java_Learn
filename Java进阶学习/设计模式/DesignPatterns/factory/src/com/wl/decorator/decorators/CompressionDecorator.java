package com.wl.decorator.decorators;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author WL
 * @description: 压缩装饰
 * @date 2021/9/10 15:45
 */
public class CompressionDecorator extends DataSourceDecorator {

	private int compLevel = 6;

	public CompressionDecorator(DataSource dataSource) {
		super(dataSource);
	}

	public int getCompLevel(){
		return compLevel;
	}

	public void setCompLevel(int value){
		this.compLevel = value;
	}

	@Override
	public void writeData(String data) throws IOException {
		super.writeData(compress(data));
	}

	@Override
	public String readData() throws IOException {
		return decompress(super.readData());
	}

	private String compress(String stringData) throws IOException {
		byte[] data = stringData.getBytes();
		ByteOutputStream byteOutputStream = new ByteOutputStream(512);
		DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteOutputStream,new Deflater(compLevel));
		deflaterOutputStream.write(data);
		deflaterOutputStream.close();
		byteOutputStream.close();
		return Base64.getEncoder().encodeToString(byteOutputStream.getBytes());
	}

	private String decompress(String stringData) throws IOException {
		byte[] data = Base64.getDecoder().decode(stringData);
		InputStream inputStream = new ByteArrayInputStream(data);
		InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
		int b;
		while (((b) = inflaterInputStream.read())!=-1){
			byteArrayOutputStream.write(b);
		}
		inputStream.close();
		inflaterInputStream.close();
		byteArrayOutputStream.close();
		return new String(byteArrayOutputStream.toByteArray());
	}
}
