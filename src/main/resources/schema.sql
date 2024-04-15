CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status ENUM('TODO', 'IN_PROGRESS', 'DONE') NOT NULL,
    priority INT NOT NULL,
    due_date DATE,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE History (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    task_id INT,
    changed_field VARCHAR(255),
    old_value TEXT,
    new_value TEXT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
);

CREATE TABLE Notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    task_id INT,
    user_id INT,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
