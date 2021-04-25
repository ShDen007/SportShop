create table accounts
(
    USER_NAME         varchar(20)  not null
        primary key,
    ACTIVE            bit          not null,
    ENCRYTED_PASSWORD varchar(128) not null,
    USER_ROLE         varchar(20)  not null
);

INSERT INTO sportshop.accounts (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE) VALUES ('admin', true, '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_ADMIN');