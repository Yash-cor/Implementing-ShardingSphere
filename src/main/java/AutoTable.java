


import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;

import java.sql.*;


public class AutoTable {
    public static void main(String[] args) {


        try {

            Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
            String file_path = "C:\\Users\\yasht\\Apache_Sharding_Sphere\\Implmenting_Sharding_Sphere\\src\\main\\resources\\config.yaml";
            File yamlFile = new File(file_path);
            DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
            Connection con = dataSource.getConnection();
            PreparedStatement st = con.prepareStatement("select * from t");
            ResultSet rs = st.executeQuery();
//            int it = st.executeUpdate();
//            st.executeUpdate("insert into t(name) values('YASH');");

            while(rs.next())
            {
                System.out.println(rs.getLong(1) + " " + rs.getString(2));
            }
        }
        catch(ClassNotFoundException | SQLException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}