package top.dpdaidai.basis.jdbc.pool.c3p0;

import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 手动配置c3p0参数
 * @Author chenpantao
 * @Date 4/13/21 4:57 PM
 * @Version 1.0
 */
public class C3P0Test3 {

    public static void main(String[] args) throws Exception {

        DataSource ds_unpooled = DataSources.unpooledDataSource("jdbc:mysql://localhost:3306/mashibing",
                "root",
                "123456");
//        DataSource ds_pooled = DataSources.pooledDataSource( ds_unpooled );
        Map overrides = new HashMap();
        overrides.put("maxStatements", "200");         //Stringified property values work
        overrides.put("maxPoolSize", new Integer(50)); //"boxed primitives" also work
        DataSource ds_pooled = DataSources.pooledDataSource(ds_unpooled, overrides);
        Connection connection = ds_pooled.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
