CREATE TABLE customers_addresses (
    customer_id BIGINT NOT NULL,
    address_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, address_id),
    CONSTRAINT fk_customer_addresses_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_customer_addresses_address
        FOREIGN KEY (address_id) REFERENCES addresses(id)
        ON DELETE CASCADE
);
