package cn.itcast.mybatisDemo.mybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by hpx on 2018/1/31.
 */
public class MyBatisUtils {
    private static SqlSessionFactory factory = null;

    static {
        init();
    }

    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("MyBatisCofig.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            factory = factoryBuilder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        SqlSession session = null;
        if(factory == null){
            init();
        }
        session = factory != null ? factory.openSession():null;
        return session;
    }
    public static void CloseSession(SqlSession session){
        session.close();

    }
}
