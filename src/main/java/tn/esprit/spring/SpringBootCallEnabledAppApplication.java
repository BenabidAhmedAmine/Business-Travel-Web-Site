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

private final static String SID_ACCOUNT = "AC009679356bf1107cf6132e73abda15f3";
private final static String AUTH_ID = "dd80b9afb1d16a6efd4bd63fe76fe6dd";
private final static String FROM_NUMBER="+17164513880";
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
