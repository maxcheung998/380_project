CREATE TABLE users (
 username VARCHAR(50) NOT NULL,
 password VARCHAR(50) NOT NULL,
status Integer default 0,
 PRIMARY KEY (username)
);

CREATE TABLE user_roles (
 user_role_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 username VARCHAR(50) NOT NULL,
 role VARCHAR(50) NOT NULL,
 PRIMARY KEY (user_role_id),
 FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users VALUES ('max', 'pw');
INSERT INTO user_roles(username, role) VALUES ('max', 'ROLE_USER');
INSERT INTO user_roles(username, role) VALUES ('max', 'ROLE_ADMIN');

INSERT INTO users VALUES ('ken', 'pw');
INSERT INTO user_roles(username, role) VALUES ('ken', 'ROLE_USER');

CREATE TABLE poll (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    question VARCHAR(255) NOT NULL,
    choice_1 VARCHAR(255), 
    choice_2 VARCHAR(255), 
    choice_3 VARCHAR(255), 
    choice_4 VARCHAR(255), 
    PRIMARY KEY (id)
);

CREATE TABLE poll_result (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    pollid INTEGER DEFAULT NULL,
    selected VARCHAR(255) NOT NULL,
    PRIMARY KEY (id), 
    FOREIGN KEY (pollid) REFERENCES poll(id), 
    FOREIGN KEY (username) REFERENCES users(username)
); 
