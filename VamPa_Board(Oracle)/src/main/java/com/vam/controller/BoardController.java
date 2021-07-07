package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.mapper.PageMakerDTO;
import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	/* 게시판 리스트 */
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info("게시판 목폭 페이지 진입");
		
		model.addAttribute("list", service.getListPaging(cri));
		
		int total = service.getTotal(cri);
		
		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMaker);
	}

	/* 게시판 등록 GET */
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	/* 게시판 등록 POST */
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("BoardVO : " + boardVO);
		service.enroll(boardVO);
		
		rttr.addFlashAttribute("result", "enroll success");
		
		return "redirect:/board/list";
	}
	
	/* 게시판 조회 */
	@GetMapping("/get")
	public void boardGetPage(int bno, Model model, Criteria cri) {
		
		model.addAttribute("pageInfo", service.getPage(bno));
		model.addAttribute("cri", cri);
		
	}
	
	/* 게시판 수정 GET */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model, Criteria cri) {
		
		model.addAttribute("pageInfo", service.getPage(bno));
		model.addAttribute("cri", cri);
		
	}
	
	/* 게시판 수정 POST */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO boardVO, RedirectAttributes rttr) {
		
		service.modify(boardVO);
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/board/list";
		
	}
	
	/* 게시판 삭제 */
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {
		service.delete(bno);
		rttr.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list"; 
	}
	
}
