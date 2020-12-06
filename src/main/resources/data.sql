DROP TABLE IF EXISTS arrival;

CREATE TABLE arrival
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(250) NOT NULL
);

INSERT INTO arrival (city)
VALUES ('Buenos Aires'),
       ('Rome'),
       ('London'),
       ('Berlin'),
       ('New York'),
       ('Dublin'),
       ('Cario');

