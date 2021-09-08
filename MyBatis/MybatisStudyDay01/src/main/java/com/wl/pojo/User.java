package com.wl.pojo;

import lombok.*;

/**
 * @author WL
 * @description: user实体类
 * @date 2021/9/8 11:24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private int id;
	private String name;
	private String pwd;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
