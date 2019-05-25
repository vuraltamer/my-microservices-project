package com.project.client;

import com.project.client.base.BaseFeignClient;
import com.project.dto.OrderDto;
import com.project.util.Info;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(Info.ORDER_SERVICE)
public interface OrderFeignClient extends BaseFeignClient<OrderDto> {


}
