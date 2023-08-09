package com.whyxian.service;

import com.whyxian.dto.Result;
import com.whyxian.entity.VoucherOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whyxian
 * @since 2021-12-22
 */
public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result seckillVoucher(Long voucherId);

    @Transactional(rollbackFor = Exception.class)
    void createVoucherOrder(VoucherOrder voucherOrder);
}
