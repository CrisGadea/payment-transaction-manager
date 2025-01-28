# CREATE TABLE User (
#                       user_id VARCHAR(36) PRIMARY KEY,
#                       name VARCHAR(100) NOT NULL,
#                       email VARCHAR(100) UNIQUE NOT NULL,
#                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
# CREATE TABLE Currency (
#                           currency_id VARCHAR(36) PRIMARY KEY,
#                           code VARCHAR(3) UNIQUE NOT NULL,
#                           name VARCHAR(50) NOT NULL,
#                           exchange_rate DECIMAL(10, 4) NOT NULL
# );
#
# CREATE TABLE Merchant (
#                           merchant_id VARCHAR(36) PRIMARY KEY,
#                           name VARCHAR(100) NOT NULL,
#                           merchant_code VARCHAR(20) UNIQUE NOT NULL,
#                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
# CREATE TABLE Bank (
#                       bank_id VARCHAR(36) PRIMARY KEY,
#                       name VARCHAR(100) NOT NULL,
#                       bank_code VARCHAR(20) UNIQUE NOT NULL,
#                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
# CREATE TABLE TransactionType (
#                                  type_id VARCHAR(36) PRIMARY KEY,
#                                  name VARCHAR(50) UNIQUE NOT NULL
# );
#
# CREATE TABLE Transaction (
#                              transaction_id VARCHAR(36) PRIMARY KEY,
#                              user_id VARCHAR(36) NOT NULL, -- ID del usuario
#                              amount DECIMAL(18, 2) NOT NULL, -- Monto de la transacción
#                              currency VARCHAR(3) NOT NULL, -- Moneda
#                              status VARCHAR(20) NOT NULL, -- Estado de la transacción
#                              created_at TIMESTAMP NOT NULL -- Fecha de creación
# );
#
# CREATE TABLE CardTransaction (
#                                  transaction_id VARCHAR(36) PRIMARY KEY,
#                                  card_id VARCHAR(36) NOT NULL,
#                                  merchant_id VARCHAR(36),
#                                  mcc_code VARCHAR(20),
#                                  FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id),
#                                  FOREIGN KEY (merchant_id) REFERENCES Merchant(merchant_id)
# );
#
# CREATE TABLE BankTransferTransaction (
#                                          transaction_id VARCHAR(36) PRIMARY KEY,
#                                          bank_code VARCHAR(20),
#                                          recipient_account VARCHAR(50),
#                                          FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id),
#                                          FOREIGN KEY (bank_code) REFERENCES Bank(bank_id)
# );
#
# CREATE TABLE P2PTransaction (
#                                 transaction_id VARCHAR(36) PRIMARY KEY,
#                                 sender_id VARCHAR(36) NOT NULL,
#                                 recipient_id VARCHAR(36) NOT NULL,
#                                 note VARCHAR(255),
#                                 FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id)
# );