package com.mirae.spring.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mirae.biz.board.BoardService;
import com.mirae.biz.board.BoardVO;

@Controller
// SessionAttributes saves addAttribute() values into session
@SessionAttributes({"board", "user"})
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("Title", "title");
		conditionMap.put("Username", "username");		
		conditionMap.put("Content", "content");
		return conditionMap;
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO boardVO) {
		System.out.println("deleteBoard(): sequence = " + boardVO.getSequence());
		boardService.deleteBoard(boardVO);
		return "deleteBoardSuccess";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO boardVO, Model model) {
		System.out.println("getBoard()");
		BoardVO board = boardService.getBoard(boardVO);
		model.addAttribute("board", board);
		return "getBoard";
	}
	
	// RequestParam syntax: getBoardList(@RequestParam(value="searchCondition", defaultValue = "", required= false) String searchCondition,
		//	@RequestParam(value="searchKeyword", defaultValue = "", required= false), the rest)
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(String searchKeyword, BoardVO boardVO, Model model) {
		System.out.println("getBoardList()");
		
		// this also works if you include HttpServletRequest as a parameter dont add parameters to BoardVO but Spring also has RequestParam
//		String searchCondition = request.getParameter("searchCondition");
//		String searchKeyword = request.getParameter("searchKeyword");
		
		// null check
		if(boardVO.getSearchCondition() == null) boardVO.setSearchCondition("");
		if(boardVO.getSearchKeyword() == null) boardVO.setSearchKeyword("");
		
		
		
		List<BoardVO> boardList = boardService.getBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO boardVO) throws IllegalStateException, IOException {
		System.out.println("insertBoard()");
		MultipartFile uploadFile = boardVO.getUploadFile();
		// if a file has been uploaded, save into server storage
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			File file = new File("C:/DEV/fileSave/" + fileName);
			uploadFile.transferTo(file);
		}
		boardService.insertBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		System.out.println("updateBoard()");
		boardService.updateBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(String searchKeyword, BoardVO boardVO) {
		System.out.println("dataTransform()");
		
		// null check
		if(boardVO.getSearchCondition() == null) boardVO.setSearchCondition("");
		if(boardVO.getSearchKeyword() == null) boardVO.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(boardVO);
		return boardList;
	}
}