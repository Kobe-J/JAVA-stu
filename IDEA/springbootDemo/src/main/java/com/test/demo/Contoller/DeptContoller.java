package com.test.demo.Contoller;


import com.test.demo.Pojo.DeptPojo;
import com.test.demo.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptContoller {
    @Autowired
    public DeptService service;

    @GetMapping("/showall")
    @ResponseBody
    public List<DeptPojo> showall(){
        List<DeptPojo> users= service.showall();
        return users;
    }

    @GetMapping("/findone")
    @ResponseBody
    public List<DeptPojo> selectUser(int deptno) {
        List<DeptPojo> users = service.findone(deptno);
        return users;
    }

    @PostMapping("/insert")
    @ResponseBody
    public List<DeptPojo> insertUser(int deptno, String dname, String loc) {
        List<DeptPojo> users = service.insertUser(deptno,dname,loc);
        return users;
    }

    @PostMapping("/del")
    @ResponseBody
    public String deletUser(int deptno) {
        service.delet(deptno);
        return "success";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateUser(int deptno, String dname, String loc) {
        service.update(deptno,dname,loc);
        return "success";
    }
}
