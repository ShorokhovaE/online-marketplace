create table products
(
    id    int NOT NULL AUTO_INCREMENT,
    title varchar(45),
    price decimal(5,2),
    description varchar(255),
    company_name varchar(100),
    count int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY (id)
);

insert into products (title, price, description, company_name, count)
values ('Milk', 24.50, 'Description', 'companyName', 10),
       ('Bobs', 15.50, 'Description', 'companyName', 10),
       ('Bread', 22.00, 'Description', 'companyName', 10),
       ('Water', 30.50, 'Description', 'companyName', 10),
       ('Candy', 100.00, 'Description', 'companyName', 10),
       ('Cheese', 250.50, 'Description', 'companyName', 10);



create table orders
(
    id   int NOT NULL AUTO_INCREMENT,
    username varchar(255),
    total_price decimal(5,2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY (id)
);


create table order_items
(
    id   int NOT NULL AUTO_INCREMENT,
    product_id int,
    order_id int,
    quantity int,
    price_per_product decimal(5,2),
    price decimal(5,2),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

create table feedbacks
(
    id   int NOT NULL AUTO_INCREMENT,
    comment_text varchar(255),
    grade int,
    product_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

create table products_feedback
(
    product_id int,
    feedback_id int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (feedback_id) REFERENCES feedbacks (id)
);
