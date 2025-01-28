package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p.PairToPairTransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

import java.util.List;

public class FindPairToPairTransfersUseCaseImpl implements FindPairToPairTransfersUseCase {
    private final PairToPairTransferPort pairToPairTransferPort;

    public FindPairToPairTransfersUseCaseImpl(PairToPairTransferPort pairToPairTransferPort) {
        this.pairToPairTransferPort = pairToPairTransferPort;
    }

    @Override
    public List<PairToPair> findPairToPairsByUserId(Long userId) {
        return pairToPairTransferPort.getPairToPairTransfers(userId).orElseThrow(() -> new TransactionNotFoundException("Pair to pair transfers not found"));
    }
}
