package model.services;

public interface OnlinePaymentService {
	
	// Métodos interfac
	
	public double paymentFee(Double amount);
	public double interest(Double amount, Integer month);
	
	
}
