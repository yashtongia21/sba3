package com.verizon.isp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.isp.model.Plans;
import com.verizon.isp.service.PlanService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlansApiIntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private PlanService planService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllPlans() throws Exception {

		assertThat(this.planService).isNotNull();

		List<Plans> empList = new ArrayList<>();

		empList.add(new Plans());

		mockMvc.perform(get("/plans")).andExpect(status().isOk()).andDo(print());

	}
}
