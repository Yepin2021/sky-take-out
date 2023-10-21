package com.sky.mapper;

import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee(id_number,name,phone,sex,username,password,create_time,update_time,create_user,update_user) " +
            "values (#{idNumber},#{name},#{phone},#{sex},#{username},#{password},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void addEmp(Employee employee);
}
