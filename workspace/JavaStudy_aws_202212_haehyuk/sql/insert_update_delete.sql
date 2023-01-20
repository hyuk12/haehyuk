/*
	DML 
    C : insert / into	데이터 추가
    R : select / from	데이터 조회
    U : update / set	데이터 수정
    D : delete / from	데이터 삭제
*/

/*=============<< insert >>=================*/

select * from student_mst;

insert into 
	`db_study2_explain`.`student_mst`
	(`student_id`, `student_name`, `mentor_id`)
values (5, '손오공', 3);

select * from student_mst;

insert into
	`db_study2_explain`.`student_mst`
    (`student_id`, `student_name`)
values (6, '손오반');

select * from student_mst;

-- 여러개를 insert 할 때 쓴다
insert into student_mst
	(student_id, 	student_name, 	mentor_id)
values
	(	7,			'베지터',			1),
	(	8,			'손오천',			2),
	(	9,			'트랭크스',		3),
	(	10,			'피콜로',			1);
    
select * from student_mst;

/* 대학에 값 넣어보기*/

insert into university_mst
	(	university_id, 	university_name)
values
	(		4, 			'MIT공대'),
	(		5, 			'스탠포드대학'),
	(		6, 			'포항공대'),
	(		7, 			'카이스트대학');
    
select * from university_mst;

/*===================<< update >>=========================*/

update student_mst
set
	student_name = '프리저',
	mentor_id = 2
where -- 왠만하면 키값으로 바꾸려고 해야한다 ( where 은 밑에오는 컬럼의 값이면 바꾸어라 라는 조건)
	student_id = 3;
    
select * from student_mst;

/* 멘토 아이디가 3인 학생들의 멘토아이디를 1로 바꾸어라*/
update student_mst
set 
	mentor_id = 1
where 
	mentor_id = 3;

select * from student_mst;


/*===================<< delete >>=========================*/

delete from 
	student_mst 
where 
	student_id = 4
and student_name = '문익점' ;

select * from student_mst;

/*대학 선택해서 지우기*/

delete from
	university_mst
where
	university_id = 6
and university_name = '포항공대';

select * from university_mst;