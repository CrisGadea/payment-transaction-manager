package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;

public interface FindPairToPairTransferByIdUseCase {
    PairToPair findPairToPairById(Long id);
}
