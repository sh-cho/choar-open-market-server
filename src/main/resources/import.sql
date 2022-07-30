INSERT INTO roles (role_name, description) VALUES ('ADMIN_USER', 'Admin :)');
INSERT INTO roles (role_name, description) VALUES ('NORMAL_USER', 'Just User :)');

--password: admin
INSERT INTO users (username, password) VALUES ('admin', '$2a$10$kWvHqRavgnilMEKxOHxsl.8MC351eqK2YCnupwRObcmaJ5F5HXKg2');
--password: hodu091l
INSERT INTO users (username, password) VALUES ('buyer1', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva');
INSERT INTO users (username, password) VALUES ('buyer2', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva');
INSERT INTO users (username, password) VALUES ('buyer3', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (4, 2);
