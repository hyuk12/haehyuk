-- student 에 값을 넣는 코드  

insert into student_mst values (1, '홍길동');
insert into student_mst values (2, '김유신');
insert into student_mst values (3, '이순신');
insert into student_mst values (4, '문익점');

select * from student_mst;

-- 강의명 값을 넣는 코드
insert into lecture_mst values (1, 'java', 100000);
insert into lecture_mst values (2, 'python', 80000);
insert into lecture_mst values (3, 'c', 90000);

select * from lecture_mst;

-- 강사정보를 등록하는 코드
insert into instructor_mst values (1, '세종대왕', '서울대');
insert into instructor_mst values (2, '왕건', '고려대');
insert into instructor_mst values (3, '이성계', '연세대');

select * from instructor_mst;

-- 대학교 등록하는 코드
insert into university_mst values(1, '서울대');
insert into university_mst values(2, '고려대');
insert into university_mst values(3, '연세대');

select * from university_mst;

-- course 등록 하는 코드
insert into course_mst values (1, 1, 1, 1);
insert into course_mst values (2, 2, 1, 1);
insert into course_mst values (3, 3, 2, 2);
insert into course_mst values (4, 4, 3, 3);

select * from course_mst;



-- join 으로 다꺼내기
select
	cm.course_id,
	sm.student_name,
    mm.mentor_name,
	lm.lecture_name,
    lm.lecture_price,
	im.instructor_name,
	um.university_name
from
	course_mst cm
    left outer join student_mst sm on(sm.student_id = cm.student_id)
    left outer join mentor_mst mm on(mm.mentor_id = sm.mentor_id)
    left outer join lecture_mst lm on(lm.lecture_id = cm.lecture_id)
    left outer join instructor_mst im on(im.instructor_id = cm.instructor_id)
    left outer join university_mst um on(um.university_id = im.university_id)

    