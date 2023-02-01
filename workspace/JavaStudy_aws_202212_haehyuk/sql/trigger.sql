-- delete 는 꼭 before 에다가 만든다.
CREATE DEFINER = `root`@`localhost` TRIGGER `chatting`.`user_mst_BEFORE_DELETE` BEFORE DELETE ON `user_mst` for each row
begin
delete
from
    role_dtl
where
        user_id = old.user_id;

delete
from
    user_dtl
where
    user_id = old.user_id;
end;
