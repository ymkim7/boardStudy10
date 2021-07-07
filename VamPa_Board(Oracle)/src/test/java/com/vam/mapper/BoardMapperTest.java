package com.vam.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(BoardMapperTest.class);
	
	@Autowired
	private BoardMapper mapper;
	
	@Ignore
	@Test
	public void testEnroll() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(4);
		vo.setTitle("mapper test");
		vo.setContent("mapper test");
		vo.setWriter("mapper test");
		
		mapper.enroll(vo);
		
	}
	
	//@Ignore
	@Test
	public void testGetList() {
		List list = mapper.getList();
		
		for(int i = 0; i < list.size(); i++) {
			log.info("list" + list.get(i));
		}
	}

}
