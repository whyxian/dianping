package com.whyxian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whyxian.dto.LoginFormDTO;
import com.whyxian.dto.Result;
import com.whyxian.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whyxian
 * @since 2021-12-22
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result logout(HttpServletRequest request);

    Result sign();

    Result signCount();
}
