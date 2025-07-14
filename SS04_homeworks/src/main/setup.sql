create database web_service_ss04_homeworks;
use web_service_ss04_homeworks;


insert into books (title, author, publisher, year)
values ('Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008),
       ('Effective Java', 'Joshua Bloch', 'Addison-Wesley', 2018),
       ('The Pragmatic Programmer', 'Andrew Hunt & David Thomas', 'Addison-Wesley', 1999),
       ('Design Patterns', 'Erich Gamma et al.', 'Addison-Wesley', 1994),
       ('Java Concurrency in Practice', 'Brian Goetz', 'Addison-Wesley', 2006),
       ('Refactoring', 'Martin Fowler', 'Addison-Wesley', 1999),
       ('Head First Design Patterns', 'Eric Freeman & Elisabeth Robson', 'O''Reilly Media', 2004),
       ('Spring in Action', 'Craig Walls', 'Manning', 2021),
       ('Introduction to Algorithms', 'Thomas H. Cormen et al.', 'MIT Press', 2009),
       ('Cracking the Coding Interview', 'Gayle Laakmann McDowell', 'CareerCup', 2015);



insert into flights (flight_number, departure, destination, price)
values ('VN101', 'Hà Nội', 'TP.HCM', 1200000),
       ('VN102', 'TP.HCM', 'Đà Nẵng', 900000),
       ('VN103', 'Đà Nẵng', 'Hà Nội', 1000000),
       ('VN104', 'Hà Nội', 'Huế', 850000),
       ('VN105', 'Huế', 'TP.HCM', 950000),
       ('VN106', 'Cần Thơ', 'Hà Nội', 1300000),
       ('VN107', 'Hà Nội', 'Cần Thơ', 1300000),
       ('VN108', 'TP.HCM', 'Nha Trang', 800000),
       ('VN109', 'Nha Trang', 'Đà Nẵng', 870000),
       ('VN110', 'TP.HCM', 'Phú Quốc', 1000000);


insert into categories (category_name, description)
values ('Vegetables', 'Fresh green vegetables'),
       ('Fruits', 'Seasonal and imported fruits'),
       ('Meat', 'Beef, pork, chicken...'),
       ('Seafood', 'Shrimp, fish, squid, etc.'),
       ('Dairy', 'Milk, cheese, yogurt');


insert into food_items (name, category_id, price, expiration_date)
values ('Broccoli', 1, 2.50, '2025-08-01'),
       ('Carrot', 1, 1.20, '2025-08-03'),
       ('Apple', 2, 3.00, '2025-07-28'),
       ('Banana', 2, 2.00, '2025-07-25'),
       ('Chicken Breast', 3, 5.50, '2025-07-23'),
       ('Salmon Fillet', 4, 10.00, '2025-07-22'),
       ('Milk', 5, 2.20, '2025-08-05'),
       ('Yogurt', 5, 1.80, '2025-08-06'),
       ('Pork Chop', 3, 4.70, '2025-07-24'),
       ('Shrimp', 4, 7.90, '2025-07-26');

