


Drop Table If Exists Sale;
Drop Table If Exists Market;
Drop Table If Exists ProjMember;
Drop Table If Exists Member;
Drop Table If Exists Observation;
Drop Table If Exists User;
Drop Table If Exists Project;


Create Table Project (
    proj_id INT UNSIGNED,
    name TINYTEXT NOT NULL,
    date_created DATE NOT NULL,
    PRIMARY KEY (proj_id)
);
Create Table User (
    user_id INT UNSIGNED,
    username CHAR(20) NOT NULL,
    date_created DATE NOT NULL,
    PRIMARY KEY (user_id)
);
Create Table Observation (
    obs_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    observer INT UNSIGNED NOT NULL,
    common_name TINYTEXT NOT NULL,
    wild BOOLEAN NOT NULL,
    lat DOUBLE(8,6) NOT NULL,
    lon DOUBLE(9,6) NOT NULL,
    date DATE NOT NULL,
    set_value DOUBLE (10, 2),
    PRIMARY KEY (obs_id),
    FOREIGN KEY (observer) REFERENCES User (user_id),
    CHECK (lat BETWEEN -90 AND 90), -- Restrictions for latitude and longitude
    CHECK (lon BETWEEN -180 AND 180)
);

Create Table Member (
    obs_id INT UNSIGNED,
    proj_id INT UNSIGNED,
    PRIMARY KEY (obs_id, proj_id),
    FOREIGN KEY (obs_id) REFERENCES Observation (obs_id) ON DELETE CASCADE,
    FOREIGN KEY (proj_id) REFERENCES Project (proj_id) ON DELETE CASCADE
);

Create Table ProjMember (
    user_id INT UNSIGNED,
    proj_id INT UNSIGNED,
    date_joined DATE NOT NULL,
    PRIMARY KEY (user_id, proj_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id) ON DELETE CASCADE,
    FOREIGN KEY (proj_id) REFERENCES Project (proj_id) ON DELETE CASCADE
);

Create Table Market (
    market_type CHAR(20),
    PRIMARY KEY (market_type)
);

Create Table Sale (
    obs_id INT UNSIGNED,
    market_type CHAR(20),
    listing_price DOUBLE (10, 2) NOT NULL,
    PRIMARY KEY (obs_id),
    FOREIGN KEY (obs_id) REFERENCES Observation (obs_id) ON DELETE CASCADE,
    FOREIGN KEY (market_type) REFERENCES Market (market_type) ON DELETE CASCADE
);

