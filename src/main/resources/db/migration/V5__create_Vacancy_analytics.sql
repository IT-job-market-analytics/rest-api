CREATE TABLE Vacancy_analytics
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    date             DATE UNIQUE NOT NULL,
    query            VARCHAR(255) UNIQUE,
    vacancy_count    INT,
    average_salary   decimal
);

