package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;

import model.Address;
import model.Score;
import model.Student;
import service.AddressService;
import service.ScoreService;
import service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	@Qualifier("studentService")
	StudentService service;

	@Autowired
	@Qualifier("scoreService")
	ScoreService scoreService;

	@Autowired
	@Qualifier("addressService")
	AddressService addressService;

	/*
	 * This method will list all existing students.
	 * 
	 */

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView listStudents() {

		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String listStudents(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			List<Student> students = service.findAllStudents();
			model.addAttribute("students", students);
			model.addAttribute("sticker", "Result all student");
			return "allstudents";
		}
		int result = service.checkPass(username, password);
		if (result != -1) {
			model.addAttribute("success", "Login successed: " + username);
			model.addAttribute("studentid", result);
			model.addAttribute("status", false);
			model.addAttribute("link", "score-"+result+"-student");
			return "success";
		} else {
			model.addAttribute("message", "Login False");
			return "loginfalse";
		}
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) {

		List<Student> students = service.findAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("sticker", "Result all student");
		return "allstudents";
	}

	@RequestMapping(value = { "/search-{name}" }, method = RequestMethod.GET)
	public String newStudent(ModelMap model, @PathVariable String name) {
		List<Student> students = service.findStudentByName(name);
		model.addAttribute("students", students);
		model.addAttribute("sticker", (String) ("Result search " + name + ": "));
		return "allstudents";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public ModelAndView newStudent(ModelMap model) {
		ModelAndView model1 = new ModelAndView("registration");
		model.addAttribute("edit", false);
		return model1;
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		Address address = student.getAddress();
		address.setStudent(student);
		address.setId(student.getId());

		service.saveStudent(student);

		model.addAttribute("success", "Student " + student.getFirstname() + " registered successfully");
		model.addAttribute("studentid", student.getId());
		model.addAttribute("status", true);
		model.addAttribute("link", "list");
		return "success";
	}

	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id, ModelMap model) {
		Student student = service.findById(id);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "registration";
	}

	@RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Student student, BindingResult result, ModelMap model,
			@PathVariable String id) {

		if (result.hasErrors()) {
			return "registration";
		}

		try {
			Address address = student.getAddress();
			address.setId(Integer.parseInt(id));
			address.setStudent(student);
			student.setAddress(address);
			service.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "Something went wrong, Please try again ");
			model.addAttribute("studentid", id);
			model.addAttribute("status", true);
			model.addAttribute("link", "list");
			return "success";
		}

		model.addAttribute("success", "Student " + student.getFirstname() + " updated successfully");
		model.addAttribute("studentid", id);
		model.addAttribute("status", true);
		model.addAttribute("link", "list");
		return "success";
	}

	@RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Integer id,ModelMap model) {
		service.deleteStudentById(id);
		model.addAttribute("success", "Delete student id: " + id + " successfully");
		model.addAttribute("studentid", id);
		model.addAttribute("status", true);
		model.addAttribute("link", "list");
		return "success";
	}

	// This method try to get score table of this student

	@RequestMapping(value = { "/score-{id}-student" }, method = RequestMethod.GET)
	public String scoreStudent(@PathVariable Integer id, ModelMap model) {
		Student student = service.findById(id);
		List<Score> scores = scoreService.findAllScoresByIdStudent(id);
		model.addAttribute("student", student);
		model.addAttribute("scores", scores);
		model.addAttribute("avgscore", scoreService.avgScoreByIdStudent(id));
		return "allscore";
	}

	// This method delete a score by score_id

	@RequestMapping(value = { "/delete-{id}-score-{score_id}" }, method = RequestMethod.GET)
	public String deleteScore(@PathVariable Integer id, @PathVariable Integer score_id, ModelMap model) {
		scoreService.deleteScoreById(score_id);
		model.addAttribute("success", "Delete successed");
		model.addAttribute("studentid", id);
		model.addAttribute("status", false);
		model.addAttribute("link", "score-"+id+"-student");
		return "success";
	}

	@RequestMapping(value = { "/edit-{id}-score-{score_id}" }, method = RequestMethod.GET)
	public String editScore(@PathVariable Integer id, @PathVariable Integer score_id, ModelMap model) {
		Score score = scoreService.findById(score_id);
		model.addAttribute("score", score);
		model.addAttribute("edit", true);
		return "addscore";
	}

	@RequestMapping(value = { "/edit-{id}-score-{score_id}" }, method = RequestMethod.POST)
	public String updateScore(@Valid Score score, BindingResult result, @PathVariable Integer id,
			@PathVariable Integer score_id, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		Student student = service.findById(id);
		score.setStudent(student);
		scoreService.updateScore(score);

		model.addAttribute("success", "Score " + score.getSubject() + " edited successfully");
		model.addAttribute("studentid", id);
		model.addAttribute("status", false);
		model.addAttribute("link", "score-"+id+"-student");
		return "success";
	}

	// This method to create a score

	@RequestMapping(value = { "/add-score" }, method = RequestMethod.GET)
	public String addScore(ModelMap model, @RequestParam("studentid") String id) {
		Score score = new Score();
		model.addAttribute("score", score);
		model.addAttribute("edit", false);
		return "addscore";
	}

	// This method to submit create a score

	@RequestMapping(value = { "/add-score" }, method = RequestMethod.POST)
	public String addScore(@Valid Score score, BindingResult result, ModelMap model,
			@RequestParam("studentid") String id) {

		if (result.hasErrors()) {
			return "registration";
		}
		Student student = service.findById(Integer.parseInt(id));
		score.setStudent(student);
		scoreService.saveScore(score);

		model.addAttribute("success", "Score " + score.getSubject() + " add successfully");
		model.addAttribute("studentid", id);
		model.addAttribute("status", false);
		model.addAttribute("link", "score-"+id+"-student");
		return "success";
	}

	@RequestMapping(value = { "/listsallcore" }, method = RequestMethod.GET)
	public String listAllScores(ModelMap model) {

		List<Score> scores = scoreService.findAllScores();
		model.addAttribute("scores", scores);
		return "allscore";
	}
}
