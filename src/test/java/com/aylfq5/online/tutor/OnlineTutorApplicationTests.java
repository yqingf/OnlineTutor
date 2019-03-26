package com.aylfq5.online.tutor;

import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.util.IDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineTutorApplicationTests {

	@Resource
	private ApplicationContext context;

	@Resource
	private UserMapper userMapper;

	@Test
	public void insert() {
		User user = new User();
		long cellphone = 18855733012L;
		for (int i = 1; i <= 1000; i++) {
			user.setId(IDUtils.genItemId());
			user.setName("张三"+i);
			user.setPassword(String.valueOf(IDUtils.genItemId()));
			user.setNumber(String.valueOf(2015112140+i));
			user.setCellphone(String.valueOf(cellphone+i));
			user.setPersonalProfile("这是个人简介"+i);
			user.setAvatar("http://porbzia1c.bkt.clouddn.com/1553478396751.jpeg");
			user.setPassword("4297f44b13955235245b2497399d7a93");
			user.setUserType(1);
			user.setGender(1);
			if (i % 2 == 0) {
				user.setGender(2);
				user.setUserType(2);
				user.setProfessionalTitle("助教");
				if( i % 3 == 0) {
					user.setProfessionalTitle("副教授");
				}
				if (i % 4 == 0) {
					user.setProfessionalTitle("教授");
				}
			}
			userMapper.insert(user);
		}
	}

}
