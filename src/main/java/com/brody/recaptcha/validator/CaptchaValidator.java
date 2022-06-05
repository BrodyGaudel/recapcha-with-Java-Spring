package com.brody.recaptcha.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brody.recaptcha.model.CaptchaResponse;

/**
 * This class is to check whether reCAPTCHA validated successfully or not. 
 * It will have one isValidCaptcha() method. 
 * In this we will make a rest consumer call to get response. 
 * This class has major configurations provided by Google.
 * Kindly observe URL and its parameters.
 * @author brody
 *
 */

@Component
public class CaptchaValidator {
	
	
	private RestTemplate restTemplate;

	public CaptchaValidator(RestTemplate restTemplate) {
	
		this.restTemplate = restTemplate;
	}
	
	public boolean isValidCaptcha(String captcha) {
		
		String url= "https://www.google.com/recaptcha/api/siteverify";
		String serverSideKey = "PLEASE READ APPLICATION.PROPERTIES";
		String params="?secret="+serverSideKey+"&response="+captcha;
		String completeUrl=url+params;
		CaptchaResponse resp= restTemplate.postForObject(completeUrl, null, CaptchaResponse.class);
		if(resp==null) {
			return false;
		}
		else {
			return resp.isSuccess();
		}
		
	}
	
	

}
