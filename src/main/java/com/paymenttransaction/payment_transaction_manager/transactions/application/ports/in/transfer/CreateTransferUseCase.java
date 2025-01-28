package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;

public interface CreateTransferUseCase {
    Transfer execute(Transfer transfer);
}
