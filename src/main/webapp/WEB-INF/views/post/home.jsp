<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- /*
* Template Name: Blogy
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!Doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap5" />

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;600;700&display=swap" rel="stylesheet">


	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

	<link rel="stylesheet" href="css/tiny-slider.css">
	<link rel="stylesheet" href="css/aos.css">
	<link rel="stylesheet" href="css/glightbox.min.css">
	<link rel="stylesheet" href="/static/css/style.css">

	<link rel="stylesheet" href="css/flatpickr.min.css">


	<title>Main Home</title>
</head>


<body>

	<!-- header -->
	<c:import url="/WEB-INF/views/include/header.jsp" />
	
	<!-- Start 메인 메뉴탭 -->
	<section class="section bg-light">
		<div class="container">
			<div class="row align-items-stretch retro-layout">
				<div class="col-md-4">
					<a href="#" class="h-entry mb-30 v-height gradient">

						<div class="featured-img" style="background-image: url('images/img_2_horizontal.jpg');"></div>

						<div class="text">
							<span class="date">지역별 날씨 검색</span>
							<h2>지금 원하는 지역의 날씨를 검색하세요!</h2>
						</div>
					</a>
					<a href="#" class="h-entry v-height gradient">

						<div class="featured-img" style="background-image: url('images/img_5_horizontal.jpg');"></div>

						<div class="text">
							<span class="date">여행 계획 추천받기</span>
							<h2>chat GPT가 짜주는 여행 계획 추천을 받아보세요 :)</h2>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="#" class="h-entry img-5 h-100 gradient">

						<div class="featured-img" style="background-image: url('images/img_1_vertical.jpg');"></div>

						<div class="text">
							<span class="date">지역 최신 게시물</span>
							<h2>지금, 원하는 지역의 소식을 찾아보고 즐겨찾기 해보세요!</h2>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="#" class="h-entry mb-30 v-height gradient">

						<div class="featured-img" style="background-image: url('images/img_3_horizontal.jpg');"></div>

						<div class="text">
							<span class="date">My feed home</span>
							<h2>내 여행 기록 확인하기</h2>
						</div>
					</a>
					<a href="#" class="h-entry v-height gradient">

						<div class="featured-img" style="background-image: url('images/img_4_horizontal.jpg');"></div>

						<div class="text">
							<span class="date">실시간 여행자 채팅방 입장</span>
							<h2>지역별로 원하는 정보를 실시간으로 공유할 수 있는 채팅방에 입장하세요!</h2>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- End 메인 메뉴 탭 -->


	<!-- Start 관심 멤버 최신글 -->
	<section class="section">
		<div class="container">

			<!-- 제목, 더 보기 버튼 -->
			<div class="row mb-4">
				<div class="col-sm-6">
					<h2 class="posts-entry-title">관심 멤버 최신 소식</h2>
				</div>
				<div class="col-sm-6 text-sm-end"><a href="#" class="read-more">View All</a></div>
			</div>

			<!-- 본문 게시 -->
			<div class="row">
				<c:forEach begin="1" end="9" step="1" varStatus="i">
					<div class="col-lg-4 mb-4">
						<div class="post-entry-alt">
							<a href="single.html" class="img-link"><img src="images/img_7_horizontal.jpg" alt="Image" class="img-fluid"></a>
							<div class="excerpt">
								
	
								<h2><a href="single.html">제목 : ${i.count} </a></h2>
								<div class="post-meta align-items-center text-left clearfix">
									<figure class="author-figure mb-0 me-3 float-start"><img src="images/person_1.jpg" alt="Image" class="img-fluid"></figure>
									<span class="d-inline-block mt-1">By <a href="#">David Anderson</a></span>
									<span>&nbsp;-&nbsp; July 19, 2019</span>
								</div>
	
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo sunt tempora dolor laudantium sed optio, explicabo ad deleniti impedit facilis fugit recusandae! Illo, aliquid, dicta beatae quia porro id est.</p>
								<p><a href="#" class="read-more">Continue Reading</a></p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- End 관심멤버 최신글 -->
	
	
	<!-- Start 관심지역 소식 -->
	<c:forEach begin="1" end="9" step="1" varStatus="i">
		<section class="section posts-entry posts-entry-sm bg-light">
			<div class="container">
				<div class="row">
					<div class="row mb-4">
						<div class="col-sm-6">
							<h2 class="posts-entry-title">관심 지역 최신 소식 ${i.count }</h2>
						</div>
						<div class="col-sm-6 text-sm-end"><a href="#" class="read-more">View All</a></div>
					</div>
					
					<!-- 본문 -->
					<c:forEach begin="1" end="4" step="1" varStatus="j">
						<div class="col-md-6 col-lg-3">
							<div class="blog-entry">
								<a href="single.html" class="img-link">
									<img src="images/img_1_horizontal.jpg" alt="Image" class="img-fluid">
								</a>
								<span class="date">Apr. 14th, 2022</span>
								<h2><a href="single.html">제목 : ${j.count }</a></h2>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
								<p><a href="#" class="read-more">Continue Reading</a></p>
							</div>
						</div>
					</c:forEach>
					<!-- /본문 -->
				</div>
			</div>
		</section>
	</c:forEach>
	<!-- End 관심지역 소식 -->

	<!-- Start 뉴스 스트립트 -->
	<div class="section bg-light">
		<div class="container">

			<div class="row mb-4">
				<div class="col-sm-6">
					<h2 class="posts-entry-title">지금, 여행지 뉴스</h2>
				</div>
				<div class="col-sm-6 text-sm-end"><a href="category.html" class="read-more">View All</a></div>
			</div>

			<div class="row align-items-stretch retro-layout-alt">

				<div class="col-md-5 order-md-2">
					<a href="single.html" class="hentry img-1 h-100 gradient">
						<div class="featured-img" style="background-image: url('images/img_2_vertical.jpg');"></div>
						<div class="text">
							<span>February 12, 2019</span>
							<h2>Meta unveils fees on metaverse sales</h2>
						</div>
					</a>
				</div>

				<div class="col-md-7">

					<a href="single.html" class="hentry img-2 v-height mb30 gradient">
						<div class="featured-img" style="background-image: url('images/img_1_horizontal.jpg');"></div>
						<div class="text text-sm">
							<span>February 12, 2019</span>
							<h2>AI can now kill those annoying cookie pop-ups</h2>
						</div>
					</a>

					<div class="two-col d-block d-md-flex justify-content-between">
						<a href="single.html" class="hentry v-height img-2 gradient">
							<div class="featured-img" style="background-image: url('images/img_2_sq.jpg');"></div>
							<div class="text text-sm">
								<span>February 12, 2019</span>
								<h2>Don’t assume your user data in the cloud is safe</h2>
							</div>
						</a>
						<a href="single.html" class="hentry v-height img-2 ms-auto float-end gradient">
							<div class="featured-img" style="background-image: url('images/img_3_sq.jpg');"></div>
							<div class="text text-sm">
								<span>February 12, 2019</span>
								<h2>Startup vs corporate: What job suits you best?</h2>
							</div>
						</a>
					</div>  

				</div>
			</div>

		</div>
	</div>
	<!-- End 뉴스 스트립트 -->


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
