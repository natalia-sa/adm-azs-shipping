CREATE TABLE customer
(
    id BIGSERIAL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    name VARCHAR(101) NOT NULL,
    cnpj VARCHAR(14),
    CONSTRAINT customer_id_pkey PRIMARY KEY (id),
    CONSTRAINT customer_cnpj_ukey UNIQUE (cnpj)
);