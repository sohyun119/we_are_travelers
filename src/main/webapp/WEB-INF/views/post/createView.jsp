<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap5" />
	
	<!-- jQuery 로드 -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- ajax -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
	
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;600;700&display=swap" rel="stylesheet">


	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

	<link rel="stylesheet" href="/css/tiny-slider.css">
	<link rel="stylesheet" href="/css/aos.css">
	<link rel="stylesheet" href="/css/glightbox.min.css">
	<link rel="stylesheet" href="/static/css/style.css">

	<link rel="stylesheet" href="/css/flatpickr.min.css">
	

	<title>글 작성</title>
</head>
<body>

	<!-- start header -->
	<c:import url="/WEB-INF/views/include/header.jsp" />

	<div class="hero overlay inner-page bg-primary py-5">
		<div class="container">
			<div class="row align-items-center justify-content-center text-center pt-5">
				<div class="col-lg-6">
					<h1 class="heading text-white mb-3" data-aos="fade-up">Creating a Post</h1>
					<h5 class="heading text-white mb-3" data-aos="fade-up">위치와 사진을 공유하고, 여행을 기록해보세요!</h5>
				</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	
	<div class="section">
		<div class="container">
			<div class="row">
			
				<!-- input from -->
				
					<!-- start left map -->
					<div class="col-lg-4 mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="100">
						<div class="contact-info">
							<div class="address mt-2">
								<i class="bi bi-geo-alt"></i>
								<h4 class="mb-2">
									Location name : 
									<input type="text" id="locationName"><button id="locationBtn" type="button" class="btn" >조회</button>
								</h4>
								
							</div>
							<div>
								<!-- google map 띄우기 -->
								<div id="map" style="height: 400px; width: 100%;"></div>
							</div>
						</div>
					</div>
					<!-- end left map -->
					
					<!-- start right input -->
					<div class="col-lg-8" data-aos="fade-up" data-aos-delay="200">
						<div class="row">
							<div class="col-12 mb-3">
								<input type="file" id="fileInput" class="form-control" multiple="multiple" name="files" placeholder="사진 선택">
							</div>
							<div class="col-12 mb-3">
								<textarea name="contentInput" id="contentInput" cols="30" rows="13" class="form-control" placeholder="text.."></textarea>
							</div>

							<div class="col-12">
								<button type="submit" id="saveBtn" class="btn btn-primary">저장</button>
							</div>
						</div>
					</div>
					<!-- end right input -->
				
			</div>
		</div>
	</div> 

	<!-- footer -->
	<c:import url="/WEB-INF/views/include/footer.jsp" />

    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
    	<div class="spinner-border text-primary" role="status">
    		<span class="visually-hidden">Loading...</span>
    	</div>
    </div>

	<script>
	
			var ajaxData = {};
			var map;
			var latInput,lngInput,locationInput;
			
			function initMap() {
	            map = new google.maps.Map(document.getElementById('map'), {
	                center: {lat: 37.497952, lng: 127.027619},
	                zoom: 18
	            });
	        }
			
			function updateMap() {
				var latData = parseFloat(latInput);
				var lngData = parseFloat(lngInput);
				
				map.setCenter({lat: latData, lng: lngData});
				
	        }
			
			$(document).ready(function () {
				
				initMap();
				
				$(document).on("click", "#locationBtn", function () {
					var locationName = $("#locationName").val();
					
					if(locationName == null || locationName == ""){
						alert("장소를 입력해주세요");
						return;
					}
					
					$.ajax({
						type:"get",
						url:"/post/getCoordinates",
						data:{"locationName":locationName},
						success:function(data){
							ajaxData = data;
							
							latInput = ajaxData.lat;
							lngInput = ajaxData.lng;
							locationInput = locationName;
							
							updateMap();
						
						},
						error:function(){
							alert("(지역이름 조회 에러) 정확한 지역명을 입력해주세요.");
							console.log("지역이름 조회 Error: " + error);
						}
					});
				});
				
				$(document).on("click", "#saveBtn", function (){
					
					var content = $("#contentInput").val();
					let files = $("#fileInput").get(0).files; // 이렇게 가져와야 했음!!!!
					
					if(latInput == "" || lngInput == "" || locationInput == ""){
						alert("장소를 선택해주세요");
						return;
					}
					
					if(files.length == 0){
						alert("사진을 업로드하세요");
						return;
					}
					
					
					var formData = new FormData();
					formData.append("content", content);
					formData.append("lat", latInput);
					formData.append("lng", lngInput);
					formData.append("location", locationInput);
					
					for(let i = 0; i < files.length; i++){
						formData.append("files", files[i]);
					}
					
					
					$.ajax({
						type:"post",
						url:"/post/create",
						data:formData,
						enctype:"multipart/form-data",
						processData:false,
						contentType:false,
						success:function(data){
							if(data.result == "success"){
								alert("업로드 완료");
								location.href = "/post/home";
							}else{
								alert("업로드를 실패했습니다");
							}
						},
						error:function(){
							alert("에러발생");
						}
					});
					
				});
			});
			
			
			
	
	</script>

    <script src="/static/js/bootstrap.bundle.min.js"></script>
    <script src="/static/js/tiny-slider.js"></script>
	
    <script src="/static/js/flatpickr.min.js"></script>


    <script src="/static/js/aos.js"></script>
    <script src="/static/js/glightbox.min.js"></script>
    <script src="/static/js/navbar.js"></script>
    <script src="/static/js/counter.js"></script>
    <script src="/static/js/custom.js"></script>
    
    <!-- google map api -->
    <script async="false"
        src="http://maps.googleapis.com/maps/api/js?key= + ${googlemapkey} + &libraries=places&callback=initMap">
	</script>
	
	

    
  </body>
  </html>
