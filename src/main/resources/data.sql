insert into user_record(id, name, birth_Date)
values (1001, 'johnson', current_date()),
(1002, 'Henry', current_date()),
(1003, 'Marigold', current_date());

insert into post(user_id, post_id, description)
values (1001, 201, 'I want to learn'),
(1001, 202, 'I want to eat'),
(1002, 203, 'I want to dance'),
(1002, 204, 'I want to sing');