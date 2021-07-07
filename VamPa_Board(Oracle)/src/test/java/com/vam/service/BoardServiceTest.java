package com.vam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Autowired
	private BoardService service;
	
	@Ignore
	@Test
	public void testEnroll() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(4);
		vo.setTitle("mapper test");
		vo.setContent("mapper test");
		vo.setWriter("mapper test");
		
		service.enroll(vo);
		
	}
	
	//@Ignore
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info("list" + board));
		
	}

}
