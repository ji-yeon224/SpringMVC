package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping("/show")
	public String showLecture(Model model) {
		
		
		List<Lecture> creditInfo = lectureService.getCredit();
		model.addAttribute("credit", creditInfo);
		int allCredit = lectureService.getAllCredit();
		model.addAttribute("all", allCredit);
		
		return "lecture";
	}
	
	@RequestMapping("/detail")
	public String showDetatil(Model model,@RequestParam String year, @RequestParam String semester) {
		int y = Integer.parseInt(year);
		int s = Integer.parseInt(semester);
		
		List<Lecture> detailInfo = lectureService.getSemesterLect(y, s);
		model.addAttribute("detail", detailInfo);
		
		return "detail";
	}
	
	
	@RequestMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("lecture", new Lecture());
		
		return "register";
	}
	
	@RequestMapping("/doRegister")
	public String doRegister(Model model, @Valid Lecture lecture, BindingResult result) {
	
		if(result.hasErrors()) {
			System.out.println("Form data does not validated ==");
			
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "register";
		}
		
		lecture.setYear(2021);
		lecture.setSemester(1);
		
		lectureService.insert(lecture);
		
		return "complete";
	}
	
	@RequestMapping("/check")
	public String check(Model model) {
		
		List<Lecture> registerInfo = lectureService.getSemesterLect(2021, 1);
		model.addAttribute("register", registerInfo);
		
		return "check";
	}
	

}
