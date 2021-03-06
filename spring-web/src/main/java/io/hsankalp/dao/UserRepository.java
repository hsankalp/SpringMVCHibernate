package io.hsankalp.dao;


import java.util.List;

import io.hsankalp.entity.User;

public interface UserRepository {
	public List<User> findAll ();
	public User findOne (String id);
	public User login (String email, String password);
	public User findByEmail (String email);
	public User create (User user);
	public User update (User user);
	public void delete (User user);
}