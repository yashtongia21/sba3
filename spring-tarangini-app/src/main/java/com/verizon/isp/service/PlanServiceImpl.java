package com.verizon.isp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.isp.dao.PlansRepository;
import com.verizon.isp.model.Plans;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlansRepository pRep;

	@Override
	public List<Plans> getAllPlans() {
		return pRep.findAll();
	}

	@Override
	public Plans findByNetSpeed(String netSpeed) {
		return pRep.findByNetSpeed(netSpeed);
	}

	@Override
	public Plans findByMaxUsage(String maxUsage) {
		return pRep.findByMaxUsage(maxUsage);
	}

	@Override
	public Plans findByCharge(String charge) {
		return pRep.findByCharge(charge);
	}

}
