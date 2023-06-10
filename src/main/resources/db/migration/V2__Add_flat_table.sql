ALTER TABLE House ADD COLUMN IF NOT EXISTS house_material VARCHAR;

CREATE TABLE IF NOT EXISTS Flat(
    flat_id BIGINT PRIMARY KEY,
    flat_number INT NOT NULL,
    flat_square INT NOT NULL,
    number_of_rooms INT NOT NULL,
    house BIGINT NOT NULL,
    FOREIGN KEY (house) REFERENCES House (house_id)
);


