
CREATE TABLE T_PRICE (
                         PRICE_ID INT AUTO_INCREMENT  PRIMARY KEY,
                         BRAND_ID INT NOT NULL,
                         START_DATE TIMESTAMP NOT NULL,
                         END_DATE TIMESTAMP NOT NULL,
                         PRICE_LIST INT NOT NULL,
                         PRODUCT_ID INT NOT NULL,
                         PRIORITY INT NOT NULL,
                         PRICE DOUBLE NOT NULL,
                         CURR VARCHAR(10) NOT NULL,
                         foreign key (BRAND_ID) references T_BRAND(BRAND_ID),
                         foreign key (PRODUCT_ID) references T_PRODUCT(PRODUCT_ID),
                         foreign key (PRICE_LIST) references T_PRICE_LIST(PRICE_LIST_ID)
);