package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDao;
import kr.ac.hansung.model.Lecture;

@Service
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	public List<Lecture> getCurrent(){
		
		return lectureDao.getLecture();
	}
	public List<Lecture> getAllSemester(){
		return lectureDao.getAllSemester();
	}
	public List<Lecture> getCredit() {
		List<Lecture> list = new ArrayList<Lecture>();
		
		for(Lecture lect:  lectureDao.getAllSemester()) {
			Lecture lecture = new Lecture();
			int y = lect.getYear();
			int s = lect.getSemester();
			lecture.setYear(y);
			lecture.setSemester(s);
			int c = lectureDao.getCredit(y, s);
			lecture.setCredit(c);
			list.add(lecture);
			
		}
		return list;
		
	}
	public int getAllCredit() {
		return lectureDao.getAllCredit();
	}
	
	
	public void insert(Lecture lecture) {
		
		lectureDao.insert(lecture);
		
	}
	
	public List<Lecture> getSemesterLect(int year, int semester) {
		List<Lecture> list = new ArrayList<Lecture>();
		
		for(Lecture lect: lectureDao.getSemesterLect(year, semester)) {
			Lecture lecture = new Lecture();
			
			lecture.setYear(lect.getYear());
			lecture.setSemester(lect.getSemester());
			lecture.setTitle(lect.getTitle());
			lecture.setType(lect.getType());
			lecture.setProfessor(lect.getProfessor());
			lecture.setCredit(lect.getCredit());
			list.add(lecture);
			
		}
		return list;
	}
	
	
	

}
