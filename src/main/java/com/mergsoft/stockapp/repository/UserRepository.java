package com.mergsoft.stockapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mergsoft.stockapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserByUserId(Integer userId);

	@Query(value="select * from User u where u.userId=?1 and u.password=?2 ", nativeQuery = true)
	List<User> loginCheck(Integer userId, String password);

//	@Query(value="select * from User u where u.userId=?1 and u.password=?2 ", nativeQuery = true)
//	User loginCheck(Integer userId, String password);

}
