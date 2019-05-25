package com.project.client;

import com.project.client.base.BaseFeignClient;
import com.project.util.Info;
import com.project.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(Info.USER_SERVICE)
public interface UserFeignClient extends BaseFeignClient<UserDto> {

}
