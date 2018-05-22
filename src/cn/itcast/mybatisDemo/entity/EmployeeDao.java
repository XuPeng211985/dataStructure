package cn.itcast.mybatisDemo.entity;

/**
 * Created by hpx on 2018/2/4.
 */
public interface EmployeeDao {
   public Employee findById(int id);
   public void addEmployee(Employee employee);
   public void updateEmployee(Employee employee);
   public void deleteEmployee(Employee employee);
}
