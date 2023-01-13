# collection 프레임워크

다수의 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스의 집합

                                 Map<K, V>

    Iterable<E> <- Collection<E> <- List<E>
                                  <- Set<E>

List 는 순서가 있고 중복이 가능하다
순서가 있기 때문에 명확하게 순서에 맞는 값이 있어서 구분이 가능해서
중복이 가능하다

set 은 집합이다.
순서도 없고 중복도 안된다.

map 은 key 와 value 로 이루어져 있다.
간단히 set 과 list 를 합친 개념이다.

key 는 중복이 불가능하다. == set 이 적용되어 있는 형태

value 는 중복을 허용한다.
