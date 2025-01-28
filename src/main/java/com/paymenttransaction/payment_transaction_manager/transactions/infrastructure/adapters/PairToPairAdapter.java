package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p.PairToPairTransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.PairToPairEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.PairToPairRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PairToPairAdapter implements PairToPairTransferPort {
    private final PairToPairRepository pairToPairRepository;
    private final PairToPairEntityMapper pairToPairMapper;

    public PairToPairAdapter(PairToPairRepository pairToPairRepository, PairToPairEntityMapper pairToPairMapper) {
        this.pairToPairRepository = pairToPairRepository;
        this.pairToPairMapper = pairToPairMapper;
    }

    @Override
    public PairToPair createPairToPair(PairToPair pairToPair) {
        return pairToPairMapper.toModel(pairToPairRepository.save(pairToPairMapper.toEntity(pairToPair)));
    }

    @Override
    public Optional<PairToPair> getPairToPairById(Long id) {
        return pairToPairRepository.findById(id).map(pairToPairMapper::toModel);
    }

    @Override
    public Optional<List<PairToPair>> getPairToPairTransfers(Long userId) {
        return Optional.of(pairToPairRepository.findAll().stream().map(pairToPairMapper::toModel).toList());
    }

}
