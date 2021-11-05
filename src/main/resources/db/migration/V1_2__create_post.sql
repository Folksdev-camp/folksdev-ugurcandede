CREATE TABLE IF NOT EXISTS post
(
    id            VARCHAR(255) NOT NULL,
    title         VARCHAR(255),
    body          VARCHAR(255),
    creation_date TIMESTAMP,
    status        VARCHAR(255),
    user_id       VARCHAR(255),
    CONSTRAINT pk_post PRIMARY KEY (id)
);
