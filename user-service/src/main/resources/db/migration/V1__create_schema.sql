CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(255) UNIQUE NOT NULL,
                                    password VARCHAR(255) NOT NULL,
                                    email VARCHAR(255) UNIQUE NOT NULL,
                                    role ENUM('USER', 'ADMIN') NOT NULL
    );

CREATE TABLE IF NOT EXISTS utilisateur (
                                           id BIGINT PRIMARY KEY,
                                           FOREIGN KEY (id) REFERENCES user(id)
    );

CREATE TABLE IF NOT EXISTS admin (
                                     id BIGINT PRIMARY KEY,
                                     FOREIGN KEY (id) REFERENCES user(id)
    );
