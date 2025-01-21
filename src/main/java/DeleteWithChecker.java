import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteWithChecker {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
        String file_path = "C:\\Users\\yasht\\Apache_Sharding_Sphere\\Implmenting_Sharding_Sphere\\src\\main\\resources\\config3.yaml";
        File yamlFile = new File(file_path);
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();

//        ResultSet rs = st.executeQuery("WITH cte AS ( SELECT id FROM t) UPDATE t SET t.id = cte.id WHERE t.id = cte.id");
//        ResultSet rs = st.executeQuery("WITH cte AS ( SELECT id FROM t) UPDATE t JOIN cte ON t.id = cte.id SET t.id = cte.id;");
         int i = st.executeUpdate("WITH cte ( a ) AS  ( SELECT user_id FROM t_user ) UPDATE t_user JOIN cte ON t_user.user_id = cte.a SET t_user.name = \"YASH\";;");
        System.out.println(i);

//        while(rs.next())
//        {
////            System.out.println(rs.getLong(1) + " " + rs.getString(2));
//            System.out.println(rs.getString(1));
//        }
    }


}
