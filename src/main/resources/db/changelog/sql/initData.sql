CREATE TABLE "USER" (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    birth_date DATE,
    role VARCHAR(50),
    status VARCHAR(50),
    created_date TIMESTAMP,
    last_login_date TIMESTAMP,
    modified_date TIMESTAMP
);

CREATE TABLE TASK (
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    priority VARCHAR(50),
    due_date TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES "USER"(user_id) ON UPDATE CASCADE
);

INSERT INTO "USER" (user_name, password, email, birth_date, role, status, created_date, last_login_date, modified_date)
VALUES ('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('test', 'test', 'test@gmail.com', '1990-12-12', '1', '1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TASK (user_id, title, description, status, priority, due_date, created_at, updated_at)
VALUES ( 1, 'test1', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 1, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 2, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 2, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 3, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 3, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 4, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 4, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 5, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 5, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 6, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 6, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 7, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 7, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 8, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 8, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 9, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 9, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 10, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ( 10, 'test2', 'test', '1', '3', '2024-05-12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);