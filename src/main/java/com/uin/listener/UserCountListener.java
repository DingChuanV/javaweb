package com.uin.listener; /**
 *
 */

import com.uin.util.Constant;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.logging.Logger;

@WebListener
public class UserCountListener implements HttpSessionBindingListener {
    Logger log = Logger.getLogger("UserCountListener");

    public UserCountListener() {
    }


    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        Constant.ONLINE_USER_COUNT++;
        log.info("用户数量加1");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        Constant.ONLINE_USER_COUNT--;
        log.info("用户数量减1");
    }
}
