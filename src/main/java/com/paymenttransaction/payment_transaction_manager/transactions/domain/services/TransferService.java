package com.paymenttransaction.payment_transaction_manager.transactions.domain.services;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.CreateTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.FindTransferByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.FindTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.InvalidTransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TransferService implements CreateTransferUseCase, FindTransferByIdUseCase, FindTransfersUseCase {
    private static final Logger log = LoggerFactory.getLogger(TransferService.class);

    private final CreateTransferUseCase createTransferUseCase;
    private final FindTransferByIdUseCase findTransferByIdUseCase;
    private final FindTransfersUseCase findTransfersUseCase;

    public TransferService(CreateTransferUseCase createTransferUseCase,
                           FindTransferByIdUseCase findTransferByIdUseCase,
                           FindTransfersUseCase findTransfersUseCase) {
        this.createTransferUseCase = createTransferUseCase;
        this.findTransferByIdUseCase = findTransferByIdUseCase;
        this.findTransfersUseCase = findTransfersUseCase;
    }

    @Override
    public Transfer execute(Transfer transfer) {
        validateTransfer(transfer);
        return createTransferUseCase.execute(transfer);
    }

    private void validateTransfer(Transfer transfer){
        log.info("Validate transfer: {}", transfer);

        if (transfer.getAmount() == null || transfer.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException("The transfer amount must be greater than 0");
        }

        if (transfer.getCurrency() == null) {
            throw new InvalidTransactionException("Transfer currency is required");
        }
    }

    @Override
    public Transfer findTransferByIdUseCase(Long id) {
        return findTransferByIdUseCase.findTransferByIdUseCase(id);
    }

    @Override
    public List<Transfer> execute(Long userId) {
        return findTransfersUseCase.execute(userId);
    }
}
