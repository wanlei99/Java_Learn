package com.wl.behaviorpattern.cor.middleware;

/**
 * @author WL
 * @description: 检查请求数量限制
 * @date 2021/9/16 15:37
 */
public class ThrottlingMiddleware extends Middleware{

	private int requestPerMinute;
	private int request;
	private long currentTime;

	public ThrottlingMiddleware(int requestPerMinute){
		this.requestPerMinute = requestPerMinute;
		this.currentTime = System.currentTimeMillis();
	}

	/**
	 * 请，不是说checkNext()调用可以插入两个开始的这种方法，并在最后。
	 * 这比在所有中间件上的简单循环提供了更多的灵活性对象。例如，链的一个元素可以改变顺序在所有其他检查之后运行它的检查。
	 * @author wl
	 * @date 2021/9/16 15:40
	 * @param email
	 * @param password
	 * @return boolean
	 */
	@Override
	public boolean check(String email, String password) {
		if (System.currentTimeMillis() > currentTime +60_000){
			request = 0;
			currentTime = System.currentTimeMillis();
		}
		request++;
		if (request > requestPerMinute) {
			System.out.println("Request limit exceed!");
			Thread.currentThread().stop();
		}
		return checkNext(email, password);
	}
}
