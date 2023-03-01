package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.R;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.net.Inet4Address;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public R<User> login(@RequestBody User user){
        // 加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 查询
        queryWrapper.eq(User::getUsername,user.getUsername());
        queryWrapper.eq(User::getPassword, user.getPassword());
        User one = userDao.selectOne(queryWrapper);
        // 判断
        if (one != null){
            return R.success(one);
        }else{
            return R.error("登陆失败!");
        }
    }
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userDao.selectList(null);
    }
    @PostMapping("/add")
    public boolean add(@RequestBody User user){
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        System.out.println(user);
//        userDao.insert(user);
        userDao.insert(user);
        return true;
    }
    @PostMapping("/upd")
    public boolean upd(@RequestBody User user){

        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userDao.updateById(user);
        System.out.println(user);

        return true;
    }
    @GetMapping("/del/{id}")
    public boolean del(@PathVariable Integer id){

        userDao.deleteById(id);

        return true;
    }

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));

    }

}
