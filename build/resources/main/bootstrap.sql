drop table user_history;
drop table user_interest;
drop table user_preference;
drop table user_wish_list;
drop table user_black_list;
drop table event_interest;
drop table event;
drop table user_info;
drop table organization;
drop table interest;

create TABLE IF NOT EXISTS interest(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

create table IF NOT EXISTS user_info(
  id SERIAL PRIMARY KEY,
  first_name varchar(255) not null,
  last_name VARCHAR(255) not null,
  gender VARCHAR(255) not null,
  age integer not null,
  email VARCHAR(255) not null,
  address VARCHAR(255) not null,
  zip_code VARCHAR(255) not null,
  phone VARCHAR(255)
);

create table IF NOT EXISTS user_interest (
  id SERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES user_info(id),
  interest_id BIGINT REFERENCES interest(id),
  weight NUMERIC(10, 2) NOT NULL,
  last_updated TIMESTAMP
);

create table IF NOT EXISTS organization(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) not null,
  address VARCHAR(255),
  email VARCHAR(255),
  website VARCHAR(255)
);

create table IF NOT EXISTS event (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) not null,
  organization_id INTEGER REFERENCES organization(id),
  contact VARCHAR(255),
  email VARCHAR(255) not null,
  application_url VARCHAR(255) not null,
  location VARCHAR(255) not null,
  zip_code VARCHAR(255) not null,
  time TIMESTAMP not null,
  attendance INTEGER,
  size INTEGER,
  length BIGINT not null
);

create table IF NOT EXISTS event_interest (
  id SERIAL PRIMARY KEY,
  event_id BIGINT REFERENCES event(id),
  interest_id BIGINT REFERENCES interest(id),
  last_updated TIMESTAMP
);

create table IF NOT EXISTS user_history (
  id SERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES user_info(id),
  event_id BIGINT REFERENCES event(id),
  last_updated TIMESTAMP
);

create table IF NOT EXISTS user_preference (
  id SERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES user_info(id),
  max_distance INTEGER,
  max_event_length INTEGER,
  min_hour INTEGER,
  max_hour INTEGER,
  event_type VARCHAR(255),
  impact_idx INTEGER,
  event_size INTEGER,
  last_updated TIMESTAMP
);

create table IF NOT EXISTS user_wish_list(
  id SERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES user_info(id),
  event_id BIGINT REFERENCES event(id),
  status VARCHAR(255),
  date_created TIMESTAMP,
  last_updated TIMESTAMP
);

create table IF NOT EXISTS user_black_list(
  id SERIAL PRIMARY KEY,
  user_id BIGINT REFERENCES user_info(id),
  event_id BIGINT REFERENCES event(id),
  status VARCHAR(255),
  date_created TIMESTAMP,
  last_updated TIMESTAMP
)