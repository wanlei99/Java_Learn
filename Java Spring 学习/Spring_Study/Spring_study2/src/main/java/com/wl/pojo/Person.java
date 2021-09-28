package com.wl.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.17$
 * @Param 注解测试类——person$
 * @return $
 */
public class Person {
    @Nullable
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
