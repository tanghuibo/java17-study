package io.github.tanghuibo.records;

/**
 * @author tanghuibo
 * @date 2022/4/3上午1:01
 */
public record TestRecord(String name, Integer age) {


}

//public class TestRecord {
//    private String name;
//
//    private Integer age;
//
//    public TestRecord() {
//        System.out.println("init");
//    }
//
//    public TestRecord(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//}