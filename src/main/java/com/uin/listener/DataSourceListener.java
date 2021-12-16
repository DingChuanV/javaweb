package com.uin.listener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 *
 */
@WebListener
public class DataSourceListener implements ServletContextListener {

    Logger logger = Logger.getLogger("DataSourceListener");
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        try {
            InitialContext cxt = new InitialContext();
            DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/news");
            sc.setAttribute("datasource",ds);
//            logger.info(ds.toString());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
