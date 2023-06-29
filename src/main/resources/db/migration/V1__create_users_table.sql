DROP TABLE IF EXISTS users;

CREATE TABLE Users
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    username         VARCHAR(255) NOT NULL,
    telegram_chat_id INT
);

CREATE INDEX idx_username ON Users (username);