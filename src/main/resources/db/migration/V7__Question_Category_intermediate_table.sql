CREATE TABLE Questions_Categories (
    question_id mediumint NOT NULL,
    category_id mediumint NOT NULL,
    PRIMARY KEY (question_id, category_id),
    FOREIGN KEY (question_id) REFERENCES Questions (id),
    FOREIGN KEY (category_id) REFERENCES Categories (id)
);