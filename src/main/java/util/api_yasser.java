package util;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class api_yasser {




        //    public static final String ACCOUNT_SID = System.getenv("AC0d38c511436eadf48ac03b413f251cbb");
//    public static final String AUTH_TOKEN = System.getenv("28b08adf773c0df3f314fc80c562026a");
        public static final String ACCOUNT_SID = "AC1b8cf8bf86f9be9d1d1ed95f4df14782";
        public static final String AUTH_TOKEN = "f98cc005d7c09c130e3d8de53b66d91a";

        public static void main(String[] args) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(

                            new com.twilio.type.PhoneNumber("+21650660438"),

                            new com.twilio.type.PhoneNumber("+15674062139"),
                            "hello")
                    .create();

            System.out.println(message.getSid());}




}
