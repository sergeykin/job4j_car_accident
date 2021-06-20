drop table accident cascade ;
CREATE TABLE accident (
    id serial primary key,
    name varchar(2000),
    text varchar(2000),
    address varchar(2000),
    type_id int  null references accidenttype(id)
);

CREATE TABLE accidenttype (
                          id serial primary key,
                          name varchar(2000)
);

CREATE TABLE rule (
                              id serial primary key,
                              name varchar(2000)
);

CREATE TABLE rule_accident (
                      accident_id int not null references accident(id),
                      rule_id  int not null references rule(id)
);