package com.roman.springbootapril.controllers;

import com.roman.springbootapril.dao.UserDao;
import com.roman.springbootapril.models.Email;
import com.roman.springbootapril.models.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users", userDao.findAll());
        return "index";
    }


    @PostMapping("/save")
    public String save(
            @RequestParam String data,
            @RequestParam String email,//перехопленя параметрів
            Model model
    ){
       User user = new User();
       user.setName(data);





        Email email1= new Email();

        email1.setEmail(email);    //передаєм емеййл який надійде
        email1.setUser(user);

        List<Email> emailList = new ArrayList();//cетаємо йому юзера -робимо привязку

        emailList.add(email1);

        user.setEmails(emailList);




        model.addAttribute("data", userDao.findAll());
        userDao.save(user);
        return "result";
    }


    @GetMapping("/user-{xxx}")
    public String singleUser (@PathVariable ("xxx") int id , Model model){
        model.addAttribute("currentUser",userDao.findById(id).get());
        return "singleUser";
    }

}
