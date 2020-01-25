package loginRol.springbootmongodb.controller;

import loginRol.springbootmongodb.entity.User;
import loginRol.springbootmongodb.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping({"/user"})
@CrossOrigin(value={})


public class UserController {

        @Autowired
        UserServiceImpl userService;

        @GetMapping( value = "/getByEmail/{user}")
        public Optional<User> getByEmail(@PathVariable(value = "user")String email){
            return userService.findByEmail(email);
        }
        @GetMapping("/getAll")
        public ResponseEntity<?> getAll(){
            ResponseEntity<?>response;
            try{
                List<User> users = this.userService.findAll();
                response = new ResponseEntity<>(users, HttpStatus.OK);
            }catch (Exception ex){
                System.out.println(ex);
                response = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return response;
        }

        @PostMapping("/addUser")
        public ResponseEntity<?>addUser(@RequestBody User user){
            ResponseEntity<?> response;
            String respuService = this.userService.createUser(user);
            try{
                if (respuService.equals("ok")){
                    response = new ResponseEntity<>("{\"Mensaje\":\"Usuario a sido creado exitosamente\"}", HttpStatus.CREATED);
                }else{
                    response = new ResponseEntity<>("{\"Error\":\"Ya existe el usuario\"}", HttpStatus.BAD_REQUEST);
                }

            } catch (Exception ex){
                response = new ResponseEntity<>("{\"Error\":\"Hubo un problema interno\"}",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return response;
        }

}
