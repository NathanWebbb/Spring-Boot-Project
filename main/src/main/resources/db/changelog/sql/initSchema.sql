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

CREATE TABLE VERIFICATION (
    verification_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    code VARCHAR(50)
)