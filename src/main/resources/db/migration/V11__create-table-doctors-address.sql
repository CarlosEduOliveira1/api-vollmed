CREATE TABLE doctors_addresses (
    doctor_id BIGINT NOT NULL,
    address_id BIGINT NOT NULL,
    PRIMARY KEY (doctor_id, address_id),
    CONSTRAINT fk_doctor_addresses_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctors(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_doctor_addresses_address
        FOREIGN KEY (address_id) REFERENCES addresses(id)
        ON DELETE CASCADE
);
