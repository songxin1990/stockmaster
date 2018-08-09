alter table trade_record add trade_series_id int;
alter table trade_record add is_processed int not null default 0;

alert table trade_series add series_begintime datetime not null;