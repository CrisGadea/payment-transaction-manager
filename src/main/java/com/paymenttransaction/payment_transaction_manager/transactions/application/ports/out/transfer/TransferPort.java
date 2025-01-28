package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferPort {
    Transfer createTransfer(Transfer card);
    Optional<Transfer> getTransferById(Long id);
    Optional<List<Transfer>> getTransfers(Long userId);
}
