DROP TABLE IF EXISTS player;
CREATE TABLE player (
  id INTEGER PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50),
  position VARCHAR(2) NOT NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);




