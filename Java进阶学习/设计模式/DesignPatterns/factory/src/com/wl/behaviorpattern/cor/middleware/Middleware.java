package com.wl.behaviorpattern.cor.middleware;

/**
 * @author WL
 * @description: 基础认证接口
 * @date 2021/9/16 15:28
 */
public abstract class Middleware {
	private Middleware next;

	/**
	 * 构建中间件对象链。
	 * @author wl
	 * @date 2021/9/16 15:34
	 * @param next
	 * @return Middleware
	 */
	public Middleware linkWith(Middleware next){
		this.next = next;
		return next;
	}

	/**
	 * 子类将通过具体的检查实现这个方法
	 * @author wl
	 * @date 2021/9/16 15:33
	 * @param email 邮件
	 * @param password 密码
	 * @return boolean 返回值
	 */
	public abstract boolean check(String email , String password);

	/**
	 *运行链中下一个对象的检查，如果我们在链中，则结束遍历链中的最后一个对象。
	 * @author wl
	 * @date 2021/9/16 15:36
	 * @param email 邮箱
	 * @param password 密码
	 * @return boolean 返回值
	 */
	protected boolean checkNext(String email, String password){
		if (next == null){
			return true;
		}
		return next.checkNext(email, password);
	}

}
