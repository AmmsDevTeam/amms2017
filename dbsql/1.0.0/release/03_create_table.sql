create table enrollment(
    enrollment_id                     serial primary key,
    cell_phone_num                    varchar(20),
    full_name                         varchar(20),
    title                             varchar(20),
    gender                            varchar(10),
    supplier_code                     varchar(50),
    supplier_name                     varchar(500),
    estimate_arrive_time              varchar(20),
    is_visited                        varchar(10),
    is_self_drive                     varchar(10),
    shuttle_destination               varchar(50),
    meeting_seat_num                  varchar(500),
    dinner_seat_num                   varchar(10),
    comment                           varchar(500)
);

create table schedule(
	schedule_id                       serial primary key,
    cell_phone_num                    varchar(20),
    full_name                         varchar(20),
    time_arrange                      varchar(100),
    activation_place                  varchar(500),
    activation_title                  varchar(100)
);