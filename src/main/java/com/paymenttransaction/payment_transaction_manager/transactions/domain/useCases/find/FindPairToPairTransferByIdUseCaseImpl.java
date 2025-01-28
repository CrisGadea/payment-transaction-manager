package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransferByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p.PairToPairTransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

public class FindPairToPairTransferByIdUseCaseImpl implements FindPairToPairTransferByIdUseCase {
    private final PairToPairTransferPort pairToPairTransferPort;

    public FindPairToPairTransferByIdUseCaseImpl(PairToPairTransferPort pairToPairTransferPort) {
        this.pairToPairTransferPort = pairToPairTransferPort;
    }

    @Override
    public PairToPair findPairToPairById(Long id) {
        return pairToPairTransferPort.getPairToPairById(id).orElseThrow(() -> new TransactionNotFoundException("Pair to pair transfer not found"));
    }
}
