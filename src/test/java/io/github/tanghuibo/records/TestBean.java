package io.github.tanghuibo.records;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanghuibo
 * @date 2022/4/3上午2:34
 */
public class TestBean {
    Logger log = LoggerFactory.getLogger(TestBean.class);
    private String name;

    private Integer age;

    public TestBean(String name, Integer age) {
        log.info("使用有参构造方法进行反序列化");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
