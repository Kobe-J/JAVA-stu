package com.test.demo.Service;


import com.test.demo.Mapper.DeptMapper;
import com.test.demo.Pojo.DeptPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeptService {
    @Autowired
    private DeptMapper mapper;

    public List<DeptPojo> showall(){
        return mapper.showall();
    }

    public List<DeptPojo> findone(int deptno) {
        return mapper.findByid(deptno);
    }

    public List<DeptPojo> insertUser(int deptno, String dname, String loc) {
        mapper.insert(deptno,dname,loc);
        return null;
    }

    public void delet(int deptno) {
        mapper.delete(deptno);
    }

    public void update(int deptno, String dname, String loc) {
        mapper.update(deptno,dname,loc);
    }
}
