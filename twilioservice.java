package openin.assignment.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class twilioservice {
	
	
	   @Value("${twilio.account.sid}") // Add your Twilio Account SID 
	    private String accountSid;

	    @Value("${twilio.auth.token}") // Add your Twilio Auth Token
	    private String authToken;

	    @Value("${twilio.from.number}") // Add your Twilio phone number 
	    private String fromNumber;

	    public void sendSMS(String to, String message) {
	        Twilio.init(accountSid, authToken);

	        Message.creator(
	                new PhoneNumber(to),
	                new PhoneNumber(fromNumber),
	                message)
	                .create();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
