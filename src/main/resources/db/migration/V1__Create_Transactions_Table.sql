CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              user_id VARCHAR(255) NOT NULL,
                              amount DECIMAL(15, 2) NOT NULL,
                              currency VARCHAR(3) NOT NULL,
                              transaction_type VARCHAR(50) NOT NULL,
                              status VARCHAR(50) NOT NULL,
                              idempotency_key VARCHAR(255) UNIQUE NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);