package springboot.chapter1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.chapter1.POJO.ProductPo;
import springboot.chapter1.POJO.PurchaseRecordPo;
import springboot.chapter1.dao.ProductDao;
import springboot.chapter1.dao.PurchaseRecordDao;

/**
 * @Author: zkk
 * @Description:
 * @Date: Created in 10:34 2019/7/1
 * @Modified By:
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductDao productDao = null;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;

    @Override
    //启动Spring数据库事务机制
    @Transactional
    public boolean pruchase(Long userId, Long productId, int quantity) {
        //获取产品
        ProductPo product = (ProductPo) productDao.getProduct(productId);
        //比较库存和购买数量
        if (product.getStock() < quantity) {

            //库存不足
            return false;
        }
        //扣减库存
        productDao.decreaseProduct(productId, quantity);
        //初始化购买记录
        PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(pr);
        return true;
    }


    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(
            Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }


}   