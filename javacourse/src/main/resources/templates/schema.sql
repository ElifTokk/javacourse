-- product tablosu
CREATE TABLE IF NOT EXISTS PRODUCTTB (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    photourl VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
    );