package com.cg.grocerydeliveryapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.grocerydeliveryapplication.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	@Query(value = "select r.password from registration r where r.password=:password", nativeQuery=true)
   String findBypassword(String password);

	@Query(value = "select  r.email from registration r where r.email=:email",nativeQuery=true)
	String findByEmail(String email);


}
 