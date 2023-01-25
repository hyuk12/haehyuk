select
	순번,
    도서관명,
    구분,
    도서명,
    저작자,
    (select author_name from author_mst where author_id = 저작자) as 저작자명,
    출판사,
    (select publisher_name from publisher_mst where publisher_id = 출판사) as 출판사명,
    (select publisher_year from publisher_mst where publisher_id = 출판사) as 출판사설립일,
    발행연도,
    청구기호
from
	library_mst;
    
/*===============================================================*/

insert into library_mst
values (0, '테스트도서관', '999(테스트)', '테스트도서명', '9999', '9999', '2023', '999.9-테99ㅌ'); 

set profiling = 1;
set profiling_history_size = 30;

select
	lm.순번,
    lm.도서관명,
    lm.구분,
    lm.도서명,
    lm.출판사,
    pm.publisher_name,
    pm.publisher_year
from
	library_mst lm
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사)
-- where 
-- 	pm.publisher_id is null
order by
	lm.순번 desc;
    
show profiles;  

    