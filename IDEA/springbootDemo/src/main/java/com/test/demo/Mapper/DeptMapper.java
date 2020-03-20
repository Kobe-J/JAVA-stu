package com.test.demo.Mapper;


import com.test.demo.Pojo.DeptPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT *FROM dept")
    List<DeptPojo> showall();

    @Select("SELECT * FROM dept WHERE deptno = #{deptno}")
    List<DeptPojo> findByid(@Param("deptno") int deptno);

    @Insert("INSERT INTO dept(deptno, dname, loc) VALUES(#{deptno}, #{dname}, #{loc})")
    int insert(@Param("deptno") int deptno, @Param("dname") String dname,@Param("loc") String loc);

    @Delete("DELETE FROM dept WHERE deptno=#{deptno}")
    void delete(@Param("deptno") int deptno);


    @Update("UPDATE  dept SET dname=#{dname},loc=#{loc}  WHERE deptno=#{deptno}")
    void update(@Param("deptno") int deptno, @Param("dname") String dname,@Param("loc") String loc);
}
