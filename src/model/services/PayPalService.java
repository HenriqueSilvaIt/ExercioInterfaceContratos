package model.services;

public class PayPalService implements OnlinePaymentService {

	public static final double MONTHLY_INTEREST = 0.02;
	public static final double FEE_PERCENTAGE = 0.01;
	
	@Override
	public double paymentFee (Double amount) {
		return amount * FEE_PERCENTAGE;
	}
	
	@Override
	public double interest(Double amount, Integer month) {
		return 	amount * MONTHLY_INTEREST * month;
	}
}
