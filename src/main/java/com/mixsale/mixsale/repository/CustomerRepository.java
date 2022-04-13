package com.mixsale.mixsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long>{
	
	@Query("select MAX(t.csSeq) from CustomerEntity t where t.csBranch = 1?")
	Integer getSeqCustomer(String branchId);

}
