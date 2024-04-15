-- Insert Users
INSERT INTO Users (username, password, email) VALUES ('john_doe', 'password1', 'john.doe@example.com');
INSERT INTO Users (username, password, email) VALUES ('jane_doe', 'password2', 'jane.doe@example.com');
INSERT INTO Users (username, password, email) VALUES ('admin', '$$2a$12$uA2qBB1zbrlII5gNe7NqP.xMV7LSblbZl3BJOCqHY8iKyCJmU.AR.
', 'admin@example.com');

-- Insert Tasks
INSERT INTO Tasks (title, description, status, priority, due_date, user_id) VALUES ('Task 1', 'Description of Task 1', 'TODO', 1, '2024-01-01', 1);
INSERT INTO Tasks (title, description, status, priority, due_date, user_id) VALUES ('Task 2', 'Description of Task 2', 'IN_PROGRESS', 2, '2024-02-01', 2);

-- Insert History
INSERT INTO History (task_id, changed_field, old_value, new_value, changed_at) VALUES (1, 'status', 'TODO', 'IN_PROGRESS', NOW());
INSERT INTO History (task_id, changed_field, old_value, new_value, changed_at) VALUES (2, 'priority', 2, 1, NOW());

-- Insert Notifications
INSERT INTO Notifications (message, task_id, user_id, sent_at) VALUES ('Task 1 is due soon', 1, 1, NOW());
INSERT INTO Notifications (message, task_id, user_id, sent_at) VALUES ('Task 2 has been updated', 2, 2, NOW());
