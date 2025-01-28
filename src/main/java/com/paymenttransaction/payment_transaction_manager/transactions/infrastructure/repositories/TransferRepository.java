package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
}
