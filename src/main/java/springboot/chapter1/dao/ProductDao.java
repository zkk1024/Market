package springboot.chapter1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {
    //获取产品
    public ProductDao getProduct(Long id);

    //减库存，而@Param标明MyBatis参数传递给后台
    public int decreaseProduct (@Param("id") Long id, @Param("quantity") int quantity);


}
