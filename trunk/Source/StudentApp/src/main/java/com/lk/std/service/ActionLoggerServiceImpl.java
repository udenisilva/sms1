package com.lk.std.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.dao.ActionLoggerRepository;

import com.lk.std.model.ActionLogger;

@Service
@Transactional
public class ActionLoggerServiceImpl implements ActionLoggerService {

  @Autowired
  ActionLoggerRepository repository;

  @Override
  public void setActionLogger(Action action, long appId, long userId) {
    ActionLogger actionLogger = new ActionLogger();
    actionLogger.setAction(action);
    actionLogger.setAppId(appId);
    actionLogger.setUser(userId);
    actionLogger.setOccuredDateTime(new Date());

    repository.save(actionLogger);
  }

  @Override
  public void setActionLogger(Action action, String description, long appId, long userId) {
    ActionLogger actionLogger = new ActionLogger();
    actionLogger.setAction(action);
    actionLogger.setDescription(description);
    actionLogger.setAppId(appId);
    actionLogger.setUser(userId);
    actionLogger.setOccuredDateTime(new Date());

    repository.save(actionLogger);
  }

}
