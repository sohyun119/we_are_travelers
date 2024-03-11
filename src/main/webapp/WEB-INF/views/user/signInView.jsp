<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</head>
<body>

	<div id="wrap">
	
		
		
		<section class=" content d-flex justify-content-center ">
		
			
		
			<div class="loginBox bg-white border" style="background:linear-gradient(#4f94d4,#9ec2e6); border-radius:20px; color:white; margin: 90px;">
				<div style="margin:50px;">
					<h1 class="text-center mt-5 font-italic" >We are Travelers</h1>
					<div class="mt-5">
						<h6 class="mt-2 text-center" style="margin:5px 0px 5px 0px;">방문하고 싶은 곳의 소식을 보고 공유해보세요 :)</h6>
						<form id="loginForm">
							<input type="text" id="loginIdInput" class="form-control mt-5"  placeholder="아이디" >
							<input type="password" id="passwordInput" class="form-control mt-3" placeholder="비밀번호" >
							<button type="submit" class="btn btn-block my-3 " style="background-color:#01263a; color:white">로그인</button> <hr>
							<div class="text-center">계정이 없으신가요? <a href="/user/signUpView" style="color:white">*가입하기*</a></div>
						</form>
					</div>
				</div>
			</div>
		</section>
		
		
	
	</div>
	
	
	<script>
		$(document).ready(function(){
			
			$("#loginForm").on("submit",function(e){
				
				e.preventDefault(); // submit 이벤트 무효화 시키는 것
				
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				if(loginId == ""){
					alert("아이디를 입력해주세요.");
					return;
				}
				if(password == ""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				
				
				$.ajax({
					type:"post",
					url:"/user/signIn",
					data:{"loginId":loginId,"password":password},
					success:function(data){
						if(data.result == "success"){
							alert("로그인 성공!");
							location.href = "/post/home";
						}else{
							alert("로그인 실패");
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