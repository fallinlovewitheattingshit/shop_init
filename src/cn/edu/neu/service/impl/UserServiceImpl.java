package cn.edu.neu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.mapper.UserMapper;
import cn.edu.neu.model.User;
import cn.edu.neu.service.UserService;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	

	@Override
	public User existsUser(User user) {
		// TODO Auto-generated method stub
		return mapper.existsUser(user);
	}
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(mapper.existsUserName(user)==0){
			try{
				System.out.println(mapper.addUser(user));	
				//System.out.println(user);
				return true;
			}
			catch(Exception e){
				return false;
			}
		}
		else
			return false;
	}

	@Override
	public boolean existsUserName(String userName) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUserName(userName);
		if(mapper.existsUserName(user)==0)
			return true;
		else
			return false;
	}

	@Override
	public User existsAdmin(User user) {
		// TODO Auto-generated method stub
		return mapper.existsAdmin(user);
	}

}
