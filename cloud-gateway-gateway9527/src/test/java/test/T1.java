package test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @Description: 日期生成类
 */
@SpringBootTest
public class T1 {

    @Test
    public void test(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
