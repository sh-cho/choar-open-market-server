-- INSERT INTO roles (role_name, description) VALUES ('BUYER', 'I am buyer :)');
-- INSERT INTO roles (role_name, description) VALUES ('SELLER', 'I am seller! :)');

--password: admin
--example JWT: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOlsiQURNSU5fVVNFUiJdLCJleHAiOjE2NTk3NzQ0MjR9.fyuWlu55LUJ0Zhr7y0TeGYXnguKHiH4qLTUb7GHQNFFK3PlTKsAJiQVVbs8BpxJuO3_lfQHkZ3LCaz5z0NO-PQ
-- INSERT INTO users (username, password) VALUES ('admin', '$2a$10$kWvHqRavgnilMEKxOHxsl.8MC351eqK2YCnupwRObcmaJ5F5HXKg2');

--password: hodu0910
--example JWT: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJidXllcjEiLCJhdXRoIjpbIk5PUk1BTF9VU0VSIl0sImV4cCI6MTY1OTc1OTA0Nn0.bxFynRjc6fKWNbjg1hfiGH48yXXujxE4Ygihd29vxOqb5QEdVcrlxZSoCCNzoI-0-k84fo7E5ytH2jNKANff7Q
INSERT INTO users (username, password, role_name) VALUES ('buyer1', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER');
INSERT INTO users (username, password, role_name) VALUES ('buyer2', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER');
INSERT INTO users (username, password, role_name) VALUES ('buyer3', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER');

INSERT INTO users (username, password, role_name) VALUES ('seller1', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER');
INSERT INTO users (username, password, role_name) VALUES ('seller2', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER');
INSERT INTO users (username, password, role_name) VALUES ('seller3', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER');
