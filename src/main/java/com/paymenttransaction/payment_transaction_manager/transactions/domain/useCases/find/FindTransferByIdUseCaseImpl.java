package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.FindTransferByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer.TransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

public class FindTransferByIdUseCaseImpl implements FindTransferByIdUseCase {
    private final TransferPort transferPort;

    public FindTransferByIdUseCaseImpl(TransferPort transferPort) {
        this.transferPort = transferPort;
    }

    @Override
    public Transfer findTransferByIdUseCase(Long id) {
        return transferPort.getTransferById(id).orElseThrow(() -> new TransactionNotFoundException("Transfer not found"));
    }
}
