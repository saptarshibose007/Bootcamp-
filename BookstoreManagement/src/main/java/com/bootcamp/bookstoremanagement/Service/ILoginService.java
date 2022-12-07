package com.bootcamp.bookstoremanagement.Service;

import com.bootcamp.bookstoremanagement.Entity.User;

public interface ILoginService {
	
	public User addUser(User user);
	public User removeUser(int id);
	public User validateUser(User user);

}
