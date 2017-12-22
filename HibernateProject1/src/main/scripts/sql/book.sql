-- book.sql

DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80),
    pageCount INT,
    author VARCHAR(80),
    PRIMARY KEY ( id )
);


INSERT INTO book (name, pageCount, author)
  VALUES
    ('Wuthering Heights', 105, 'Emily Bronte'),
    ('20,000 Leagues Under the Sea', 423, 'Jules Verne'),
    ('The Three Musketeers', 736, ' Alexandre Dumas')
;
