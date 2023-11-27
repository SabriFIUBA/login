package com.example.login.user.controller;
import com.example.login.user.domain.User;
import com.example.login.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(){}

    //    @PostMapping(
    //            value = "/altaOrdenPago",
    //            consumes = {MediaType.APPLICATION_JSON_VALUE})
    //    public void save(@RequestBody OrdenPago ordenPago) {
    //        ordenPagoService.guardar(ordenPago);
    //
    //    }
    @PostMapping(value = "/sign-up", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User save(@RequestBody User user){
        return (this.userService.guardar(user));
    }
    @GetMapping({"/{name}"})
    public User findByName(@PathVariable String name){
        return this.userService.buscarPorName(name);
    }
}
