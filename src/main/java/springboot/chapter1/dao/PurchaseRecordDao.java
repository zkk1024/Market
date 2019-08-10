package springboot.chapter1.dao;

import org.apache.ibatis.annotations.Mapper;
import springboot.chapter1.POJO.PurchaseRecordPo;

@Mapper
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}
