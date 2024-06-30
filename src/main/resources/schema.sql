create table if not exists items (
    id serial primary key,
    name varchar(100),
    price decimal(10, 2)
);

create table if not exists inventory (
    id serial primary key,
    item_id integer references items(id),
    quantity integer
);

create table if not exists orders (
    id serial primary key,
    item_id integer references items(id),
    quantity integer,
    order_date timestamp
);