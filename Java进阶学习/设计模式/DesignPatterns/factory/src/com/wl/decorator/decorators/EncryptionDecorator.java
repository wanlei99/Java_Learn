package com.wl.decorator.decorators;

import java.io.IOException;
import java.util.Base64;

/**
 * @author WL
 * @description: 加密装饰
 * @date 2021/9/10 15:38
 */
public class EncryptionDecorator extends DataSourceDecorator{

	public EncryptionDecorator(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public void writeData(String data) throws IOException {
		super.writeData(encode(data));
	}

	@Override
	public String readData() throws IOException {
		return decode(super.readData());
	}

	private String encode(String data){
		byte[] result = data.getBytes();
		for (int i = 0; i < result.length; i++){
			result[i] += (byte) 1;
		}
		return Base64.getEncoder().encodeToString(result);
	}

	private String decode(String data){
		byte[] result = Base64.getDecoder().decode(data);
		for (int i = 0; i < result.length; i++){
			result[i] -= (byte) 1;
		}
		return new String(result);
	}
}
