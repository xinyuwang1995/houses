package com.mooc.house.api.controller;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Objects;
import com.google.common.collect.Range;
import com.mooc.house.api.common.ResultMsg;
import com.mooc.house.api.model.User;

public class UserHelper {
  
  public static ResultMsg validateResetPassword(String key, String password, String confirmPassword) {
    if (StringUtils.isBlank(key) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
      return ResultMsg.errorMsg("params error");
    }
    if (!Objects.equal(password, confirmPassword)) {
      return ResultMsg.errorMsg("password must equal confirmpassword");
    }
    return ResultMsg.success();
  }

  public static ResultMsg validate(User account) {
    if (StringUtils.isBlank(account.getEmail())) {
      return ResultMsg.errorMsg("Email error");
    }
    if (StringUtils.isBlank(account.getName())) {
      return ResultMsg.errorMsg("name error");
    }
    if (StringUtils.isBlank(account.getConfirmPasswd()) || StringUtils.isBlank(account.getPasswd()) || !account.getPasswd().equals(account.getConfirmPasswd())) {
      return ResultMsg.errorMsg("password error");
    }
    if (account.getPasswd().length() < 6){
      return ResultMsg.errorMsg("password length less 6");
    }
    if (account.getType() == null || !Range.closed(1, 2).contains(account.getType())){
      return ResultMsg.errorMsg("type error");
    }
    return ResultMsg.success();
  }


}
