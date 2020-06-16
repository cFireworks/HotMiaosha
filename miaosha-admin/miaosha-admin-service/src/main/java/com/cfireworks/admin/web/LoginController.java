package com.cfireworks.admin.web;

import com.cfireworks.admin.redis.RedisService;
import com.cfireworks.admin.service.MiaoshaUserService;
import com.cfireworks.common.enums.CodeMsg;
import com.cfireworks.common.enums.Result;
import com.cfireworks.common.vo.LoginVo;
import com.cfireworks.common.vo.RegisterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @description: demo
 * @author: cfireworks
 * @create: 2020-04-04 12:33
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginvo){
        log.info(loginvo.toString());
        String passInput = loginvo.getPassword();
        String mobile = loginvo.getMobile();
        // 登录
        CodeMsg cm = userService.login(response, loginvo);
        if(cm.getCode() == 0){
            return Result.success(true);
        }else{
            return Result.error(cm);
        }
    }

    @RequestMapping("/do_register")
    @ResponseBody
    public Result<Boolean> doRegister(@Valid RegisterVo loginvo){
        log.info(loginvo.toString());
        String passInput = loginvo.getPassword();
        String nickName = loginvo.getNickname();
        String mobile = loginvo.getMobile();
        // 登录
        CodeMsg cm = userService.registerUser(Long.parseLong(mobile), nickName, passInput);
        if(cm.getCode() == 0){
            return Result.success(true);
        }else{
            return Result.error(cm);
        }
    }
}
