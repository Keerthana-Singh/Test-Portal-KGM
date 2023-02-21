package com.kgm.test.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kgm.test.portal.dao.TestPortalDao;
import com.kgm.test.portal.model.Response;
import com.kgm.test.portal.model.TestPortalModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/kgm")
public class TestPortalController {

	@Autowired
	private TestPortalDao dao;

	@PostMapping("/user/insert")
	public ResponseEntity<Response> insertUser(@RequestBody TestPortalModel model) {
		return ResponseEntity.ok(dao.insertUser(model));
	}

	@PostMapping("/user/send/otp")
	public ResponseEntity<Response> sendOTP(@RequestParam String toEmail) {
		return ResponseEntity.ok(dao.sendOTP(toEmail));
	}

	@GetMapping("/get/questions")
	public ResponseEntity<Response> getQuestions() {
		return ResponseEntity.ok(dao.randomQuestions());
	}
	
	@PostMapping("/insert/marks")
	public ResponseEntity<Response> insertMarks(@RequestBody TestPortalModel model) {
		return ResponseEntity.ok(dao.insertMarks(model));
	}
	
	@PutMapping("/update/marks")
	public ResponseEntity<Response> updateMarks(@RequestParam int sId, @RequestParam String communication, @RequestParam String updatedBy) {
		return ResponseEntity.ok(dao.updateMarks(sId, communication, updatedBy));
	}
	
}
