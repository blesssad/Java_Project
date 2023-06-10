CREATE TABLE IF NOT EXISTS users(
    user_id BIGINT PRIMARY KEY,
    user_name VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(20) default 'USER'
);