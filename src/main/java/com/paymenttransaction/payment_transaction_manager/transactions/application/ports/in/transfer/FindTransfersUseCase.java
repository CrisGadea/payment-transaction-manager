package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;

import java.util.List;

public interface FindTransfersUseCase {
    List<Transfer> execute(Long userId);
}
