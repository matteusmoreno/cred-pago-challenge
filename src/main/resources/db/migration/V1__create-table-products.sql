CREATE TABLE products (
    product_id VARCHAR(36) NOT NULL PRIMARY KEY,
    artist VARCHAR(255),
    year VARCHAR(4),
    album VARCHAR(255),
    price INT,
    store VARCHAR(255),
    thumb VARCHAR(255),
    date VARCHAR(10)
);
