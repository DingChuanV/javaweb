package com.uin.util;

import com.alibaba.druid.filter.logging.Log4j2Filter;

/**
 *
 */
public class DruidLogFilter extends Log4j2Filter {


//        // 链接的时候
//        this.setConnectionLogEnabled(false);
//        this.setDataSourceLogEnabled(false);
//        this.setResultSetLogEnabled(false);
//        // SQL格式化
//        this.setStatementSqlPrettyFormat(true);
//        // Slf4jLogFilter中statementLogSqlPrettyFormat属性设置为true
//        this.setStatementExecutableSqlLogEnable(true);
//        // 执行之后
//        this.setStatementExecuteAfterLogEnabled(false);
//        // 执行参数打印
//        this.setStatementParameterSetLogEnabled(false);
//        // 执行之前-准备工作之后
//        this.setStatementPrepareAfterLogEnabled(false);
//        // 执行之前-准备工作之后
//        this.setStatementPrepareCallAfterLogEnabled(false);
//        // 关闭的时候
//        this.setStatementCloseAfterLogEnabled(false);
//        this.setConnectionCloseAfterLogEnabled(false);

    // 执行参数打印

    // 链接的时候
//    @Override
//    public void setDataSourceLogEnabled(boolean dataSourceLogEnabled) {
//        super.setDataSourceLogEnabled(false);
//    }
//
//    @Override
//    public void setConnectionLogEnabled(boolean connectionLogEnabled) {
//        super.setConnectionLogEnabled(false);
//    }
//
//    @Override
//    public void setResultSetLogEnabled(boolean resultSetLogEnabled) {
//        super.setResultSetLogEnabled(false);
//    }
//
//    @Override
//    public void setStatementParameterSetLogEnabled(boolean f) {
//        super.setStatementParameterSetLogEnabled(false);
//    }
//
//    @Override
//    public void setResultSetLogErrorEnabled(boolean resultSetLogErrorEnabled) {
//        super.setResultSetLogErrorEnabled(false);
//    }
//
//    //设置sql格式化
//    @Override
//    public void setStatementSqlPrettyFormat(boolean statementSqlPrettyFormat) {
//        super.setStatementSqlPrettyFormat(true);
//    }

    //输出可执行的SQL
    @Override
    public void setStatementExecutableSqlLogEnable(boolean statementExecutableSqlLogEnable) {
        super.setStatementExecutableSqlLogEnable(true);
    }
}
