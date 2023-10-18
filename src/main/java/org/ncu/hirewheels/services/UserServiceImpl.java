package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
    @Override
    public User createUser(User user) {
        // Implement user creation logic, e.g., save the user in the database.
        // You can use a UserRepository to interact with the database.
        // Ensure to return the created user.
    	 return userdao.save(user);
    }
    
    public User getUser(String email, String password) {
        Optional<User> userOptional = userdao.findByEmailIgnoreCase(email);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                System.out.println("Unauthorized User");
                return null; // or return an appropriate response
            }
        } else {
            System.out.println("User not Registered");
            return null; // or return an appropriate response
        }
        
    }

}
