package com.abc.transactiondemo.service;

import com.abc.transactiondemo.bean.User2;
import com.abc.transactiondemo.mapper.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User2ServiceImpl {
	@Autowired
	private User2Mapper user2Mapper;
	
	public void truncate(){
		user2Mapper.truncated();
	}
	
	public void add(User2 user){
		user2Mapper.insert(user);
	}
	
	public void addException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	public User2 get(Integer id){
		return user2Mapper.selectByPrimaryKey(id);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User2 user){
		user2Mapper.insert(user);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User2 getRequired(Integer id){
		return user2Mapper.selectByPrimaryKey(id);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupports(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupportsException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupported(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupportedException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatory(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatoryException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void addNever(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void addNeverException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(User2 user){
		user2Mapper.insert(user);
	}
	
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
}
