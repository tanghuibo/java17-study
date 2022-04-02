package io.github.tanghuibo.records;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanghuibo
 * @date 2022/4/3上午1:05
 */
public class TestRecodesTest {

    static Logger log = LoggerFactory.getLogger(TestRecodesTest.class);

    @Test
    public void test() throws JsonProcessingException {

        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();

        // 基本用法
        TestRecord testRecord = new TestRecord("张三", 13);
        // 不需要 getXXX， 直接使用属性名同名方法获取属性
        log.info("data: {}, data.name: {}, data.age: {}, class: {}", testRecord, testRecord.name(), testRecord.age(), testRecord.getClass());
        // fastjson 不支持 record 的序列化
        log.info("fastjson data: {} class: {}", JSON.toJSONString(testRecord), testRecord.getClass());
        // gson 支持 record 序列化
        log.info("gson data: {} class: {}", gson.toJson(testRecord), testRecord.getClass());
        //jackson 支持 record 序列化
        log.info("jackson data: {} class: {}", objectMapper.writeValueAsString(testRecord), testRecord.getClass());



        // 没有无参构造器就默认使用参数最长的构造器进行反序列化
        testRecord = JSON.parseObject("""
                {"name": "李四", "age": 14}
                """, TestRecord.class);
        log.info("data: {} class: {}", testRecord, testRecord.getClass());

//        Gson 不支持 record
//        Gson gson = new Gson();
//        testRecodes = gson.fromJson("""
//                {"name": "王五", "age": 15}
//                """, TestRecodes.class);
//        log.info("data: {} class: {}", testRecodes, testRecodes.getClass());

        // 单独对 record 支持
        testRecord = objectMapper.readValue("""
                {"name": "赵六", "age": 16}
                """, TestRecord.class);
        log.info("data: {} class: {}", testRecord, testRecord.getClass());

        // 没有无参构造器就使用 unsafe 方法创建对象进行反序列化
        TestBean testBean = gson.fromJson("""
                {"name": "孙八", "age": 18}
                """, TestBean.class);
        log.info("data: {} class: {}", testBean, testBean.getClass());

//        jackson 必须要求有无参构造器(record除外)
//        TestBean testBean = objectMapper.readValue("""
//            {"name": "李九", "age": 19}
//            """, TestBean.class);
//        log.info("data: {} class: {}",testBean,testBean.getClass());
    }
//
}