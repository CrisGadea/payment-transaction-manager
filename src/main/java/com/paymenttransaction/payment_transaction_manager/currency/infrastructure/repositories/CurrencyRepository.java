package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
}
