CREATE TABLE freight
(
    id BIGSERIAL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    customer_freight_id BIGINT NOT NULL,
    properties JSON NOT NULL,
    CONSTRAINT freight_customer_freight_id_fkey FOREIGN KEY (customer_freight_id) REFERENCES customer_freight(id) ON DELETE CASCADE,
    CONSTRAINT freight_pkey PRIMARY KEY (id)
);