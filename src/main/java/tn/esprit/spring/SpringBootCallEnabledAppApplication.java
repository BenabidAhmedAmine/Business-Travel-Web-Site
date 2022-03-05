package tn.esprit.spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

private final static String SID_ACCOUNT = "AC5ec68af72fd551b17589a349af927292";
private final static String AUTH_ID = "524ee9a2f42851dbdc6d758050473b1e";
private final static String FROM_NUMBER="+16812525654";
private final static String TO_NUMBER =" +21696910220";

static {
Twilio.init(SID_ACCOUNT, AUTH_ID);
}

public static void main(String[] args) {
SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
}

@Override
public void run(ApplicationArguments args) throws Exception {
Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
new com.twilio.type.Twiml("<Response><Say>New Publicity </Say></Response>"))
        .create();

}
}
