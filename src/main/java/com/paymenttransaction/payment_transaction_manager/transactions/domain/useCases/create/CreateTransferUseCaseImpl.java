package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.CreateTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer.TransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;

public class CreateTransferUseCaseImpl implements CreateTransferUseCase {
    private final TransferPort transferPort;
    private final CompensationProducer compensationProducer;

    public CreateTransferUseCaseImpl(
            TransferPort transferPort,
            CompensationProducer compensationProducer
    ) {
        this.transferPort = transferPort;
        this.compensationProducer = compensationProducer;
    }

    @Override
    public Transfer execute(Transfer transfer) {
        try {
            return transferPort.createTransfer(transfer);
        } catch (Exception ex) {
            compensationProducer.sendCompensationEvent(
                    new CompensationEvent(transfer.getIdempotencyKey(), TransactionStatus.REFUNDED)
            );
            throw ex;
        }
    }
}
