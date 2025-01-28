package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.FindTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer.TransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

import java.util.List;

public class FindTransfersUseCaseImpl implements FindTransfersUseCase {
    private final TransferPort transferPort;

    public FindTransfersUseCaseImpl(TransferPort transferPort) {
        this.transferPort = transferPort;
    }

    @Override
    public List<Transfer> execute(Long userId) {
        return transferPort.getTransfers(userId).orElseThrow(() -> new TransactionNotFoundException("Transfers not found"));
    }
}
