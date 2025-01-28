package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

}
