package com.whyxian.service;

import com.whyxian.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whyxian
 * @since 2021-12-22
 */
public interface IShopTypeService extends IService<ShopType> {

    List<ShopType> queryList();
}
