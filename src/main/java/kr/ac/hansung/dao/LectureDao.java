package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Lecture;

@Repository
public class LectureDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from lecture";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public List<Lecture> getAllSemester() {
		String sqlStatement = "select year, semester from lecture group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lecture lecture = new Lecture();
				
				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));

				return lecture;

			}
		});

	}

	// query and return a single object
	public Lecture getLecture(int year, int semester) {
		String sqlStatement = "select * from lecture where year=? AND semester=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { year, semester }, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lecture lecture = new Lecture();
				
				lecture.setId(rs.getInt("id"));
				lecture.setYear(rs.getInt("year"));
				lecture.setTitle(rs.getString("title"));
				lecture.setType(rs.getString("type"));
				lecture.setProfessor(rs.getString("professor"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;

			}
		});

	}
	
	
	public List<Lecture> getSemesterLect(int year, int semester) {
		String sqlStatement = "select * from lecture where year=? AND semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lecture lecture = new Lecture();
				
				lecture.setId(rs.getInt("id"));
				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setTitle(rs.getString("title"));
				lecture.setType(rs.getString("type"));
				lecture.setProfessor(rs.getString("professor"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;

			}
		});

	}

	// query and return a multiple objects
	//cRud method
	public List<Lecture> getLecture() {
		String sqlStatement = "select * from lecture";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {

			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lecture lecture = new Lecture();
				
				lecture.setId(rs.getInt("id"));
				lecture.setYear(rs.getInt("year"));
				lecture.setTitle(rs.getString("title"));
				lecture.setType(rs.getString("type"));
				lecture.setProfessor(rs.getString("professor"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;

			}
		});

	}
	
	public int getCredit(int year, int semester) {
		String sqlStatement = "select sum(credit) from lecture where year=? AND semester=?";
		int credit = jdbcTemplate.queryForObject(sqlStatement, new Object[] { year, semester },  Integer.class);
		
		return credit;
	}
	
	public int getAllCredit() {
		String sqlStatement = "select sum(credit) from lecture";
		int allCredit = jdbcTemplate.queryForObject(sqlStatement, Integer.class);
		
		return allCredit;
	}

	//Crud method
	public boolean insert(Lecture lecture) {

		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String title = lecture.getTitle();
		String type = lecture.getType();
		String professor = lecture.getProfessor();
		int credit = lecture.getCredit();

		String sqlStatement = "insert into lecture (year, semester, title, type, professor, credit) value(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, title, type, professor, credit }) == 1);
	}

	//crUd method
	public boolean update(Lecture lecture) {
		
		int id = lecture.getId();

		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String title = lecture.getTitle();
		String type = lecture.getType();
		String professor = lecture.getProfessor();
		int credit = lecture.getCredit();

		String sqlStatement = "update lecture set year=?, semester=?, title=?, type=?, professor=?, credit=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, title, type, professor, credit, id }) == 1);
	}
	
	//cruD method
	public boolean delete(int id) {
		
		String sqlStatement ="delete from lecture where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
	
	
	
	
	
	

}
