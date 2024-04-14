CREATE TABLE customer_freight
(
    id BIGSERIAL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    customer_id BIGINT NOT NULL,
    freight_properties JSON NOT NULL,
    CONSTRAINT customer_freight_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE,
    CONSTRAINT customer_freight_pkey PRIMARY KEY (id),
    CONSTRAINT customer_freight_customer_id_ukey UNIQUE (customer_id)
);