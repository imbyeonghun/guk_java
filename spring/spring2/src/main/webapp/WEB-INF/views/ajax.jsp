<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<button class="btn1">json - json</button>
	<br>
	<button class="btn2">object - json</button>
	<br>
	<!-- 
	화면에서 이름과 나이를 입력받아 서버에 ajax로 전송하고,
	서버에서는 화면에서 보내준 이름과 나이를 콘솔에 출력하고,
	화면에 result값으로 "성공"을 전송
	화면에서는 서버에서 보낸 result를 alert으로 출력
	1. 화면 구성
	2. 이벤트 등록
	3. 이벤트에서 ajax로 통신
		- 화면에 입력된 정보를 가져옴
		- ajax로 서버에 전송
		- 서버에서는 화면에서 보낸 정보를 받아서 콘솔에 출력
		- 서버에서 화면에 데이터를 전송
		- 화면에서는 서버에서 보낸 데이터를 alert로 출력
	-->
	<form action="">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="age" placeholder="나이"><br>
		<button type="submit" class="btn3">전송</button>
	</form>
	<button class="btn4">object - object</button>
	
	
	<!-- 위에 주석 문제 -->
	<script type="text/javascript">
		$("form").submit(function(){
			// form태그에 있는 입력 태그들을 하나의 문자열로 만듬
			// name명=값& 형태로
			let obj = $(this).serialize();
			$.ajax({
				async : true,
				url : '<c:url value="/ajax/object/json2"/>', 
				type : 'get', 
				data : obj, 
				dataType : "json", 
				success : function (data){
					alert(data.result)
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return false;
		});
	</script>
	
	<!-- json - json -->
	<script type="text/javascript">
		// 서버에서 보낸 이름을 가져오는 함수를 원함
		function clickTest1(obj){
			let name = "";
			$.ajax({
				// 동기 : 작업 1이 다 끝날때까지 기다린 후 작업2 실행
				// 비동기 : 작업 1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
				async : false,	// default : true
				url : '<c:url value="/ajax/json/json"/>', 	
				type : 'post', 	// json으로 보낼때는 post로
				data : JSON.stringify(obj),	// 객체를 json형태의 문자열로 변환
				// contentType : 서버로 보내는 데이터의 타입(위에 있는 데이터의 타입)
				contentType : "application/json; charset=utf-8",
				// dataType : 서버에서 보내는 데이터의 타입(success에 있는 data의 데이터 타입)
				dataType : "json", 
				success : function (data){
					// 서버에서 보낸 name과 id, pw 를 콘솔창에 출력
					console.log(data.member.id);
					console.log(data.member.pw);
					console.log(data.name);
					// success에 구현한 함수에 return을 지정하면 success함수의 결과를 리턴
					// clickTest1의 리턴을 원하지만, success함수의 결과를 리턴
					// return name;
					name = data.name;
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			// console.log(data); ajax의 success매개변수이므로 현위치에서 사용 x
			return name;
		}
		
		$(".btn1").click(function(){
			let obj ={
					id : "abc",
					pw : "def"
			}
			// 작업1
			let name = clickTest1(obj);
			console.log(name);
			
			// 작업 2
		});
	</script>
	
	<!-- object - json -->
	<script type="text/javascript">
		$(".btn2").click(function(){
			let obj = {
				id : "asd",
				name : "홍길동"
			}
			$.ajax({
				async : true,
				url : '<c:url value="/ajax/object/json"/>', 
				type : 'get', 
				data : obj, 
				dataType : "json", 
				success : function (data){
					console.log(data.age);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
	
	<!-- object - object -->
	<script type="text/javascript">
		$(".btn4").click(function(){
			let obj = {name : "홍길동"};
			$.ajax({
				async : true,
				url : '<c:url value="/ajax/object/object"/>', 
				type : 'get', 
				data : obj,
				success : function (data){
					console.log(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
</body>
</html>
