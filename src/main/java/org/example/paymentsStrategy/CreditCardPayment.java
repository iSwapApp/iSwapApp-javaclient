package org.example.paymentsStrategy;

//Parts of the code have been quoted from this source='https://cpit252.gitlab.io/labs/lab-10/'
public class CreditCardPayment implements Payment{

    private String cardNum;
    private String YearExpiration;
    private String CVV;

    public CreditCardPayment(String cardNum, String yearExpiration, String CVV){
        this.cardNum=cardNum;
        this.YearExpiration=yearExpiration;
        this.CVV=CVV;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + "is paid with credit card.");

    }
}
