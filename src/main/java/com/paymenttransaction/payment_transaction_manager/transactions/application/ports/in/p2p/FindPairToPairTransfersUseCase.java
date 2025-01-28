package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;

import java.util.List;

public interface FindPairToPairTransfersUseCase {
    List<PairToPair> findPairToPairsByUserId(Long userId);
}
