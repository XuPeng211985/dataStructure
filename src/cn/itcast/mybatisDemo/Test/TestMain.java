package cn.itcast.mybatisDemo.Test;
import cn.itcast.mybatisDemo.entity.Employee;
import cn.itcast.mybatisDemo.entity.EmployeeDao;
import cn.itcast.mybatisDemo.mybatisUtils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
/**
 * Created by hpx on 2018/2/4.
 */
public class TestMain {
    public static void main(String[] args) {
        // addTest();
        //findByIdTest();
        //updateTest();
        deleteTest();
    }
    public static void addTest(){
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("liangliang");
        employee.setSex("男");
        employee.setCardNum("111111111111111111");
        employee.setBirthday("1998-09-02");
        employee.setGrade("本科");
        SqlSession session = MyBatisUtils.getSession();
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        employeeDao.addEmployee(employee);
        session.commit();
        MyBatisUtils.CloseSession(session);
    }
    public static void findByIdTest(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.findById(10);
        System.out.println( employee.toString());
    }
    public static void updateTest(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("nanaan");
        employee.setSex("女");
        employee.setCardNum("2222222222222222");
        employee.setBirthday("1997-09-02");
        employee.setGrade("本科");
        employeeDao.updateEmployee(employee);
        session.commit();
        MyBatisUtils.CloseSession(session);
    }
    public static void deleteTest(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("nanaan");
        employee.setSex("女");
        employee.setCardNum("2222222222222222");
        employee.setBirthday("1997-09-02");
        employee.setGrade("本科");
        employeeDao.deleteEmployee(employee);
        session.commit();
    }
}
