SELECT
	순번,
    도서관명,
    구분,
    도서명,
    저작자,
    출판사,
    발행연도,
    case --  자바에서 if 문이다.
		when 발행연도 is null then '2050'
        when 발행연도 = '' then '2090'
		else 발행연도
	end as 발행연도1,
    if(ifnull(발행연도, '') = '', '2023', 발행연도) as 발행연도2, -- null 이면 공백으로 바꿔라
    nullif(발행연도, '') as 발행연도3, -- 공백이면 null 로 바꿔라 
    if(청구기호 = '', '기호없음', 청구기호) as 청구기호 -- 삼항연산자와 같은 조건문 앞이 조건 뒤가 첫번째가 참일 때 뒤가 거짓일 때
FROM
	library_mst
WHERE
	-- 발행연도 LIKE '201_'; -- 언더바는 특정위치 한곳을 와일드카드로 쓴다.
    -- 발행연도 is not null; -- null 을 확인할 때는 is 를 쓴다.
    not 발행연도 = ''; -- 공백이 아닌 것들만 
UPDATE
	library_mst
SET
	발행연도 = ''
WHERE
	발행연도 = '2009';