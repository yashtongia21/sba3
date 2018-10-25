package com.verizon.isp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.isp.service.PlanService;
import com.verizon.isp.model.Plans;
import com.verizon.isp.restapi.PlanAPI;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PlanAPI.class)
public class PlansApiUnitTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PlanService planServiceMock;

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

		assertThat(this.planServiceMock).isNotNull();

		List<Plans> empList = new ArrayList<>();
		empList.add(new Plans());

		when(planServiceMock.getAllPlans()).thenReturn(empList);

		mockMvc.perform(get("/plans")).andExpect(status().isOk()).andDo(print());

	}
	

}
