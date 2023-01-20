select
	*
from
	library_mst
where
	구분 = '800(문학)'; 	-- like 를 쓸대만 가능하고 %% 는 안에 들어가는 이름이 포함되면 모두 찾아낸다 
						-- %이름 은 뒤에 이름을 가지고 있는 것을 찾아낸다. 이름% 앞에 이름이 붙은걸 찾아낸다. like 와 in을 같이 쓰려면 or를 쓴다.
/*===========================<< select insert >>================================*/                       

/* ======================= 저작자 ============================= */

insert into author_mst 
	(author_name)
select distinct
	저작자
from 
	library_mst
order by
	저작자;
    
select * from author_mst;

/* ===================== 출판사 ============================ */

insert into publisher_mst
	(publisher_name)
select distinct
	출판사
from
	library_mst
order by
	출판사;
    
select * from publisher_mst;

/*===========================<< select update >>================================*/   

update library_mst lm
set 저작자 = (select
				am.author_id
			from
				author_mst am
			where	
				am.author_name = lm.저작자);
                
/*==============================<< library의 제작자에 author_id 넣기 >>========================================*/                
                
update library_mst , author_mst 
set 
	저작자 = author_id
where 
	저작자 = author_name;

/*======================================================================*/

select
	*
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
order by
	am.author_id;

/*=============================<< library의 출판사에 publisher_id 넣기 >>=========================================*/    
    
update library_mst , publisher_mst 
set 
	출판사 = publisher_id
where 
	출판사 = publisher_name;
    

/*======================================================================*/
    
select
	*
from
	library_mst lm
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사)
order by
	pm.publisher_id;
    
/*======================================================================*/    

select 
	*
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자) 
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);

/*======================================================================*/  
set profiling = 1;
set profiling_history_size = 30;

select 
	lm.도서관명,
    lm.도서명
from 
	library_mst lm
where
	lm.저작자 in (select 
					author_id
				from
					author_mst
                where author_name like '%김주%');
             
select 
	lm.도서관명,
    lm.도서명
from 
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
where
	author_name like '%김주%';
    
show profiles;   
