create table bank.accounts(
	account_id serial,
	account_type varchar(10) not null,
	balance decimal(19, 2) check(balance >= 0.00) not null,

	constraint pk_accounts primary key (account_id)
	
);
