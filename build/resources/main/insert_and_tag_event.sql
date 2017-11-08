insert into event (organization_id, name, description, contact, email, application_url, location, zip_code, time, size, length)
values (1, 'Card Writing', 'Write cards for children with terminal diseases.', 'Yunie', 'ym224@cornell.edu', '', 'St. Jude Hospital', '10017',
TIMESTAMP '2017-11-24 10:00:00', 50, 60);

insert into event_interest (event_id, interest_id, last_updated)
values (2, 2, now());

insert into event_interest (event_id, interest_id, last_updated)
values (2, 3, now());

insert into event_interest (event_id, interest_id, last_updated)
values (2, 6, now());
