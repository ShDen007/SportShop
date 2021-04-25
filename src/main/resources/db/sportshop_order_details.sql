create table order_details
(
    ID         varchar(50) not null
        primary key,
    AMOUNT     double      not null,
    PRICE      double      not null,
    QUANITY    int         not null,
    ORDER_ID   varchar(50) not null,
    PRODUCT_ID varchar(20) not null,
    constraint ORDER_DETAIL_ORD_FK
        foreign key (ORDER_ID) references orders (ID),
    constraint ORDER_DETAIL_PROD_FK
        foreign key (PRODUCT_ID) references products (CODE)
);

INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('5a719558-2648-4399-bee0-7c39be17c2fd', 2345, 2345, 1, '862260ff-dab0-4c5b-b87e-d5629875f7bc', 'C018');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('5d050a50-971b-4252-b66f-2905668fff59', 21000, 21000, 1, '17b0f990-daef-4a45-8771-b109b3f5e9a3', 'C021');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('ada01257-a5b9-4240-b183-23857ed6c0ec', 1200, 1200, 1, 'd86fb136-bb5d-41a1-b059-5d457892002d', 'C011');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('baf48f5a-bcba-4e38-9aaa-652a2c1934ec', 2345, 2345, 1, '6da907f9-345a-4a61-b418-710f561bf40b', 'C018');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('c05b6b5e-dbba-400e-bfc4-ae82a63d5a54', 9000, 9000, 1, '3df8f313-92e2-44e2-af2d-66d67c565f36', 'C013');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('ed064371-1479-4370-a058-be1a0c9fa4a0', 7200, 7200, 1, '17b0f990-daef-4a45-8771-b109b3f5e9a3', 'C005');
INSERT INTO sportshop.order_details (ID, AMOUNT, PRICE, QUANITY, ORDER_ID, PRODUCT_ID) VALUES ('f532370c-64fe-4ea4-86bd-91de48ad9e92', 8400, 8400, 1, 'd86fb136-bb5d-41a1-b059-5d457892002d', 'C008');