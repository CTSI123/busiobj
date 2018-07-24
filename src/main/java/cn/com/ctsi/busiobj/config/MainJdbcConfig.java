package cn.com.ctsi.busiobj.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ConfigurationProperties(prefix = "jdbc", ignoreUnknownFields = true)
public class MainJdbcConfig extends JdbcConfig implements DisposableBean {
    public MainJdbcConfig() {
    }

    @Bean(
            name = {"dataSource"}
    )
    @Primary
    public DataSource dataSource() {
        this.init();
        return this.dataSource;
    }

    @Bean(
            name = {"jdbcTemplate"}
    )
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource());
    }

    @Bean(
            name = {"namedParameterJdbcTemplate"}
    )
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(this.dataSource());
    }
}
