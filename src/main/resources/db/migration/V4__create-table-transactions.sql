CREATE TABLE transactions (
    transaction_id VARCHAR(36) PRIMARY KEY,
    client_id VARCHAR(36) NOT NULL,
    cart_id VARCHAR(36) NOT NULL,
    total_to_pay INT NOT NULL,
    credit_card_number VARCHAR(36) NOT NULL,

    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
    FOREIGN KEY (credit_card_number) REFERENCES credit_cards(card_number)
);
