 drop database stock;

CREATE DATABASE IF NOT EXISTS stock;
-- stocks stocks
USE stock;

SET GLOBAL FOREIGN_KEY_CHECKS=OFF;

create table stocks (
stockID int,
# symbol
company varchar (50),
currency varchar (50),
price double,
percentage double,
PRIMARY KEY (stockID)
-- FOREIGN KEY (stockID) REFERENCES watchlist(stockID)
);

create table watchlist (
watchlistID int auto_increment,
stockID int,
PRIMARY KEY (watchlistID),
FOREIGN KEY (watchlistID) REFERENCES stocks(stockID) ON DELETE CASCADE
);

