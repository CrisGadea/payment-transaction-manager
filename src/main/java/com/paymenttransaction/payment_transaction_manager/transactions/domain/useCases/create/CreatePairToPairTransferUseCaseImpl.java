package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.CreatePairToPairTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p.PairToPairTransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;

public class CreatePairToPairTransferUseCaseImpl implements CreatePairToPairTransferUseCase {

    private final PairToPairTransferPort pairToPairTransferPort;
    private final CompensationProducer compensationProducer;

    public CreatePairToPairTransferUseCaseImpl(
            PairToPairTransferPort pairToPairTransferPort,
            CompensationProducer compensationProducer
    ) {
        this.pairToPairTransferPort = pairToPairTransferPort;
        this.compensationProducer = compensationProducer;
    }

    @Override
    public PairToPair execute(PairToPair pairToPairTransfer) {
        try {
            return pairToPairTransferPort.createPairToPair(pairToPairTransfer);
        } catch (Exception ex) {
            compensationProducer.sendCompensationEvent(
                    new CompensationEvent(pairToPairTransfer.getIdempotencyKey(), TransactionStatus.REFUNDED)
            );
            throw ex;
        }
    }
}
