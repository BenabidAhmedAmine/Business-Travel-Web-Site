package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.User;

public interface IUserService {
	public List<User>retrieveAllUser();
	public void deleteUser (long id);
	public Optional<User> retrieveUserById(long id);
	public User retrieveUserByName (Long id);
	public User addUser(User user);
	public User updateUser(User user);

}
