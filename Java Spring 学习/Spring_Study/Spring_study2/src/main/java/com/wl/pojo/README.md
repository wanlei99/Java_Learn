### 依赖注入
1. 复杂类型
```java
package com.wl.pojo;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.16$
 * @Param 地址类$
 * @return $
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
```
测试对象
```java
package com.wl.pojo;

import java.util.*;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.12$
 * @Param Student类$
 * @return $
 */
public class Student {
    private String name;
    private String[] books;
    private Address address;
    private List<String> hobbies;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                ", address=" + address +
                ", hobbies=" + hobbies +
                ", card=" + card +
                ", games=" + games +
                ", wife='" + wife + '\'' +
                ", info=" + info +
                '}';
    }
}
```
beans.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <bean id="Student" class="com.wl.pojo.Student">
        <!--值的注入-->
        <property name="name" value="琴江"/>
        <!--字符数组注入-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>水浒传</value>
                <value>西游记</value>
                <value>三国演义</value>
            </array>
        </property>
        <!--List-->
        <property name="hobbies">
            <list>
                <value>打篮球</value>
                <value>看电影</value>
                <value>打游戏</value>
            </list>
        </property>
        <!--map-->
        <property name="card">
            <map>
                <entry key="身份证" value="32038210009283838"></entry>
                <entry key="银行卡" value="1212112412421412412"></entry>
            </map>
        </property>
        <!--set-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>
        <!--null-->
        <property name="wife">
            <null/>
        </property>
        <!--properties-->
        <property name="info">
            <props>
                <prop key="driver">2312312131</prop>
                <prop key="url">www.baidu.com</prop>
                <prop key="user">admin</prop>
                <prop key="password">1qaz</prop>
            </props>
        </property>
        <property name="address" ref="Address"></property>
    </bean>
    <bean id="Address" class="com.wl.pojo.Address">
        <property name="address" value="南京"></property>
    </bean>
</beans>
```
MyTest
```java
import com.wl.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.16$
 * @Param beans注入$
 * @return $
 */
public class MyTest {
    private static Student student;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        student =(Student) context.getBean("Student");
        System.out.println(student.toString());
        /**
         * 最终输出值
         * Student{
         * name='琴江',
         * books=[红楼梦, 水浒传, 西游记, 三国演义],
         * address=Address{address='南京'},
         * hobbies=[打篮球, 看电影, 打游戏],
         * card={
         *  身份证=32038210009283838,
         *  银行卡=1212112412421412412
         * },
         * games=[LOL, COC, BOB],
         * wife='null',
         * info={user=admin, password=1qaz, url=www.baidu.com, driver=2312312131}}
         */
    }
}

```