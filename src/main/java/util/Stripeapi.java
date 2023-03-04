package util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.checkout.SessionCreateParams;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Stripeapi {
    public void Payer(String montant) {
        String cardNumber ;
        int expMonth ;
        int expYear ;
        String cvc ;

        // Verify the card using the Stripe API

            Stripe.apiKey = "sk_test_51MgCPXKJx2ljBQl3EIxLiyZEKush4tOgcLj9PzUtbqP5vLDDOgyfRQVXxYJOJwF4w36CZpLLFBB8t71hZrTRZUCr00Q6asBogP"; // Replace with your actual secret API key.

        Map<String, Object> chargeParam = new HashMap<String,Object>();
        chargeParam.put("amount",montant);
        chargeParam.put("currency","usd");
        chargeParam.put("customer","cus_NR5HqQQzFnoKA9");


        try {
            Charge.create(chargeParam);
            System.out.println("transaction done");
        } catch (StripeException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }
                /*com.stripe.model.Card card = new com.stripe.model.Card();
                card.setNumber(cardNumber);
                card.setExpMonth(expMonth);
                card.setExpYear(expYear);
                card.setCvc(cvc);
                card.verify();*/


    }
        public void verifyCardAndPay(/*String email*/ String cardNumber, int expMonth, int expYear, String cvc /* String customerId*/,String montant , String cardholderName) throws StripeException {


            Stripe.apiKey = "sk_test_51MgCPXKJx2ljBQl3EIxLiyZEKush4tOgcLj9PzUtbqP5vLDDOgyfRQVXxYJOJwF4w36CZpLLFBB8t71hZrTRZUCr00Q6asBogP";

            // Retrieve the customer and their saved card
           /* Map<String, Object> cardParams = new HashMap<String, Object>();
            cardParams.put("number", cardNumber);
            cardParams.put("exp_month", expMonth);
            cardParams.put("exp_year", expYear);
            cardParams.put("cvc", cvc);*


            Map<String, Object> tokenParams = new HashMap<String, Object>();
            tokenParams.put("card", cardParams);
            Token token = Token.create(tokenParams);

            // retrieve the customer's saved card and verify if it matches the entered card
            Customer customer = Customer.retrieve("cus_NR5HqQQzFnoKA9");
            System.out.println(customer);
            System.out.println(customer.getDefaultSource());
            String cusCardid = customer.getDefaultSource();
            //Card c = Card.retrieve(cusCardid);
            //Card card = com.stripe.model.Card.retrieve("card_1MgDD3KJx2ljBQl3SV0F0Aey");
            //System.out.println(card.getNumber());


            //cusCardid.
            //System.out.println(token.getCard());

        /*if (cusCardid.equals(token.getCard().getLast4())
                && savedCard.getExpMonth().equals(token.getCard().getExpMonth())
                && savedCard.getExpYear().equals(token.getCard().getExpYear())==true){
            etat=true;
            return etat;
        }*/
            //Stripe.apiKey = "YOUR_API_KEY";

        /*try {
            // Retrieve the customer with the given ID
            Customer customer = Customer.retrieve("cus_NR5HqQQzFnoKA9");

            // Verify the customer's email address
            if (!customer.getEmail().equals(email)) {
                System.out.println("nope");
                return false;
            }
            // If no matching card is found, return false

        } catch (StripeException e) {
            // Handle any errors that may occur while communicating with Stripe
            e.printStackTrace();
            return false;
        }*/
// Get card details from the JavaFX form


// Create a test charge with the card details
        /*    Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", montant); // Charge amount in cents
            chargeParams.put("currency", "usd"); // Charge currency
            chargeParams.put("source", Map.of(
                    "object", "card",
                    "number", cardNumber,
                    "exp_month", expMonth,
                    "exp_year", expYear,
                    "cvc", cvc
            ));

            try {
                Charge charge = Charge.create(chargeParams);
                System.out.println("Charge succeeded!");
            } catch (StripeException e) {
                System.out.println("Charge failed: " + e.getMessage());
            }*/
            // Create a test token for a Visa card

            Map<String, Object> cardParams = new HashMap<>();
            cardParams.put("number", cardNumber);
            cardParams.put("exp_month", expMonth);
            cardParams.put("exp_year", expYear);
            cardParams.put("cvc", cvc);
            cardParams.put("name", cardholderName);
            Map<String, Object> tokenParams = new HashMap<>();
            tokenParams.put("card", cardParams);

            try {
                Token token = Token.create(tokenParams);


                // Use the test token ID to create a charge
                Map<String, Object> chargeParams = new HashMap<>();
                chargeParams.put("amount", montant); // Charge amount in cents
                chargeParams.put("currency", "usd"); // Charge currency
                chargeParams.put("description", "Test charge");
                chargeParams.put("source", token.getId());

                Charge charge = Charge.create(chargeParams);
                System.out.println("Charge succeeded!");
            } catch (StripeException e) {
                System.out.println("Charge failed: " + e.getMessage());
            }


        }}




