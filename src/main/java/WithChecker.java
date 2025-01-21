import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WithChecker {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
        String file_path = "C:\\Users\\yasht\\Apache_Sharding_Sphere\\Implmenting_Sharding_Sphere\\src\\main\\resources\\config3.yaml";
        File yamlFile = new File(file_path);
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("WITH cte ( ko ) AS (SELECT user_id FROM t_user) SELECT broooh FROM cte");
//        ResultSet rs = st.executeQuery("WITH cte (col1, col2) AS ( SELECT 1 , 2 UNION ALL SELECT 3, 4 ) SELECT col1 , col2 FROM cte;");
//        ResultSet rs = st.executeQuery("WITH cte1 AS (SELECT 1) SELECT * FROM (WITH cte2 AS (SELECT 2) SELECT * FROM cte2 JOIN cte1) AS cte1;");
//        ResultSet rs = st.executeQuery("WITH cte1 AS (SELECT 1) , cte1 AS (SELECT 2) SELECT * FROM cte1;");
//      ResultSet rs = st.executeQuery("with naaam as (select name from t) select * from naaam");
//      ResultSet rs = st.executeQuery("with q as (select * from t_user) select user_id from q");
//      ResultSet rs = st.executeQuery("with t as (select name from t) select * from t");
//      ResultSet rs = st.executeQuery("WITH p AS (SELECT * FROM t)  SELECT id FROM p");
//      ResultSet rs = st.executeQuery("WITH cte AS (SELECT * FROM t_user) SELECT user_id FROM cte");

        while(rs.next())
        {
//            System.out.println(rs.getLong(1) + " " + rs.getString(2));
              System.out.println(rs.getString(1));
        }
    }
}
