package my.test.notepad.dao;

import org.springframework.stereotype.Component;

import my.test.notepad.entity.User;

@Component
public class UserDao extends MongoDBGenericDao<User, Integer> implements IUserDao{

}
