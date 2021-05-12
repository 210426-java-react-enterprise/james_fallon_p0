create table bank.users(
                      user_id serial,
                      password varchar(255) not null,
                      email varchar(255) unique not null,
                      first_name varchar(25) not null,
                      last_name varchar(25) not null,
                      age int check (age > 0),

                      constraint pk_users primary key (user_id)
);