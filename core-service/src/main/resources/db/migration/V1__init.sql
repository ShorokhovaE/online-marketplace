create table products
(
    id bigserial primary key,
    title varchar(45),
    price decimal(5,2),
    description varchar(255),
    company_name varchar(100),
    quantity int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price, description, company_name, quantity)
values ('Milk', 24.50, 'Description', 'companyName', 10),
       ('Bobs', 15.50, 'Description', 'companyName', 10),
       ('Bread', 22.00, 'Description', 'companyName', 10),
       ('Water', 30.50, 'Description', 'companyName', 10),
       ('Candy', 100.00, 'Description', 'companyName', 10),
       ('Cheese', 250.50, 'Description', 'companyName', 10);



create table orders
(
    id bigserial primary key,
    username varchar(255),
    total_price decimal(5,2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);


create table order_items
(
    id bigserial primary key,
    product_id bigint not null references products(id),
    order_id bigint not null references orders(id),
    quantity int,
    price_per_product decimal(5,2),
    price decimal(5,2),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table feedbacks
(
    id bigserial primary key,
    comment_text varchar(255),
    grade int,
    product_id bigint not null references products(id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table products_feedback
(
    product_id bigint not null references products(id),
    feedback_id bigint not null references feedbacks(id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
