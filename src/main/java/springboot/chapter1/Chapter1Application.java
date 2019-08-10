package springboot.chapter1;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//定义扫描包
@SpringBootApplication(scanBasePackages = "springboot.chapter1")
//定义扫描MyBatis接口
@MapperScan(annotationClass = Mapper.class, basePackages = "src.main.resources")
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
