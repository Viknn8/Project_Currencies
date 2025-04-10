CREATE TABLE Currency (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    baseCurrency VARCHAR(100),
    priceChangeRange VARCHAR(100),
    description VARCHAR(100)
);
