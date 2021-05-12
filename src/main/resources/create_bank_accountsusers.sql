create table bank.accounts_users(
	account_id int,
	user_id int,

	constraint fk_accounts foreign key (account_id) references bank.accounts(account_id),
	constraint fk_users foreign key (user_id) references bank.users(user_id)

	
);