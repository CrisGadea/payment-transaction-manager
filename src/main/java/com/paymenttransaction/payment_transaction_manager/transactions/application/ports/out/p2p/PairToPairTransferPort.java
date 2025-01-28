package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;

import java.util.List;
import java.util.Optional;

public interface PairToPairTransferPort {
    PairToPair createPairToPair(PairToPair card);
    Optional<PairToPair> getPairToPairById(Long id);
    Optional<List<PairToPair>> getPairToPairTransfers(Long userId);
    TransactionStatus getTransactionStatusById(Long id);
}
