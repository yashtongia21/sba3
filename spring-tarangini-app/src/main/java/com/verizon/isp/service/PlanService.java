package com.verizon.isp.service;

import java.util.List;

import com.verizon.isp.model.Plans;

public interface PlanService {

	List<Plans> getAllPlans();

	Plans findByNetSpeed(String netSpeed);

	Plans findByMaxUsage(String maxUsage);

	Plans findByCharge(String charge);

}
