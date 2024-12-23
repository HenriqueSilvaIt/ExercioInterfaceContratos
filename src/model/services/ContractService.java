package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	
	// Composicao
	private OnlinePaymentService onlinePaymentServices;
	private Contract contract;
	
	public ContractService(OnlinePaymentService onlinePaymentServices) {
		this.onlinePaymentServices = onlinePaymentServices;
	}
	
	public void processContract(Contract contract, Integer months ) {
		Double installmentValue = contract.getTotalValue() / months;
		
		for ( int i=1; i<=months; i++) {
			
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentServices.interest(installmentValue, i);
			double paymentFee = onlinePaymentServices.paymentFee(installmentValue +interest);
			Double quota = installmentValue + interest + paymentFee;
			contract.getList().add(new Installment(dueDate, quota));	
		}
		
	}
}
