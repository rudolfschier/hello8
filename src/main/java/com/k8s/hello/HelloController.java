package com.k8s.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello from springboot";
    }

    @GetMapping("/home")
    public String getMyHome(){
        return "from hello - with new defaults";
    }

    @GetMapping("/student")
    public String getMyStudent(){
        Student student = new Student("John", 23332);
        return student.toString();
    }

}
