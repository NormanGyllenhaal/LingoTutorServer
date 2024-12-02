CREATE TABLE user
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    firebase_id   VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    details       VARCHAR(255),
    price         DOUBLE,
    lessons       INT,
    avatar        VARCHAR(255),
    role          INT,
    message_token VARCHAR(255),
    language      VARCHAR(255)
);

CREATE TABLE lesson
(
    id          INT AUTO_INCREMENT PRIMARY KEY, -- Automatically generates a unique id for each lesson
    tutor       INT          NOT NULL,          -- Foreign key for the tutor (assuming it references a User or Tutor table)
    student     INT          NOT NULL,          -- Foreign key for the student (assuming it references a User or Student table)
    title       VARCHAR(255) NOT NULL,          -- Title of the lesson
    subtitle    VARCHAR(255),                   -- Subtitle of the lesson (optional)
    description VARCHAR(255),                           -- Description of the lesson
    picture     VARCHAR(255),                   -- URL or file path to the lesson picture
    date_time    DATETIME     NOT NULL           -- Date and time of the lesson
);