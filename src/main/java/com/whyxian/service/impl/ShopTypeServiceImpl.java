package com.whyxian.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.whyxian.entity.ShopType;
import com.whyxian.mapper.ShopTypeMapper;
import com.whyxian.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whyxian.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whyxian
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<ShopType> queryList() {
        //1.查询redis缓存
        String shopTypeList = stringRedisTemplate.opsForValue().get(RedisConstants.CACHE_SHOP_TYPE_LIST_KEY);
        //2.存在,直接返回
        if (StrUtil.isNotBlank(shopTypeList)){
            List<ShopType> typeList = JSONUtil.toList(shopTypeList, ShopType.class);
            return typeList;
        }
        //3.不存在,查询数据库
        List<ShopType> typeList = query().orderByAsc("sort").list();
        //4.存入redis
        stringRedisTemplate.opsForValue().set(RedisConstants.CACHE_SHOP_TYPE_LIST_KEY, JSONUtil.toJsonStr(typeList));
        //5.返回结果
        return typeList;
    }
}
