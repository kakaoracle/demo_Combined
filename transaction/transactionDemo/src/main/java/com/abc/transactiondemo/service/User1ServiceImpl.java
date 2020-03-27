package com.abc.transactiondemo.service;

import com.abc.transactiondemo.bean.User1;
import com.abc.transactiondemo.mapper.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class User1ServiceImpl {
	@Autowired
	private User1Mapper user1Mapper;
	
	public void truncate(){
		user1Mapper.truncated();
	}
	
	public void add(User1 user){
		user1Mapper.insert(user);
	}
	
	public User1 get(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	public void addException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User1 user){
		user1Mapper.insert(user);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User1 getRequired(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupports(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupportsException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly=true)
	public User1 getRequiresNew(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupported(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupportedException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public User1 getNotSupported(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatory(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatoryException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void addNever(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void addNeverException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(User1 user){
		user1Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Transactional(propagation = Propagation.NESTED,readOnly=true)
	public User1 getNested(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
}
