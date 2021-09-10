package com.wl.decorator.decorators;

import java.io.IOException;

/**
 * @author WL
 * @description: 定义了读取和写入操作的通用数据接口
 * @date 2021/9/10 15:12
 */
public interface DataSource {
	void writeData(String data) throws IOException;
	String readData() throws IOException;
}
