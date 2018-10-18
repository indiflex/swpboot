package com.jade.swpboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jade.swpboot.domain.User;
import com.jade.swpboot.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwpbootApplicationTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);
		
		try (Connection conn = ds.getConnection()) {
			System.out.println("Cooooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);
			
			assertEquals(100, getLong(conn, "select 100"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUserMapper() throws Exception {
		String uname = mapper.getUname("user1");
		assertEquals(uname, "김일수");
		assertEquals("김이수", mapper.getUname("user2"));
		
		User user = mapper.getLoginInfo("user1");
		System.out.println("UUUUUUUUUUU>>" + user);
	}
	
	private long getLong(Connection conn, String sql) throws Exception {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				result = rs.getLong(1);
			
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	

	@Test
	public void contextLoads() {
		System.out.println("&&&&&&&&&&&&&& contextLoads &&&&&&&&&&&&&&&&&&&&&&&&&");
	}

}
