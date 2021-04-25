create table orders
(
    ID               varchar(50)  not null
        primary key,
    AMOUNT           double       not null,
    CUSTOMER_ADDRESS varchar(255) not null,
    CUSTOMER_EMAIL   varchar(128) not null,
    CUSTOMER_NAME    varchar(255) not null,
    CUSTOMER_PHONE   varchar(128) not null,
    ORDER_DATE       datetime     not null,
    ORDER_NUM        int          not null,
    constraint ORDER_UK
        unique (ORDER_NUM)
);

INSERT INTO sportshop.orders (ID, AMOUNT, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE, ORDER_NUM) VALUES ('17b0f990-daef-4a45-8771-b109b3f5e9a3', 28200, 'USA', 'Send_uk93@itstep.org', 'John steev', '2423432', '2021-04-18 22:07:30', 3);
INSERT INTO sportshop.orders (ID, AMOUNT, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE, ORDER_NUM) VALUES ('3df8f313-92e2-44e2-af2d-66d67c565f36', 9000, 'sdg', 'Send_uk93@itstep.org', 'efewf', '324243', '2021-04-18 17:40:39', 1);
INSERT INTO sportshop.orders (ID, AMOUNT, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE, ORDER_NUM) VALUES ('6da907f9-345a-4a61-b418-710f561bf40b', 2345, 'sad', 'Send_uk93@itstep.org', 'rf', '534534', '2021-04-18 22:11:21', 4);
INSERT INTO sportshop.orders (ID, AMOUNT, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE, ORDER_NUM) VALUES ('862260ff-dab0-4c5b-b87e-d5629875f7bc', 2345, 'Ukraine Lviv', 'Send_uk93@itstep.org', 'Shendiuk Denys', '25121521', '2021-04-18 19:04:24', 2);
INSERT INTO sportshop.orders (ID, AMOUNT, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE, ORDER_NUM) VALUES ('d86fb136-bb5d-41a1-b059-5d457892002d', 9600, 'Україна', 'Send_uk93@itstep.org', 'Семен Семенович', '25121521', '2021-04-20 00:40:32', 5);