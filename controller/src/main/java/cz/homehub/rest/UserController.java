package cz.homehub.rest;

import cz.homehub.entity.User;
import cz.homehub.rest.api.ExceptionResponseHandler;
import cz.homehub.rest.api.Response;
import cz.homehub.rest.api.ResponseStatus;
import cz.homehub.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController implements ExceptionResponseHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public Response getUserByUsername(@PathVariable String username){
        return new Response.Builder<User>()
                .setResponse(userService.getByUsername(username))
                .setResponseStatus(ResponseStatus.SUCCESS)
                .build();
    }

    @GetMapping("/all")
    public Response getAllUsers(){
        return new Response.Builder<List<User>>()
                .setResponse(userService.getAll())
                .setResponseStatus(ResponseStatus.SUCCESS)
                .build();
    }

    @PutMapping
    public Response updateUser(@RequestBody User user){
        return new Response.Builder<User>()
                .setResponse(userService.update(user))
                .setResponseStatus(ResponseStatus.SUCCESS)
                .build();
    }
}
