## Mybatis学习
### 首先导入依赖文件
数据库链接依赖
```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.25</version>
        </dependency>
```
mybatis依赖
```xml
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
```
#### 在builder中配置resources，来防止我们资源导入失败的问题。
```xml
<!--在builder中配置resources，来防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```
#### 添加xml配置文件（mybatis-config.xml）
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;allowPublicKeyRetrieval=true&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value=""/>
            </dataSource>
        </environment>
    </environments>
    <!--映射的配置文件（接口中的方法具体的实现）-->
    <mappers>
        <mapper resource="com/wl/dao/UserDaoMapper.xml"/>
    </mappers>
</configuration>
```
#### 创建MybatisUtils类，来获取SqlSession对象
```java
package com.wl.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WL
 * @description: mybatis的工具类——从 SqlSessionFactory 中获取 SqlSession
 * @date 2021/9/8 11:18
 */
public class MybatisUtil{
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			//获取mybatis配置文件
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
}
```
#### 其它的代码
- 实体类
```java
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
```
- dao(UserDao)
```java
package com.wl.dao;

import com.wl.pojo.User;

import java.util.List;

/**
 * user 持久层
 * @author 98710
 */
public interface UserDao {
	List<User> getUserList();
}
```
- UserDao中的方法实现(UserDaoMapper.xml)
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace 是实现方法的接口；id是实现方法的方法名；resultType是返回值的类型-->
<mapper namespace="com.wl.dao.UserDao">
    <select id="getUserList" resultType="com.wl.pojo.User">
        select * from user
    </select>
</mapper>
```  
- 测试
```java
package com.wl.dao;
import com.wl.pojo.User;
import com.wl.utils.MybatisUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoTest extends TestCase {

	public void testGetUserList(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> userList = userDao.getUserList();
		for (User user : userList) {
			System.out.println(user.toString());
		}
		sqlSession.close();
	}
}
```