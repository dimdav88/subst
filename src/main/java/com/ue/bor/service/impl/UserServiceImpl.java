package com.ue.bor.service.impl;

import java.util.List;

import com.ue.bor.exceptions.NullEntityReferenceException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ue.bor.model.User;
import com.ue.bor.repository.UserRepository;
import com.ue.bor.service.UserService;
import com.example.demo.exceptions.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		if (user != null) {
			return userRepository.save(user);
		}
		throw new NullEntityReferenceException("User cannot be null");
	}

	@Override
	public User readById(Long id) {
		return userRepository.findById(id).orElseThrow(
				() ->new EntityNotFoundException("User with id = " + id + " not found")
		);
	}

	@Override
	public User update(User user) {
			if (user != null) {
			readById(user.getId());

		return userRepository.save(user);
		}
		throw  new NullEntityReferenceException("User cannot be null");
	}

	@Override
	public void delete(Long id) {
		User user = readById(id);
		userRepository.delete(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

}
