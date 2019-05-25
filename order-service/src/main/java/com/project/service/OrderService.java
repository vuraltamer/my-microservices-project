package com.project.service;

import com.project.client.UserFeignClient;
import com.project.data.entity.Order;
import com.project.data.repo.BaseRepository;
import com.project.data.repo.OrderRepository;
import com.project.dto.UserDto;
import com.project.exception.ResourceNotFoundException;
import com.project.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService extends AbstractEntityService<Order,String> {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private OrderRepository userRepository;

	@Override
	public BaseRepository<Order, String> getRepository() {
		return userRepository;
	}

	@Override
	@Transactional
	public Order save(Order entity) {

		UserDto userDto = userFeignClient.findById(entity.getUserId()).getBody();

		if (userDto == null) {
			throw new ResourceNotFoundException(HttpStatus.OK, entity.getUserId() + " is not found!");
		}

		return super.save(entity);
	}

}
