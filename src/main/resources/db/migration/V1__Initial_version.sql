CREATE TABLE IF NOT EXISTS Street(
    street_id BIGINT PRIMARY KEY,
    street_name VARCHAR NOT NULL,
    postal_code INT NOT NULL
);

CREATE TABLE IF NOT EXISTS House(
    house_id BIGINT PRIMARY KEY,
    house_name VARCHAR NOT NULL,
    date_of_construction DATE NOT NULL,
    number_of_floors INT NOT NULL,
    house_type VARCHAR NOT NULL,
    street BIGINT NOT NULL,
    CHECK(house_type IN ('жилое помещение', 'коммерческое помещение', 'подсобное помещение', 'гараж')),
    FOREIGN KEY (street) REFERENCES Street (street_id)
);