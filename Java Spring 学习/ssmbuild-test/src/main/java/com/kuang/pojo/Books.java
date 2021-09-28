package com.kuang.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author WL
 * @description:
 * @date 2021/9/24 13:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
	private int bookID;
	private String bookName;
	private int bookCounts;
	private String detail;

}
