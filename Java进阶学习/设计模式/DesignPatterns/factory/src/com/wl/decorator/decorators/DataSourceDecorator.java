package com.wl.decorator.decorators;

import java.io.IOException;

/**
 * @author WL
 * @description: 抽象基础装饰
 * @date 2021/9/10 15:24
 */
public class DataSourceDecorator implements DataSource {

	private DataSource dataSource;

	DataSourceDecorator(DataSource dataSource){
		this.dataSource = dataSource;
	}
	@Override
	public void writeData(String data) throws IOException {
		dataSource.writeData(data);
	}

	@Override
	public String readData() throws IOException {
		return dataSource.readData();
	}
}
