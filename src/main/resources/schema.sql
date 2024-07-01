CREATE TABLE IF NOT EXISTS customer (
    id       VARCHAR(60)  PRIMARY KEY,
    full_names     VARCHAR      NOT NULL,
    account_number     VARCHAR      NOT NULL,
    email_address     VARCHAR      NOT NULL,
    aval_bal     VARCHAR      NOT NULL
);