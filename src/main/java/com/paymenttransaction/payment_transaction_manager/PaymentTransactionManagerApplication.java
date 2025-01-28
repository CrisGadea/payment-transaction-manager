package com.paymenttransaction.payment_transaction_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PaymentTransactionManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentTransactionManagerApplication.class, args);
	}

}
