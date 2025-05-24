create database fly;
use fly;

-- user
 CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(150) NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    role ENUM('PASSENGER', 'FLIGHT_OWNER', 'ADMIN') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- flights
CREATE TABLE flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(20) UNIQUE NOT NULL,
    flight_name VARCHAR(100) NOT NULL,
    total_seats INT NOT NULL,
    baggage_checkin_kg INT,
    baggage_cabin_kg INT,
    owner_id INT NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- flight routes
CREATE TABLE flight_routes (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_id INT NOT NULL,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departure_time DATETIME NOT NULL,
    arrival_time DATETIME NOT NULL,
    fare DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id) ON DELETE CASCADE
);

-- bookings
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    route_id INT NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('BOOKED', 'CANCELLED', 'COMPLETED') DEFAULT 'BOOKED',
    total_fare DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (route_id) REFERENCES flight_routes(route_id) ON DELETE CASCADE
);

-- passengers
CREATE TABLE passengers (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    passenger_name VARCHAR(150) NOT NULL,
    passenger_age INT,
    passenger_gender ENUM('MALE', 'FEMALE', 'OTHER'),
    seat_number VARCHAR(10),
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id) ON DELETE CASCADE
);


-- payments
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount_paid DECIMAL(10, 2) NOT NULL,
    payment_method ENUM('CREDIT_CARD', 'DEBIT_CARD', 'NET_BANKING', 'UPI', 'WALLET'),
    payment_status ENUM('SUCCESS', 'FAILED', 'PENDING') DEFAULT 'PENDING',
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id) ON DELETE CASCADE
);

-- refunds
CREATE TABLE refunds (
    refund_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_id INT NOT NULL,
    refund_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    refund_amount DECIMAL(10, 2) NOT NULL,
    refund_status ENUM('REQUESTED', 'PROCESSED', 'REJECTED') DEFAULT 'REQUESTED',
    FOREIGN KEY (payment_id) REFERENCES payments(payment_id) ON DELETE CASCADE
);

-- flight owners
CREATE TABLE flight_owners (
    owner_id INT PRIMARY KEY,
    company_name VARCHAR(100),
    company_address VARCHAR(255),
    contact_number VARCHAR(20),
    FOREIGN KEY (owner_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- admins
CREATE TABLE admins (
    admin_id INT PRIMARY KEY,
    admin_level VARCHAR(50),
    contact_number VARCHAR(20),
    FOREIGN KEY (admin_id) REFERENCES users(user_id) ON DELETE CASCADE
);



