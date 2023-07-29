CREATE TABLE todo
(
    id       BIGINT PRIMARY KEY,
    title    VARCHAR(50) not null,
    completed BOOLEAN not null,
    user_id BIGINT not null,
    FOREIGN KEY (user_id) REFERENCES users(id)
)


