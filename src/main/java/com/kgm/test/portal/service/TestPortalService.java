package com.kgm.test.portal.service;

import org.springframework.stereotype.Component;
import com.kgm.test.portal.model.Response;
import com.kgm.test.portal.model.TestPortalModel;

@Component
public interface TestPortalService {

	public Response insertUser(TestPortalModel model);

	public Response randomQuestions();

	public Response sendOTP(String toEmail);
}