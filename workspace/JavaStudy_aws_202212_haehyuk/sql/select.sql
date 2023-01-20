/*===============<< select >>==================*/

/* 전체 컬럼 조회*/

select 
	* 
from
	student_mst;
    
/*지정 컬럼 조회*/

select
	student_id,
	student_name
from
	student_mst;
    
/* 임시 컬럼 추가*/

select
	1 as num,
    '쉘' as name;

select
	student_id,
    student_name,
    '야무치' as instructor_name
from
	student_mst;


    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스*/

select
	sm.student_id as studentId
from 
	student_mst sm;
    
/* 조회 조건 where*/

select
	*
from
	student_mst
where
	mentor_id = (select
					mentor_id
				from
					mentor_mst
				where
				mentor_name = '신사임당');
                
select 
	student_id,
    student_name,
    mentor_id,
    (select
		mentor_name 
	from
		mentor_mst
	where
		mentor_id = student_mst.mentor_id) as mentor_name
from
	student_mst;
    
/* 그룹으로 묶어서 조회하기 */

select
	count(mentor_id), -- 괄호 안에 들어오는 컬럼의 값중에 가지고있는 애들을 카운트
    min(student_id), -- 최솟값
    max(student_id), -- 최댓값
    avg(student_id), -- 평균치
    sum(student_id), -- 합산
	mentor_id
from
	student_mst
group by
	mentor_id;
    
/* 중복 제거 */
select distinct
	mentor_id 
from
	student_mst;
    
/* 그룹으로 조회한 결과에 조건주는 방법 */

select
	count(mentor_id) as mentor_count, -- 괄호 안에 들어오는 컬럼의 값중에 가지고있는 애들을 카운트
    min(student_id), -- 최솟값
    max(student_id), -- 최댓값
    avg(student_id), -- 평균치
    sum(student_id), -- 합산
	mentor_id
from
	student_mst
group by
	mentor_id
having -- 그룹을 지어준 다음 그 그룹들에 조건을 걸어서 쓸 때 쓰는 것
	mentor_count = 5;
    
/* 정렬 */

select
	* 
from
	student_mst
order by 
	mentor_id,
    student_id desc; -- 기본 값은 오름차순
    
/* 전체 조합 실습*/

select
	count(*) as student_count,
    mentor_id
from
	student_mst
where
	student_id > 2
group by
	mentor_id
having
	student_count = 4
or	student_count = 2
order by 
	mentor_id desc;