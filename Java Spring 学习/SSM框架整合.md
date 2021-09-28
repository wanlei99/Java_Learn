## SSM框架整合

### 基本环境搭建

1. 新建一个maven项目

2. 导入相关的pom依赖

   ```xml
   <dependencies>
           <!--Junit-->
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.12</version>
           </dependency>
           <!--数据库驱动-->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>5.1.47</version>
           </dependency>
           <!-- 数据库连接池 -->
           <dependency>
               <groupId>com.mchange</groupId>
               <artifactId>c3p0</artifactId>
               <version>0.9.5.2</version>
           </dependency>
   
           <!--Servlet - JSP -->
           <dependency>
               <groupId>javax.servlet</groupId>
               <artifactId>servlet-api</artifactId>
               <version>2.5</version>
           </dependency>
           <dependency>
               <groupId>javax.servlet.jsp</groupId>
               <artifactId>jsp-api</artifactId>
               <version>2.2</version>
           </dependency>
           <dependency>
               <groupId>javax.servlet</groupId>
               <artifactId>jstl</artifactId>
               <version>1.2</version>
           </dependency>
   
           <!--Mybatis-->
           <dependency>
               <groupId>org.mybatis</groupId>
               <artifactId>mybatis</artifactId>
               <version>3.5.2</version>
           </dependency>
           <dependency>
               <groupId>org.mybatis</groupId>
               <artifactId>mybatis-spring</artifactId>
               <version>2.0.2</version>
           </dependency>
   
           <!--Spring-->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-webmvc</artifactId>
               <version>5.1.9.RELEASE</version>
           </dependency>
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-jdbc</artifactId>
               <version>5.1.9.RELEASE</version>
           </dependency>
           <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
           <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <version>1.18.20</version>
               <scope>provided</scope>
           </dependency>
       </dependencies>
   ```

   ```xml
   <!--maven 资源过滤-->
       <build>
           <resources>
               <resource>
                   <directory>src/main/java</directory>
                   <includes>
                       <include>**/*.properties</include>
                       <include>**/*.xml</include>
                   </includes>
                   <filtering>false</filtering>
               </resource>
               <resource>
                   <directory>src/main/resources</directory>
                   <includes>
                       <include>**/*.properties</include>
                       <include>**/*.xml</include>
                   </includes>
                   <filtering>false</filtering>
               </resource>
           </resources>
       </build>
   ```

3. 建立基本结构和配置框架

   - com.wl(java软件包下的文件包)
     - controller
     - dao
     - pojo
     - service

   - resources

     - applicationContext.xml(整合所有的配置文件)

       ```xml
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd">
       
           <import resource="classpath:spring-dao.xml"/>
           <import resource="classpath:spring-service.xml"/>
           <import resource="classpath:spring-mvc.xml"/>
       
       </beans>
       ```

       

     - mybatis-config.xml(数据库核心配置文件)

       ```xml
       <?xml version="1.0" encoding="UTF-8" ?>
       <!DOCTYPE configuration
               PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
               "http://mybatis.org/dtd/mybatis-3-config.dtd">
       <configuration>
       
           <typeAliases>
               <package name="com.wl.pojo"/>
           </typeAliases>
           <!--加载数据库操作文件-->
           <mappers>
               <mapper resource="com.wl.dao.BookMapper"/>
           </mappers>
       </configuration>
       ```

       

     - database.properties(数据库配置文件)

       ```properties
       jdbc.driver=com.mysql.jdbc.Driver
       jdbc.url=jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
       jdbc.username=root
       jdbc.password=
       ```

       

     - spring-dao.xml(整合Mybatis)

       ```xml
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xmlns:context="http://www.springframework.org/schema/context"
              xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd
               http://www.springframework.org/schema/context
               https://www.springframework.org/schema/context/spring-context.xsd">
       
           <!-- 配置整合mybatis -->
           <!-- 1.关联数据库文件 -->
           <context:property-placeholder location="classpath:database.properties"/>
       
           <!-- 2.数据库连接池 -->
           <!--数据库连接池
               dbcp  半自动化操作  不能自动连接
               c3p0  自动化操作（自动的加载配置文件 并且设置到对象里面）
           -->
           <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
               <!-- 配置连接池属性 -->
               <property name="driverClass" value="${jdbc.driver}"/>
               <property name="jdbcUrl" value="${jdbc.url}"/>
               <property name="user" value="${jdbc.username}"/>
               <property name="password" value="${jdbc.password}"/>
               <!-- c3p0连接池的私有属性 -->
               <property name="maxPoolSize" value="30"/>
               <property name="minPoolSize" value="10"/>
               <!-- 关闭连接后不自动commit -->
               <property name="autoCommitOnClose" value="false"/>
               <!-- 获取连接超时时间 -->
               <property name="checkoutTimeout" value="10000"/>
               <!-- 当获取连接失败重试次数 -->
               <property name="acquireRetryAttempts" value="2"/>
           </bean>
           <!-- 3.配置SqlSessionFactory对象 -->
           <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
               <!-- 注入数据库连接池 -->
               <property name="dataSource" ref="dataSource"/>
               <!-- 配置MyBaties全局配置文件:mybatis-config.xml -->
               <property name="configLocation" value="classpath:mybatis-config.xml"/>
           </bean>
           <!-- 4.配置扫描Dao接口包，动态实现Dao接口注入到spring容器中 -->
           <!--解释 ：https://www.cnblogs.com/jpfss/p/7799806.html-->
           <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
               <!-- 注入sqlSessionFactory -->
               <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
               <!-- 给出需要扫描Dao接口包 -->
               <property name="basePackage" value="com.wl.dao"/>
           </bean>
       </beans>
       ```

       

     - spring-service.xml

       ```xml
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xmlns:context="http://www.springframework.org/schema/context"
              xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd
               http://www.springframework.org/schema/context
               https://www.springframework.org/schema/context/spring-context.xsd">
       
           <!-- 扫描service相关的bean -->
           <context:component-scan base-package="com.wl.service" />
       
           <!--BookServiceImpl注入到IOC容器中-->
           <bean id="BookServiceImpl" class="com.wl.service.BookServiceImpl">
               <property name="mapper" ref="bookMapper"/>
           </bean>
           <!-- 配置事务管理器 -->
           <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
               <!-- 注入数据库连接池 -->
               <property name="dataSource" ref="dataSource" />
           </bean>
       
       </beans>
       ```

     - spring-mvc.xml(springMVC相关配置)

       ```xml
       <?xml version="1.0" encoding="UTF-8"?>
       <beans xmlns="http://www.springframework.org/schema/beans"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xmlns:mvc="http://www.springframework.org/schema/mvc"
              xmlns:context="http://www.springframework.org/schema/context"
              xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd
               http://www.springframework.org/schema/mvc
               http://www.springframework.org/schema/cache/spring-mvc.xsd">
           <!--注解驱动-->
           <mvc:annotation-driven/>
           <!--静态资源过滤-->
           <mvc:default-servlet-handler/>
           <!--扫描包:controller-->
           <context:component-scan base-package="com.wl.controller"/>
           <!--视图解析器-->
           <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
               <property name="prefix" value="/WEB-INF/jsp/"/>
               <property name="suffix" value=".jsp"/>
           </bean>
       </beans>
       ```

4. 添加项目框架支持（添加web框架支持）

5. 配置web.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0">
       <servlet>
           <servlet-name>springmvc</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:applicationContext.xml</param-value>
           </init-param>
       </servlet>
       <servlet-mapping>
           <servlet-name>springmvc</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
       <!--乱码过滤-->
       <filter>
           <filter-name>ecodingFilter</filter-name>
           <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
           <init-param>
               <param-name>encoding</param-name>
               <param-value>utf-8</param-value>
           </init-param>
       </filter>
       <filter-mapping>
           <filter-name>ecodingFilter</filter-name>
           <url-pattern>/*</url-pattern>
       </filter-mapping>
       <!--Session-->
       <session-config>
           <session-timeout>15</session-timeout>
       </session-config>
   </web-app>
   ```

6. 在WEB-INF文件夹下新建一个jsp文件夹

7. 备注

   关于mapper的xml配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--对应的接口文件-->
   <mapper namespace="com.wl.dao.BookMapper">
       <!--sql语句编写区域-->
   </mapper>
   ```

   