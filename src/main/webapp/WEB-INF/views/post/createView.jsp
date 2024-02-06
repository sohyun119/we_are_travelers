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
	
	
	<script async defer
        src="https://maps.googleapis.com/maps/api/js?key= + ${google.maps.api.key} + &libraries=places&callback=initMap">
	</script>
	
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
			
				<!-- start left map -->
				<div class="col-lg-4 mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="100">
					<div class="contact-info">
						<div class="address mt-2">
							<i class="bi bi-geo-alt"></i>
							<h4 class="mb-2">Location:</h4>
							<p>위치 이름</p>
						</div>
						<div>
							<!-- google map 띄우기 -->
							<div id="map" style="height: 400px; width: 100%;"></div>
						    <script>
						        function initMap() {
						            var map = new google.maps.Map(document.getElementById('map'), {
						                center: {lat: -34.397, lng: 150.644},
						                zoom: 8
						            });
						        }
						    </script>
						</div>
					</div>
				</div>
				<!-- end left map -->
				
				<!-- start right input -->
				<div class="col-lg-8" data-aos="fade-up" data-aos-delay="200">
					<form action="#">
						<div class="row">
							<div class="col-12 mb-3">
								<input type="" class="form-control" placeholder="사진 선택">
							</div>
							<div class="col-12 mb-3">
								<textarea name="" id="" cols="30" rows="13" class="form-control" placeholder="text.."></textarea>
							</div>

							<div class="col-12">
								<input type="submit" value="Send Message" class="btn btn-primary">
							</div>
						</div>
					</form>
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


    <script src="/static/js/bootstrap.bundle.min.js"></script>
    <script src="/static/js/tiny-slider.js"></script>

    <script src="/static/js/flatpickr.min.js"></script>


    <script src="/static/js/aos.js"></script>
    <script src="/static/js/glightbox.min.js"></script>
    <script src="/static/js/navbar.js"></script>
    <script src="/static/js/counter.js"></script>
    <script src="/static/js/custom.js"></script>

    
  </body>
  </html>
