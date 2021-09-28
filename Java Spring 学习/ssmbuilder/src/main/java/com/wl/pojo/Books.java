package com.wl.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WL
 * @description: Book实体类
 * @date 2021/9/23 16:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Books {
	private int bookID;
	private String bookName;
	private int bookCounts;
	private String detail;
}
