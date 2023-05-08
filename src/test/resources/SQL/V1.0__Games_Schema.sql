DROP TABLE IF EXISTS user_answers;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS user_games;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS users;



CREATE TABLE users (
  user_pk INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL, 
  last_name VARCHAR(50) NOT NULL,
  username VARCHAR(50),
  PRIMARY KEY (user_pk)
);

CREATE TABLE games (
  game_pk INT UNSIGNED NOT NULL AUTO_INCREMENT,
  game_name TINYTEXT NOT NULL, 
  game_description TEXT,
  available_date_time TIMESTAMP NULL,
  lock_date_time TIMESTAMP NULL,
  created_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (game_pk)
);

CREATE TABLE user_games (
  user_pk INT UNSIGNED NOT NULL,
  game_pk INT UNSIGNED NOT NULL,
  FOREIGN KEY (user_pk) REFERENCES users (user_pk) ON DELETE CASCADE,
  FOREIGN KEY (game_pk) REFERENCES games (game_pk) ON DELETE CASCADE
);

CREATE TABLE questions (
  question_pk INT UNSIGNED NOT NULL AUTO_INCREMENT,
  game_pk INT UNSIGNED NOT NULL,
  question_order INT UNSIGNED NOT NULL,
  question_text TEXT NOT NULL,
  PRIMARY KEY (question_pk),
  FOREIGN KEY (game_pk) REFERENCES games (game_pk) ON DELETE CASCADE
);

CREATE TABLE answers (
  answers_pk INT UNSIGNED NOT NULL AUTO_INCREMENT,
  question_pk INT UNSIGNED NOT NULL,
  answer_order INT UNSIGNED NOT NULL,
  answer TINYTEXT,
  is_correct_answer BIT NOT NULL,
  special_notes TEXT NULL,
  PRIMARY KEY (answers_pk),
  FOREIGN KEY (question_pk) REFERENCES questions (question_pk) ON DELETE CASCADE
);


CREATE TABLE user_answers (
  user_pk INT UNSIGNED NOT NULL,
  answers_pk int UNSIGNED NOT NULL,
  FOREIGN KEY (user_pk) REFERENCES users (user_pk) ON DELETE CASCADE,
  FOREIGN KEY (answers_pk) REFERENCES answers (answers_pk) ON DELETE CASCADE
);





