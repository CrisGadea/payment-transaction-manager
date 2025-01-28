package com.paymenttransaction.payment_transaction_manager.transactions.domain.services;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.CreatePairToPairTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransferByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PairToPairService implements CreatePairToPairTransferUseCase, FindPairToPairTransferByIdUseCase, FindPairToPairTransfersUseCase {
    private static final Logger log = LoggerFactory.getLogger(PairToPairService.class);

    private final CreatePairToPairTransferUseCase createPairToPairUseCase;
    private final FindPairToPairTransferByIdUseCase findPairToPairByIdUseCase;
    private final FindPairToPairTransfersUseCase findPairToPairsUseCase;

    public PairToPairService(CreatePairToPairTransferUseCase createPairToPairUseCase,
                             FindPairToPairTransferByIdUseCase findPairToPairByIdUseCase,
                             FindPairToPairTransfersUseCase findPairToPairsUseCase){
        this.createPairToPairUseCase = createPairToPairUseCase;
        this.findPairToPairByIdUseCase = findPairToPairByIdUseCase;
        this.findPairToPairsUseCase = findPairToPairsUseCase;
    }

    @Override
    public PairToPair execute(PairToPair pairToPair) {
        log.info("Creating pairToPair: {}", pairToPair);
        return createPairToPairUseCase.execute(pairToPair);
    }

    @Override
    public PairToPair findPairToPairById(Long id) {
        log.info("Finding pairToPair by id: {}", id);
        return findPairToPairByIdUseCase.findPairToPairById(id);
    }

    @Override
    public List<PairToPair> findPairToPairsByUserId(Long userId) {
        log.info("Finding all pairToPairs");
        return findPairToPairsUseCase.findPairToPairsByUserId(userId);
    }
}
