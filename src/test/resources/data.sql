-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`)
values (1, 'eatnows', 'eatnows@email.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`)
values (2, 'apple', 'apple@email.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`)
values (3, 'banana', 'banana@email.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`)
values (4, 'kiwi', 'kiwi@dev.com', now(), now());

-- call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`)
values (5, 'eatnows', 'eatnows@dev.com', now(), now());

insert into publisher(`id`, `name`) values (1, 'JPA강의');

insert into book(`id`, `name`, `publisher_id`, `deleted`)
values (1, 'JPA 강의', 1, false);

insert into book(`id`, `name`, `publisher_id`, `deleted`)
values (2, 'Spring Security', 1, false);

insert into book(`id`, `name`, `publisher_id`, `deleted`)
values (3, 'SpringBoot 강의', 1, TRUE)
