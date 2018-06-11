package com.digitaladd.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceHandler {
	private DataSource dataSource = null;

    //private static final Logger logger = LoggerService.commonServiceLogger;

    private DataSourceHandler() {
       configureDataSource(DataSources.DEFAULT);
    }
    
    private void configureDataSource(DataSources dataSourceConfig) {
      //  logger.info("configureDataSource > start.");
        Context ctx = null;
        try {
            ctx = new InitialContext();
            this.dataSource = (DataSource) ctx.lookup("java:comp/env/" + dataSourceConfig.toString());
            ctx.close();
        } catch (Exception e) {
          // logger.fatal("configureDataSource > Exception:"+e);
        	System.out.println("DataSourceHandler > configureDataSource() >"+e);
        }
       // logger.info("configureDataSource > end : this.dataSource="+ this.dataSource);
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }

    public static DataSourceHandler getInstance() {
        return DataSourceHandlerHolder.INSTANCE;
    }

    private static class DataSourceHandlerHolder {
       private static final DataSourceHandler INSTANCE = new DataSourceHandler();
    }
}
