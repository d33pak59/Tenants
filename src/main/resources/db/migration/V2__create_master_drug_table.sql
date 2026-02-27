CREATE TABLE master_drug_list (
                                  id          UUID            PRIMARY KEY,
                                  drug_code   VARCHAR(100)    NOT NULL UNIQUE,
                                  drug_name   VARCHAR(255)    NOT NULL,
                                  price       INTEGER         NOT NULL
);