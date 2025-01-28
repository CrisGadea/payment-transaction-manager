package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer.TransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransferEntity;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransferEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransferMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransferRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class TransferAdapter implements TransferPort {

    private final TransferRepository transferRepository;
    private final TransferEntityMapper transferMapper;

    public TransferAdapter(TransferRepository transferRepository, TransferEntityMapper transferMapper) {
        this.transferRepository = transferRepository;
        this.transferMapper = transferMapper;
    }

    @Override
    @Transactional
    public Transfer createTransfer(Transfer transfer) {
        return transferMapper.toModel(transferRepository.save(transferMapper.toEntity(transfer)));
    }

    @Override
    @Cacheable(value = "transfer", key = "#id")
    public Optional<Transfer> getTransferById(Long id) {
        return transferRepository.findById(id).map(transferMapper::toModel);
    }

    @Override
    @Cacheable(value = "transfers", key = "#userId")
    public Optional<List<Transfer>> getTransfers(Long userId) {
        return Optional.of(transferRepository.findAll().stream().map(transferMapper::toModel).toList());
    }

    @Override
    public TransactionStatus getTransactionStatusById(Long id) {
        return transferRepository.findById(id).map(TransferEntity::getStatus).orElse(null);
    }

}
