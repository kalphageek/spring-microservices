## Stream
* boxed() 메서드는 int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 Stream을 생성한다

## TDD
* @SpringBootTest는  Spring관련 Test이면 @MockBean사용, 아니면 @Mock사용
* assertTrue를 통해 IntStream을 통해 생성된 List(int)를 검증한다

## lombok
* @RequiredArgsConstructor는 모든 상수 필드를 갖는 생성자를 만든다