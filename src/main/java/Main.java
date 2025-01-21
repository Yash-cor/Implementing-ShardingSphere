
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;

import java.sql.*;


public class Main {
    public static void main(String[] args) {


        try {

            Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
            String file_path = "C:\\Users\\yasht\\Apache_Sharding_Sphere\\Implmenting_Sharding_Sphere\\src\\main\\resources\\config33877.yaml";
            File yamlFile = new File(file_path);
            DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ( SELECT bill_no, p_id , user_name FROM t_user_bill ) AS derived_table(col1, col2,col3);");
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