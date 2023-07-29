CREATE TABLE users(
    id BIGINT PRIMARY KEY,
    username VARCHAR(20) not null unique,
    password VARCHAR(50) not null
)