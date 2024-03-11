<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>

	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<nav class="site-nav">
		<div class="container">
			<div class="menu-bg-wrap">
				<div class="site-navigation">
					<div class="row g-0 align-items-center">
						<div class="col-2">
							<a href="home" class="logo m-0 float-start">
							<div>We are</div>
							<div>Travelers</div>
							<span class="text-primary"></span></a>
						</div>
						<div class="col-8 text-center">
							<form action="#" class="search-form d-inline-block d-lg-none">
								<input type="text" class="form-control" placeholder="지역별 최신글 검색...">
								<span class="bi-search"></span>
							</form>

							<ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu mx-auto">
								<li class="active"><a href="home">Home</a></li>
								<li class="has-children">
									<a href="#">Post</a>
									<ul class="dropdown">
										<li><a href="#">관심멤버 최신글</a></li>
										<li><a href="#">지역 최신글</a></li>
										<li><a href="#">여행자 커뮤니티</a></li>
									</ul>
								</li>
								<li class="has-children">
									<a href="#">My home</a>
									<ul class="dropdown">
										<li><a href="#">마이홈</a></li>
										<li><a href="#">글 작성</a></li>
										<li><a href="#">설정</a></li>
									</ul>
								</li>
								<li class="has-children">
									<a href="#">Be Ready</a>
									<ul class="dropdown">
										<li><a href="#">날씨검색</a></li>
										<li><a href="#">여행계획 추천</a></li>
										<li><a href="#">뉴스보기</a></li>
									</ul>
								</li>
								<li>
									<a href="/user/signOut">로그아웃</a>
								</li>
							</ul>
						</div>
						<div class="col-2 text-end">
							<a href="#" class="burger ms-auto float-end site-menu-toggle js-menu-toggle d-inline-block d-lg-none light">
								<span></span>
							</a>
							<form action="#" class="search-form d-none d-lg-inline-block">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="bi-search"></span>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>

</header>
