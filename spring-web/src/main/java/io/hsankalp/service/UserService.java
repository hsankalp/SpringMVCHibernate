package io.hsankalp.service;

import java.util.List;

import io.hsankalp.entity.User;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.exception.EntityExistsException;

public interface UserService {

	public List<User> findAll ();
	public User findOne (String id) throws EntityNotFoundException;
	public User login (String email, String password) throws EntityNotFoundException;
	public User create (User user) throws EntityExistsException;
	public User update (String id, User user) throws EntityNotFoundException;
	public void delete (String id) throws EntityNotFoundException;
}
