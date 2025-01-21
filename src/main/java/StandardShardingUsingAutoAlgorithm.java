
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;

import java.sql.*;
import java.util.Calendar;


public class StandardShardingUsingAutoAlgorithm {

    private static int run()
    {
        try {

            Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
            String file_path = "C:\\Users\\yasht\\Apache_Sharding_Sphere\\Implmenting_Sharding_Sphere\\src\\main\\resources\\config2.yaml";
            File yamlFile = new File(file_path);
            DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();

//            st.executeUpdate("insert into t(name) values('YASH');");
//            ResultSet rs = st.executeQuery("select * from t where ID in(1075813019612610560 , 1075813047345348608);");
            ResultSet rs = st.executeQuery("SELECT * from t_logic where ID%2 = 0");
            int c = 0;

            while(rs.next())
            {
                c++;
                System.out.println(rs.getString(1) + " " + rs.getString(2));
//                    System.out.println(rs.getString(1));
            }
            return c;
        }
        catch(ClassNotFoundException | SQLException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }

    public static void main(String[] args) {


        System.out.println(run());

    }
}