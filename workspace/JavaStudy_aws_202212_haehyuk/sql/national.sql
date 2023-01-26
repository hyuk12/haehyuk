insert into workspace_type
	(coperation_code)
select distinct
	사업장형태구분코드
from
	national
where
	사업장형태구분코드 = 1
order by
	사업장형태구분코드;
    
select * from workspace_type;

insert into workspace_type
	(individual_code)
select distinct
	사업장형태구분코드
from
	national
where
	사업장형태구분코드 = 2
order by
	사업장형태구분코드;
    
select * from workspace_type;
	