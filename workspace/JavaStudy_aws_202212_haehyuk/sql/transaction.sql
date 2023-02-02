SHOW VARIABLES LIKE 'AUTOCOMMIT';

SET autocommit = 0;

START TRANSACTION; -- 열어주면 트랜잭션 시작 

SAVEPOINT sp3; -- 이 시점부터 저장하겠다.

insert into user_mst
values(0, 'hhh1','1234', 'xxx', 'khk@gmail.com');

select * from user_mst;

ROLLBACK TO sp1; -- 되돌아 가는 기능 하지만 커밋이 되기전까지 돌아간다, 커밋을 해버리면 돌아갈 수 없다. TO 한후 내가 지정한 세이브포인트를 적어주면 그 세이브포인트를 해준 상태로 돌아간다.

COMMIT; -- 트랜잭션의 시작과 커밋사이의 진행된 것들을 저장한다. 커밋을 진행show_all_user_mst해야 트랜잭션이 닫힌다.