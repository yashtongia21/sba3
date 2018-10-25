package com.verizon.isp.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.isp.model.Plans;
import com.verizon.isp.service.PlanService;

@RestController
@RequestMapping("/plans")
@CrossOrigin
public class PlanAPI {

	@Autowired
	private PlanService pSer;

	@GetMapping
	public ResponseEntity<List<Plans>> getAllPlans() {

		return new ResponseEntity<>(pSer.getAllPlans(), HttpStatus.OK);

	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Plans>> getAllPlansSorted(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {

		ResponseEntity<List<Plans>> resp = null;

		switch (fieldBy) {
		case "netSpeed":
			Plans cByNetSpeed = pSer.findByNetSpeed(searchValue);
			if (cByNetSpeed != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByNetSpeed), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}
			break;
		case "maxUsage":
			Plans cByMaxUsage = pSer.findByMaxUsage(searchValue);
			if (cByMaxUsage != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByMaxUsage), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}
			break;
		case "charge":
			Plans cByCharge = pSer.findByCharge(searchValue);
			if (cByCharge != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByCharge), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

			}
			break;
		default:
			break;
		}
		return resp;
	}

}
