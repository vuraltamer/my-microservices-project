package com.project.client.base;

import com.project.dto.UserDto;
import com.project.dto.base.BaseDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseFeignClient<T extends BaseDto> {

    @GetMapping("/welcome")
    String welcome();

    @RequestMapping(value = {"/id/{id}"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<T> findById(@PathVariable("id") String id);

    @GetMapping("/list")
    ResponseEntity<List<T>> list();

    @PostMapping(value = "/save", produces = "application/json")
    ResponseEntity save(@RequestBody @Valid T dto);

    @RequestMapping(value = {"/delete/{id}"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity delete(@PathVariable("id") String id);

    @PostMapping(value = "/update", produces = "application/json")
    ResponseEntity update(@RequestBody @Valid T dto);



}
