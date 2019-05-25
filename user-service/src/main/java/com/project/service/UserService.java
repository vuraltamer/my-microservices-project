package com.project.service;

import com.project.data.repo.BaseRepository;
import com.project.data.repo.UserRepository;
import com.project.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  extends AbstractEntityService<User,String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public BaseRepository<User, String> getRepository() {
		return userRepository;
	}

}
