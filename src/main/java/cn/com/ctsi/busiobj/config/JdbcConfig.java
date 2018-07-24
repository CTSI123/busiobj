package cn.com.ctsi.busiobj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.DisposableBean;

public class JdbcConfig implements DisposableBean {
    protected DruidDataSource dataSource;
    private String url;
    private String user;
    private String password;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
    private Integer minEvictableIdleTimeMillis;

    public JdbcConfig() {
    }

    protected void init() {
        this.dataSource = new DruidDataSource();
        this.dataSource.setUrl(this.url);
        this.dataSource.setUsername(this.user);
        this.dataSource.setPassword(this.password);
        this.dataSource.setInitialSize(this.initialSize.intValue());
        this.dataSource.setMinIdle(this.minIdle.intValue());
        this.dataSource.setMaxActive(this.maxActive.intValue());
        this.dataSource.setMaxWait((long)this.maxWait.intValue());
        this.dataSource.setMinEvictableIdleTimeMillis((long)this.minEvictableIdleTimeMillis.intValue());
        this.dataSource.setTimeBetweenEvictionRunsMillis(60000L);
        this.dataSource.setValidationQuery("SELECT 'x'");
        this.dataSource.setTestWhileIdle(true);
        this.dataSource.setTestOnBorrow(false);
        this.dataSource.setTestOnReturn(false);
        this.dataSource.setPoolPreparedStatements(true);
        this.dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
    }

    public void destroy() throws Exception {
        if (this.dataSource != null) {
            this.dataSource.close();
        }

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
}
