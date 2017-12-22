-- These tables describe the database of the Bank Account application.
-- Refer to "HOWTO.txt" for information on how to create the database user and
-- schema.


DROP TABLE IF EXISTS withdrawal;
DROP TABLE IF EXISTS deposit;
DROP TABLE IF EXISTS balance;



-- =========================
-- 1. Account Management
-- =========================
-- -------------------
-- Table balance
-- -------------------
CREATE TABLE balance (
    id SERIAL,
    uuid VARCHAR(40) UNIQUE NOT NULL,
    amount DOUBLE PRECISION,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- A preconfigured balance
INSERT INTO balance (id, uuid, amount) VALUES (1, 'f681d2e6-84f2-45ff-914c-522a3b076141', 30000);


-- -------------------
-- Table deposit
-- -------------------
CREATE TABLE deposit (
    id SERIAL,
    uuid VARCHAR(40) UNIQUE NOT NULL,
    record_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DOUBLE PRECISION,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Sample deposits
LOAD DATA LOCAL INFILE 'data/Deposits.csv' INTO TABLE deposit FIELDS TERMINATED BY '|' IGNORE 1 LINES
(uuid, record_date, amount);


-- -------------------
-- Table withdrawal
-- -------------------
CREATE TABLE withdrawal (
    id SERIAL,
    uuid VARCHAR(40) UNIQUE NOT NULL,
    record_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DOUBLE PRECISION,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Sample withdrawals
LOAD DATA LOCAL INFILE 'data/Withdrawals.csv' INTO TABLE withdrawal FIELDS TERMINATED BY '|' IGNORE 1 LINES
(uuid, record_date, amount);