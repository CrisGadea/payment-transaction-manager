package com.paymenttransaction.payment_transaction_manager.config;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.CreateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.FindCurrencyByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.UpdateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.out.CurrencyPort;
import com.paymenttransaction.payment_transaction_manager.currency.domain.services.CurrencyService;
import com.paymenttransaction.payment_transaction_manager.currency.domain.useCases.CreateCurrencyUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.currency.domain.useCases.FindCurrencyByIdUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.currency.domain.useCases.UpdateCurrencyUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.adapters.CurrencyAdapter;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.mappers.CurrencyEntityMapper;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.repositories.CurrencyRepository;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.CreateCardUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardsUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.CreatePairToPairTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransferByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.p2p.FindPairToPairTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.CreateTransferUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.transfer.FindTransfersUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.p2p.PairToPairTransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.transfer.TransferPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.CardService;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.PairToPairService;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransferService;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create.CreateCardUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create.CreatePairToPairTransferUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create.CreateTransactionUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransactionService;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create.CreateTransferUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find.*;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters.CardAdapter;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters.PairToPairAdapter;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters.TransactionAdapter;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters.TransferAdapter;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.CardEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.PairToPairEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransferEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.CardRepository;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.PairToPairRepository;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransactionRepository;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransferRepository;
import com.paymenttransaction.payment_transaction_manager.users.application.ports.out.UserPort;
import com.paymenttransaction.payment_transaction_manager.users.domain.services.UserService;
import com.paymenttransaction.payment_transaction_manager.users.domain.useCases.CreateUserUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.adapters.UserAdapter;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers.UserEntityMapper;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.repositories.UserRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    public CreateTransactionUseCaseImpl createTransactionUseCaseImpl(TransactionPort transactionPort, CompensationProducer compensationProducer) {
        return new CreateTransactionUseCaseImpl(transactionPort, compensationProducer);
    }

    @Bean
    public CreateUserUseCaseImpl createUserUseCaseImpl(UserPort userPort){
        return new CreateUserUseCaseImpl(userPort);
    }

    @Bean
    public CreateCurrencyUseCase createCurrencyUseCaseImpl(CurrencyPort currencyPort){
        return new CreateCurrencyUseCaseImpl(currencyPort);
    }

    @Bean
    public FindCurrencyByIdUseCase findCurrencyByIdUseCaseImpl(CurrencyPort currencyPort){
        return new FindCurrencyByIdUseCaseImpl(currencyPort);
    }

    @Bean
    public UpdateCurrencyUseCase updateCurrencyUseCaseImpl(CurrencyPort currencyPort){
        return new UpdateCurrencyUseCaseImpl(currencyPort);
    }

    @Bean
    public CreateCardUseCase createCardUseCaseImpl(CardPort cardPort, CompensationProducer compensationProducer){
        return new CreateCardUseCaseImpl(cardPort, compensationProducer);
    }

    @Bean
    public FindCardByIdUseCase findCardByIdUseCaseImpl(CardPort cardPort){
        return new FindCardByIdUseCaseImpl(cardPort);
    }

    @Bean
    public FindCardsUseCase findCardsUseCaseImpl(CardPort cardPort){
        return new FindCardsUseCaseImpl(cardPort);
    }

    @Bean
    public CreatePairToPairTransferUseCase createPairToPairTransferUseCaseImpl(PairToPairTransferPort pairToPairTransferPort, CompensationProducer compensationProducer){
        return new CreatePairToPairTransferUseCaseImpl(pairToPairTransferPort, compensationProducer);
    }

    @Bean
    public FindPairToPairTransferByIdUseCase findPairToPairByIdUseCase(PairToPairTransferPort pairToPairTransferPort){
        return new FindPairToPairTransferByIdUseCaseImpl(pairToPairTransferPort);
    }

    @Bean
    public FindPairToPairTransfersUseCase findPairToPairsUseCase(PairToPairTransferPort pairToPairTransferPort){
        return new FindPairToPairTransfersUseCaseImpl(pairToPairTransferPort);
    }

    @Bean
    public CreateTransferUseCase createTransferUseCase(TransferPort transferPort, CompensationProducer compensationProducer){
        return new CreateTransferUseCaseImpl(transferPort, compensationProducer);
    }
    
    @Bean
    public FindTransferByIdUseCaseImpl findTransferByIdUseCaseImpl(TransferPort transferPort){
        return new FindTransferByIdUseCaseImpl(transferPort);
    }

    @Bean
    public FindTransfersUseCase findTransfersUseCase(TransferPort transferPort){
        return new FindTransfersUseCaseImpl(transferPort);
    }

    @Bean
    public TransactionService transactionService(CreateTransactionUseCaseImpl createTransactionUseCase) {
        return new TransactionService(createTransactionUseCase);
    }

    @Bean
    public CurrencyService currencyService(CreateCurrencyUseCase createCurrencyUseCaseImpl, FindCurrencyByIdUseCase findCurrencyByIdUseCaseImpl, UpdateCurrencyUseCase updateCurrencyUseCaseImpl){
        return new CurrencyService(createCurrencyUseCaseImpl, findCurrencyByIdUseCaseImpl, updateCurrencyUseCaseImpl);
    }

    @Bean
    public CardService cardService(CreateCardUseCase createCardUseCaseImpl, FindCardByIdUseCase findCardByIdUseCaseImpl, FindCardsUseCase findCardsUseCaseImpl){
        return new CardService(createCardUseCaseImpl, findCardByIdUseCaseImpl, findCardsUseCaseImpl);
    }

    @Bean
    public PairToPairService pairToPairService(CreatePairToPairTransferUseCase createTransactionUseCaseImpl,
                                               FindPairToPairTransferByIdUseCase findPairToPairByIdUseCase,
                                               FindPairToPairTransfersUseCase findPairToPairsUseCase){
        return new PairToPairService(createTransactionUseCaseImpl, findPairToPairByIdUseCase, findPairToPairsUseCase);
    }

    @Bean
    public UserService userService(CreateUserUseCaseImpl createUserUseCaseImpl){
        return new UserService(createUserUseCaseImpl);
    }

    @Bean
    public TransferService transferService(CreateTransferUseCase createTransferUseCase,
                                           FindTransferByIdUseCaseImpl findTransferByIdUseCaseImpl,
                                           FindTransfersUseCase findTransfersUseCase){
        return new TransferService(createTransferUseCase, findTransferByIdUseCaseImpl, findTransfersUseCase);
    }

    @Bean
    public TransactionPort transactionPort(TransactionAdapter transactionAdapter){
        return transactionAdapter;
    }

    @Bean
    public UserPort userPort(UserAdapter userAdapter) { return userAdapter; }

    @Bean
    public CardPort cardPort(CardAdapter cardAdapter) { return cardAdapter; }

    @Bean
    public PairToPairTransferPort pairToPairTransferPort(PairToPairAdapter pairToPairAdapter) { return pairToPairAdapter; }

    @Bean
    public TransferPort transferPort(TransferAdapter transactionAdapter) { return transactionAdapter; }

    @Bean
    public CurrencyPort currencyPort(CurrencyAdapter currencyService) { return currencyService; }

    @Bean
    public TransactionAdapter transactionAdapter(TransactionRepository repository, TransactionEntityMapper mapper){
        return new TransactionAdapter(repository, mapper);
    }

    @Bean
    public UserAdapter userAdapter(UserRepository repository, UserEntityMapper mapper){
        return new UserAdapter(repository, mapper);
    }

    @Bean
    public CardAdapter cardAdapter(CardRepository repository, CardEntityMapper mapper){
        return new CardAdapter(repository, mapper);
    }

    @Bean
    public PairToPairAdapter pairToPairAdapter(PairToPairRepository repository, PairToPairEntityMapper mapper){
        return new PairToPairAdapter(repository, mapper);
    }

    @Bean
    public TransferAdapter transferAdapter(TransferRepository repository, TransferEntityMapper mapper){
        return new TransferAdapter(repository, mapper);
    }

    @Bean
    public CurrencyAdapter currencyAdapter(CurrencyRepository repository, CurrencyEntityMapper mapper){
        return new CurrencyAdapter(repository, mapper);
    }

}
