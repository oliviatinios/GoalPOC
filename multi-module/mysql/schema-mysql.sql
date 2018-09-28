USE eventuate;

DROP table IF EXISTS  todo;

create table todo (
  id varchar(255) PRIMARY KEY,
  title varchar(255),
  completed BOOLEAN,
  order_id INTEGER,
  deleted BOOLEAN
);

DROP table IF EXISTS  goal;

create table goal (
  goal_id varchar(255) PRIMARY KEY,
  client_xref_id varchar(255),
  goal_name varchar(255),
  goal_status_code varchar(255),
  goal_subtype_code varchar(255),
  goal_type_code varchar(255),
  note varchar(255),
  complete_date varchar(255),
  cost varchar(255),
  cost_frequency_code varchar(255),
  cost_time_value varchar(255),
  currency_code varchar(255),
  investment_ind varchar(255),
  owned_homecdn_ind varchar(255),
  recurrence varchar(255),
  start_date varchar(255),
  target_date_code varchar(255),
  create_by varchar(255),
  create_on varchar(255),
  modified_by varchar(255),
  modified_on varchar(255)
  
);

