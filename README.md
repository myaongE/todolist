# todolist
:todo list에 우선순위 기능을 추가하였습니다.

<br><br><br>

<h2>프로젝트 일정</h2>
: 24.12.08 ~ 24.12.14 
<br><br><br>


<table>
	<h2>주요 기능</h2>
	<th>기능</th>
 	<th>설명</th>
  <th>비고</th>
  <tr><td>일정</td><td>추가, 수정 삭제</td><td>등록 시, 우선순위순, 내림차순으로 목록화 한다.</td></tr>
  <tr><td>우선순위</td><td>하루 일정 중 중요한 것을 체크</td><td>체크하면 목록의 최우선적으로 보여진다.</td></tr>
</table>

<br><br><br>

<table>
	<caption><h2>개발 환경</h2></caption>
	<tr>
		<td>OS</td>
		<td>Mac</td>
	</tr>
	<tr>
		<td>Language</td>
		<td>JAVA(17), HTML/CSS, Java Script</td>
	</tr>
	<tr>
		<td>Front</td>
		<td>HTML, CSS, JavaScript, Ajax</td>
	</tr>
	<tr>
		<td>Framework</td>
		<td>Spring Boot 3.4.0</td>
	</tr>
	<tr>
		<td>DB</td>
		<td>MySQL 8.0.36, JPA</td>
	</tr>
	<tr>
		<td>IDE</td>
		<td>STS4</td>
	</tr>
 	<tr>
		<td>ETC</td>
		<td>JPA, Thymeleaf</td>
	</tr>
</table>	
<br><br><br>

<table>
	<h2>요구사항 분석</h2>
	<th>페이지</th>
 	<th>기능</th>
  <th>설명</th>
  <tr><td>메인</td><td>일정 등록, 목록 표시</td></td>일정 추가, 추가한 리스트가 보여진다.<td></td></tr>
  <tr><td>수정</td><td>등록했던 기존 일정을 수정한다. </td><td>제목, 내용, 중요도를 수정한다.</td></tr>
</table>

<br><br><br>

<table>
  <h2>DB</h2>
  <thead>
    <tr>
      <th>key</th>
      <th>name</th>
      <th>설명</th>
      <th>제약 조건</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>id</td>
      <td>고유 ID</td>
      <td>각 일정 항목을 구별하는 고유 식별자</td>
      <td>PK (Primary Key)</td>
    </tr>
    <tr>
      <td>title</td>
      <td>제목</td>
      <td>일정의 제목을 입력하는 필드</td>
      <td>NOT NULL</td>
    </tr>
    <tr>
      <td>description</td>
      <td>설명</td>
      <td>일정에 대한 추가 설명을 입력하는 필드</td>
      <td>NULL 가능</td>
    </tr>
    <tr>
      <td>status</td>
      <td>상태</td>
      <td>일정의 상태 (예: 'PENDING', 'COMPLETED')</td>
      <td>NOT NULL, ENUM('PENDING', 'COMPLETED')</td>
    </tr>
    <tr>
      <td>createdAt</td>
      <td>생성일시</td>
      <td>일정이 생성된 시간</td>
      <td>DEFAULT CURRENT_TIMESTAMP</td>
    </tr>
    <tr>
      <td>tag</td>
      <td>태그</td>
      <td>일정에 관련된 태그 (예: 업무, 개인 등)</td>
      <td>NULL 가능</td>
    </tr>
    <tr>
      <td>important</td>
      <td>중요 여부</td>
      <td>일정의 중요도를 나타내는 필드 (true/false)</td>
      <td>DEFAULT FALSE</td>
    </tr>
  </tbody>
</table>
