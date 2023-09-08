package com.ue.bor.service;

import java.util.List;
import com.ue.bor.model.User;

public interface UserService {
	User create(User user);
	User readById(Long id);
	User update(User user);
	void delete(Long id);
	List<User> getAll();

}
