-- INSERT INTO roles (role_name, description) VALUES ('BUYER', 'I am buyer :)');
-- INSERT INTO roles (role_name, description) VALUES ('SELLER', 'I am seller! :)');

--password: admin
--example JWT: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOlsiQURNSU5fVVNFUiJdLCJleHAiOjE2NTk3NzQ0MjR9.fyuWlu55LUJ0Zhr7y0TeGYXnguKHiH4qLTUb7GHQNFFK3PlTKsAJiQVVbs8BpxJuO3_lfQHkZ3LCaz5z0NO-PQ
-- INSERT INTO users (username, password) VALUES ('admin', '$2a$10$kWvHqRavgnilMEKxOHxsl.8MC351eqK2YCnupwRObcmaJ5F5HXKg2');

--password: hodu0910
--example JWT: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJidXllcjEiLCJhdXRoIjpbIk5PUk1BTF9VU0VSIl0sImV4cCI6MTY1OTc1OTA0Nn0.bxFynRjc6fKWNbjg1hfiGH48yXXujxE4Ygihd29vxOqb5QEdVcrlxZSoCCNzoI-0-k84fo7E5ytH2jNKANff7Q
INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('buyer1', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER', 'buyer1@example.com', '01011112222');
INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('buyer2', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER', 'buyer2@example.com', '01022223333');
INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('buyer3', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'BUYER', 'buyer3@example.com', '01033334444');

INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('seller1', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER', 'seller1@example.com', '01012341234');
INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('seller2', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER', 'seller2@example.com', '01044443333');
INSERT INTO users (username, password, role_name, email, phone_number) VALUES ('seller3', '$2a$10$6lPf1U2/FGKk28lpwzhlQe3rkv2KAo3xImvP7lHDT6xihB4d9epva', 'SELLER', 'seller3@example.com', '01098761231');
