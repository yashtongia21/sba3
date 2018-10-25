package com.verizon.isp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.isp.model.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, String> {

	Plans findByNetSpeed(String netSpeed);

	Plans findByMaxUsage(String maxUsage);

	Plans findByCharge(String charge);

}
