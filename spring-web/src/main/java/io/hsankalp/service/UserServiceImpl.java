package io.hsankalp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hsankalp.dao.UserRepository;
import io.hsankalp.entity.User;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findOne(String id) throws EntityNotFoundException {
		User user = repo.findOne(id);
		if(user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}
	
	@Override
	public User login(String email, String password) throws EntityNotFoundException {
		User user = repo.login(email,password);
		if(user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}

	@Override
	public User create(User user) throws EntityExistsException {
		User existing = repo.findOne(user.getEmail());
		if(existing != null) {
			throw new EntityExistsException();
		}
		return repo.create(user);
	}

	@Override
	public User update(String id, User user) throws EntityNotFoundException {
		User existing = repo.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException();
		}
		return repo.update(user);
	}

	@Override
	public void delete(String id) throws EntityNotFoundException {
		User existing = repo.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException();
		}
		repo.delete(existing);
	}

	

}
