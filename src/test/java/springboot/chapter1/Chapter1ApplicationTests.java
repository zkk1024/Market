package springboot.chapter1;


import org.apache.tomcat.jni.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.chapter1.service.PurchaseService;

@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter1ApplicationTests {

    //注入用户服务类
    @Autowired
    private PurchaseService purchaseService = null;

    @Test
    public void contextLoads() {
        Class<? extends PurchaseService> user = purchaseService.getClass();
        //判断用户信息是否为空
        Assert.assertNotNull(user);
    }
    //REST测试模板，Spring Boot 自动提供
    @Autowired
    private TestRestTemplate restTemplate = null;

    //测试获取用户功能
    public void testGetUser() {
        User user = this.restTemplate.getForObject("/user/{id}", User.class, 1L);
        Assert.assertNotNull(user);
    }

 //   @MockBean
//    private PurchaseService purchaseService = null;
//    @Test
//    public void testGetProduct() {
//        //构建虚拟对象
//        Product mockProduct = new Product();
//        mockProduct.setId(1L);
//        mockProduct.setProductName("product_name_" + 1);
//        mockProduct.setNote("note_" +1);
//        //指定 Mock Bean 方法和参数
//        BDDMockito.given(this.productService.getProduct(1L));
//        Assert.assertTrue(Product.getId() == 1L);
//    }
}
