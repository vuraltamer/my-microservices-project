package com.project.controller;

import com.project.client.OrderFeignClient;
import com.project.data.entity.BaseEntity;
import com.project.data.entity.User;
import com.project.dto.OrderDto;
import com.project.dto.UserDto;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController extends BaseController<User, UserDto> {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/id/{id}")
    protected ResponseEntity<UserDto> findById(@PathVariable("id") String id) {
        return toDto(userService.getEntity(id), new UserDto());
    }

    @PostMapping(value = "/save", produces = "application/json")
    protected ResponseEntity save(@RequestBody @Valid UserDto userDto) {

        final BaseEntity entity = toEntity(new User(), userDto);

        return ResponseEntity.ok(userService.save((User) entity));
    }

    @Override
    @GetMapping("/delete/{id}")
    protected ResponseEntity delete(@PathVariable String id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @Override
    @PostMapping(value = "/update", produces = "application/json")
    protected ResponseEntity update(@RequestBody @Valid UserDto dto) {

        final BaseEntity entity = toEntity(new User(), dto);

        return ResponseEntity.ok(userService.update((User) entity));
    }

    @Override
    @GetMapping("/list")
    protected ResponseEntity<List<UserDto>> list() {
        List<User> users = userService.getRepository().findAll();
        return toDto(users, new UserDto());
    }
}
