insert into cafe (name, city, address, phone, email, open, close)
values ('Losteria Dortmund', 'Dortmund', 'Friedensplatz 8', '+49 0231 58445524','dortmund@losteria.de','09:00','20:00'),
       ('Milano im Westend','Munster','Wilhelmstr. 26' , '+49 0251 25962555','mail@milano-westend.de','09:00','21:00'),
       ('Bella Mia','Waltrop','Dortmunderstr. 132' , '+49 0230 97820386','info@bella-mia.de','10:00','22:00');

insert into pizza (name, size, price, key_ingredients, cafe_id, image)
values ('Pizza Romano', 'Standard', 6.70, 'Tomato sauce, mozzarella, rosemary, semolina',1, '/img/marherita.jpeg'),
       ('Quattro Formaggi', 'Large', 11.30, 'Mozzarella, gorgonzola, fontina, parmiggiano',2, '/img/quattro_formagi.jpeg'),
       ('Pizza Peperoni', 'Standard', 7.65, 'Tomato sauce, pepperoni, ricotta',3, '/img/peperoni.jpeg'),
       ('Pizza Hawaii', 'Family', 13.80, 'Tomato sauce, bacon, mozzarella, pineapple',1,'/img/hawaii.jpeg'),
       ('Pizza Di Mare', 'Large', 8.30, 'Tomato sauce, mussels, mozzarella, onions',2,'/img/dimare.jpeg'),
       ('Pizza Blanka Meat', 'Large', 9.29, 'Tomato sauce, veal, ham, onions, mushrooms',3,'/img/bianka_meat.jpeg'),
       ('Pizza Tsezar', 'XL', 8.80, 'Tomato sauce, Eggs, mozzarella, salat',1,'/img/tsezar.jpeg'),
       ('Pizza Siciliano', 'XL', 7.20, 'Tomato sauce, Tomato, mozzarella, onions, basil',2,'/img/siciliano.jpeg'),
       ('Pizza Meat Confugi', 'Family', 14.00, 'Tomato sauce, veal, ham, onions, mushrooms',3,'/img/meat_confugi.jpeg');


-- 1
insert into users (username, password, role)
values ('admin','$2a$10$noBvg9RMquV2dx2fUtdd3OHUYPVuQlklMJrbkQWtvp9uYP26hkuzm','ROLE_ADMIN'),
       ('user','$2a$10$noBvg9RMquV2dx2fUtdd3OHUYPVuQlklMJrbkQWtvp9uYP26hkuzm','ROLE_USER');

-- password
-- insert into users (username, password, role)
-- values ('admin','$2a$10$7v0H6Wv9wHRIUVxxmCRdd.L2wZiXNsr5Us1HbgFtc567Hc2DNs1Ye','ROLE_ADMIN'),
--        ('user','$2a$10$7v0H6Wv9wHRIUVxxmCRdd.L2wZiXNsr5Us1HbgFtc567Hc2DNs1Ye','ROLE_USER');
