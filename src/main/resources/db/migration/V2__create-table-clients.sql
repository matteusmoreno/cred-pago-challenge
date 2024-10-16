CREATE TABLE credit_cards (
    card_number VARCHAR(50) UNIQUE PRIMARY KEY,
    card_holder_name VARCHAR(150) NOT NULL,
    cvv VARCHAR(5) NOT NULL,
    exp_date VARCHAR(10) NOT NULL
);

CREATE TABLE clients (
    client_id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    card_number VARCHAR(50) NOT NULL,

    FOREIGN KEY (card_number) REFERENCES credit_cards(card_number)
);