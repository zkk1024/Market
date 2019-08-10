package springboot.chapter1.service;

public interface PurchaseService {
    /**
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 购买数量
     * @return 成功 or 失败
     */
    public boolean pruchase(Long userId, Long productId, int quantity);
}
