CREATE TABLE cart (
    cart_id VARCHAR(36) NOT NULL PRIMARY KEY,
    client_id VARCHAR(36),
    product_id VARCHAR(36),
    date VARCHAR(10),
    time VARCHAR(8),

    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
