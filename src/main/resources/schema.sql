CREATE SCHEMA IF NOT EXISTS layer;
CREATE table IF NOT EXISTS CUSTOMERS
(
    id           SERIAL PRIMARY KEY,
    name         CHARACTER VARYING(30),
    surname      CHARACTER VARYING(30),
    age          INTEGER,
    phone_number CHARACTER VARYING(30)
);
CREATE table IF NOT EXISTS ORDERS
(
    id           SERIAL PRIMARY KEY,
    date         DATE,
    customer_id  INTEGER REFERENCES customers (id),
    age          INTEGER,
    product_name CHARACTER VARYING(30),
    amount       CHARACTER VARYING(30)
);