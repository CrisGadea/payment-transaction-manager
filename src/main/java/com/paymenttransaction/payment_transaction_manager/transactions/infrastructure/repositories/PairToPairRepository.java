package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.PairToPairEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PairToPairRepository extends JpaRepository<PairToPairEntity, Long> {
}
