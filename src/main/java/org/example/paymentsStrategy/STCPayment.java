package org.example.paymentsStrategy;

//Parts of the code have been quoted from this source='https://cpit252.gitlab.io/labs/lab-10/'
public class STCPayment implements Payment {

    private String phoneNum;

    public STCPayment(String phoneNum){
        this.phoneNum=phoneNum;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + "is paid using STCPay.");
    }
}
