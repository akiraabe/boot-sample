-- customer
insert into customer (id, name, address, phone_number) values('0001','Akira Abe','Chiba, Japan','0000-1111-2222');
insert into customer (id, name, address, phone_number) values('0002','Steve Smith','USA','0000-1111-3333');
insert into customer (id, name, address, phone_number) values('0003','Jeff Porcaro','USA','0000-1111-4444');

-- BasicPlan
insert into basic_plan (name, unit_price) values('Standard', 1500);
insert into basic_plan (name, unit_price) values('Lite', 800);
insert into basic_plan (name, unit_price) values('Premium', 2500);

-- Contract
insert into contract (contract_date, customer_id, basic_plan_id) values('2017-03-19', '0001', 1);
insert into contract (contract_date, customer_id, basic_plan_id) values('2017-03-01', '0002', 2);

-- Use
insert into use_detail (use_date, electric_energy, contract_id) values('2017-02-28', 100, 1); -- out of duration
insert into use_detail (use_date, electric_energy, contract_id) values('2017-03-20', 200, 1);
insert into use_detail (use_date, electric_energy, contract_id) values('2017-03-21', 210, 1);
insert into use_detail (use_date, electric_energy, contract_id) values('2017-03-22', 220, 1);
insert into use_detail (use_date, electric_energy, contract_id) values('2017-03-23', 230, 1);
