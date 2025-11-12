CREATE TABLE IF NOT EXISTS Pizza(
    id bigint NOT NULL auto_increment,
    name VARCHAR(255) NOT NULL,
    flavour VARCHAR(50) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    sizes VARCHAR(50) NOT NULL,
    availability BOOLEAN NOT NULL,
    primary key(id)
);