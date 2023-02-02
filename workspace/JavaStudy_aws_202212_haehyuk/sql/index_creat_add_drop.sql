CREATE INDEX `product_id` ON product_mst(product_code);  -- index 를 생성 하는 방법 

SHOW INDEX FROM `product_mst`; -- index 조회 방법

ALTER TABLE `product_mst`
ADD UNIQUE product_name2(product_name);

ALTER TABLE product_mst
DROP INDEX product_id;