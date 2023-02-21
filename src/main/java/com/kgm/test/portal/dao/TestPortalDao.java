package com.kgm.test.portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.kgm.test.portal.model.Response;
import com.kgm.test.portal.model.TestPortalModel;
import com.kgm.test.portal.service.TestPortalService;

@Component
public class TestPortalDao implements TestPortalService {

	String url = "jdbc:mysql://127.0.0.1:3306/kgm";
	String username = "root";
	String password = "Root@123";

	@Override
	public Response insertUser(TestPortalModel model) {

		Response response = new Response();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		model.setUpdatedDate(date);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection(url, username, password);
					Statement statement = connection.createStatement();) {

				String insertQuery = "INSERT INTO user_registration_details(first_name,last_name,email,phone_no,counsellor_name,about_institute,native_city,residence_city,degree,employee_status,updated_date)\r\n"
						+ "VALUES('" + model.getFirstName() + "','" + model.getLastName() + "','" + model.getEmail()
						+ "'," + model.getPhoneNo() + ",'" + model.getCounsellorName() + "','"
						+ model.getAboutInstitute() + "','" + model.getNativeCity() + "','" + model.getResidenceCity()
						+ "','" + model.getDegree() + "','" + model.getEmployeeStatus() + "','" + model.getUpdatedDate()
						+ "');";

				System.out.println("-----------Insert Query " + insertQuery);
				statement.executeUpdate(insertQuery);

				response.setResponseCode(200);
				response.setResponseMsg("success");
			} catch (Exception e) {
				e.printStackTrace();
				response.setResponseCode(500);
				response.setResponseMsg("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Response sendOTP(String toEmail) {

		Response response = new Response();

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(random.nextInt(10));
		}
		String otp = sb.toString();
		System.out.println("OTP is : " + otp);

		try {

			String fromEmail = "johnpauljayakumar08@gmail.com";
			String sendText = "Greetings, \n \t Thanks for registering, your otp is " + otp
					+ ". Have a good day! \n\n\n Thanks & regards, \n KGMicrocollege";
			String sendSubject = "OTP From KGMicrocollege";

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			message.setTo(toEmail);
			message.setText(sendText);
			message.setSubject(sendSubject);

//			System.out.println("The Message Is : " + message);

			mailSender.send(message);

//			System.out.println("The Mail Sender Is : " + mailSender);

			response.setResponseCode(200);
			response.setResponseMsg("success");
			response.setjData(otp);
		} catch (Exception e) {
			e.printStackTrace();
			response.setResponseCode(500);
			response.setResponseMsg("failure");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response randomQuestions() {

		Response response = new Response();
		String selectQuery = "SELECT * FROM question_bank where levels = 'n1' ORDER BY RAND() LIMIT 5;";
		System.out.println("Select Query For Questions" + selectQuery);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			JSONArray jsonArray = new JSONArray();
//			JSONArray jsonArray1 = new JSONArray();

			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement ps = connection.prepareStatement(selectQuery);
					ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
//					JSONObject jsonObject1 = new JSONObject();

//					boolean bool;

//					jsonObject.put("questionText", rs.getString("questions"));
//					jsonObject1.put("answerText", rs.getString("option_a"));
//					jsonObject1.put("answerText", rs.getString("option_b"));
//					jsonObject1.put("answerText", rs.getString("option_c"));
//					jsonObject1.put("answerText", rs.getString("option_d"));
//					jsonObject.put("isCorrect", rs.getString("answer"));
//					jsonObject1.put("isCorrect", rs.getString("answer"));
//					jsonObject1.put("isCorrect", bool = (rs.getString("option_a").equals(rs.getString("answer")))?true:false);
//					jsonArray1.add(jsonObject1);
//					jsonObject.put("answerOptions", jsonArray1);
//					jsonArray.add(jsonObject);

					jsonObject.put("questionText", rs.getString("questions"));
					jsonObject.put("Option-A", rs.getString("option_a"));
					jsonObject.put("Option-B", rs.getString("option_b"));
					jsonObject.put("Option-C", rs.getString("option_c"));
					jsonObject.put("Option-D", rs.getString("option_d"));
					jsonObject.put("Answer", rs.getString("answer"));
					jsonArray.add(jsonObject);
				}

				response.setjData(jsonArray);
				response.setResponseCode(200);
				response.setResponseMsg("success");
			} catch (Exception e) {
				e.printStackTrace();
				response.setResponseCode(500);
				response.setResponseMsg("failure");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public Response insertMarks(TestPortalModel model) {

		Response response = new Response();

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {

			String insertMarksQuery = "INSERT INTO students_progress_details (students_progress_details_id, numeric_basic, numeric_intermediate, numeric_advanced, verbal_basic, verbal_intermediate, verbal_advanced, communication, updated_by, updated_date) "
					+ "VALUES (" + model.getStudentsProgressDetailsId() + ", ' " + model.getNumericBasic() + " ', ' "
					+ model.getNumericIntermediate() + " ', ' " + model.getNumericAdvanced() + " ', ' "
					+ model.getVerbalBasic() + " ', ' " + model.getVerbalIntermediate() + " ', ' "
					+ model.getVerbalAdvanced() + " ', ' " + model.getCommunication() + " ', ' " + model.getUpdatedBy()
					+ " ', ' " + model.getUpdatedDate() + " ');";

			System.out.println("Insert Marks Query " + insertMarksQuery);
			statement.executeUpdate(insertMarksQuery);

			response.setResponseCode(200);
			response.setResponseMsg("success");

		} catch (Exception e) {
			e.printStackTrace();
			response.setResponseCode(500);
			response.setResponseMsg("failure");
		}

		return response;
	}

	@Override
	public Response updateMarks(int sId, String communication, String updatedBy) {

		Response response = new Response();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {

			String updateQuery = "UPDATE students_progress_details SET communication = ' " + communication + " ', updated_by = ' " + updatedBy + " ', updated_date = ' " + date + " ' WHERE students_progress_details_id = " + sId + ";";
			
			System.out.println("Update Mark Query " + updateQuery);			
			statement.executeUpdate(updateQuery);
			
			response.setResponseCode(200);
			response.setResponseMsg("success");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setResponseCode(500);
			response.setResponseMsg("failure");
		}

		return response;
	}

}
