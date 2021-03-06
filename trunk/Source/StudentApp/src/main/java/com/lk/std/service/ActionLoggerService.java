package com.lk.std.service;

import com.lk.std.constant.OLSIMSEnumConstant.Action;

public interface ActionLoggerService {

  void setActionLogger(Action action, long appId, long userId);

  void setActionLogger(Action action, String description, long appId, long userId);

}
