package com.verizon.isp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.isp.model.User;
import com.verizon.isp.restapi.UserAPI;
import com.verizon.isp.service.UserService;
import com.verizon.isp.testUtil.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserAPI.class)
public class UserApiUnitTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private UserService userServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testAddUser() throws Exception {
		assertThat(this.userServiceMock).isNotNull();

		User user = new User();

		User userAdded = new User();

		when(userServiceMock.addUser(Mockito.any(User.class))).thenReturn(userAdded);

		mockMvc.perform(post("/users").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(user))).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void testGetUserById() throws Exception {

		assertThat(this.userServiceMock).isNotNull();
		int empId = 1;

		User userAdded = new User();

		when(userServiceMock.getUserById(empId)).thenReturn(userAdded);

		mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andDo(print());

	}
}
