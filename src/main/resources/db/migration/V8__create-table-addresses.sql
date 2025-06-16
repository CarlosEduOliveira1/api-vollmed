CREATE TABLE addresses (
   id BIGINT AUTO_INCREMENT NOT NULL,
   addressable_id BIGINT NOT NULL,
   addressable_type VARCHAR(50) NOT NULL,

   street VARCHAR(100) NOT NULL,
   neighbourhood VARCHAR(100) NOT NULL,
   postcode VARCHAR(100) NOT NULL,
   city VARCHAR(100) NOT NULL,
   uf VARCHAR(2) NOT NULL,
   number VARCHAR(100),
   complement VARCHAR(100) NOT NULL,

   PRIMARY KEY (id),
   INDEX idx_addressable (addressable_type, addressable_id)
);