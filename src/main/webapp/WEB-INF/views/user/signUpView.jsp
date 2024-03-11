<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		
</head>
<body>
	
	<div id="wrap" >
		
		
		<section class="content d-flex justify-content-center " style="margin: 50px;">
			
			<div class="joinBox border" style="background:linear-gradient(#4f94d4,#9ec2e6); border-radius:20px; color:white">
				<h1 class="text-center mt-5 font-italic">We are Travelers</h1>
				<div class="mx-5">
					<h6 class="mt-3 text-center" style="margin:10px 0px 10px 0px;">관심있는 여행지에 관한 소식을 찾아보고 공유하며<br>여행 준비를 더욱 더 간편하게 시작해보세요!</h6>
					<input type="text" id="emailInput" placeholder="이메일 주소" class="form-control bg-light mt-4">
					<input type="text" id="nameInput" placeholder="성명" class="form-control bg-light mt-4">
					<div class="d-flex align-items-center mt-4">
						<input type="text" id="loginIdInput" placeholder="아이디" class="form-control bg-light">
						<button type="button" id="duplicateBtn" class="btn btn-light btn-sm text-secondary ml-2">중복 확인</button>
					</div>
					<input type="password" id="passwordInput" placeholder="비밀번호" class="form-control bg-light mt-4">
					<input type="password" id="passwordConfirmInput" placeholder="비밀번호 확인" class="form-control bg-light mt-4">
					<button type="button" id="joinBtn" class="btn mt-3 btn-block" style="background-color:#01263a; color:white">가입</button> <hr>
					<div class="text-center" >계정이 있으신가요? <a href="/user/signInView" style="color:white">*로그인*</a></div>
					<br>
				</div>
			</div>
		
		</section>
	
		
	
	</div>
	
	<script>
		$(document).ready(function(){
			
			var duplicate = "true";
			
			$("#duplicateBtn").on("click", function(){
				
				let loginId = $("#loginIdInput").val();
				
				if(loginId == ""){
					alert("아이디를 입력해주세요.");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/user/isDuplicateId",
					data:{"loginId":loginId},
					success:function(data){
						if(data.is_duplicate == "true"){
							duplicate = "true";
							alert("아이디가 중복되었습니다.");
						}
						else{
							duplicate = "false";
							alert("사용가능한 아이디 입니다.");
						}
					},
					error:function(){
						alert("에러발생");
					}
				});
			
				
			});
			
			// 중복검사를 했는지랑, 중복이 되었는지를 각각 다른 변수로 두어 관리해보기
			$("#loginIdInput").on("input",function(){ // *** 아이디를 다시 수정하는 순간 다시 중복검사를 하게 만든다!!!!!!!
				duplicate = "true";
			});
			
			
			$("#joinBtn").on("click", function(){
				let email = $("#emailInput").val();
				let name = $("#nameInput").val();
				let loginId = $("#loginIdInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfirmInput").val();
				
				if(email == ""){
					alert("이메일을 입력해주세요.");
					return;
				}
				if(name == ""){
					alert("이름을 입력해주새요.");
					return;
				}
				if(loginId == ""){
					alert("아이디를 입력해주세요.");
					return;
				}
				if(duplicate == "true"){
					alert("아이디 중복검사를 해주세요.");
					return;
				}
				if(password == ""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(password != passwordConfirm){
					alert("비밀번호가 같지 않습니다.");
					return;
				}
				
				
				$.ajax({
					type:"post",
					url:"/user/signUp",
					data:{"email":email,"name":name,"loginId":loginId,"password":password},
					success:function(data){
						if(data.result == "success"){
							alert("회원가입 완료!");
							location.href = "/user/signInView";
						}else{
							alert("회원가입을 실패했습니다.");
						}
					},
					error:function(){
						alert("에러발생");
					}
					
				});
				
			});
			
			
		});
	
	
	
	</script>




</body>
</html>