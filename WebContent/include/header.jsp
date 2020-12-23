<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="../resource/css/bootstrap.css">
</head>
<body>
	<header class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm sticky-top">
		<p class="h5 my-0 mr-auto fw-normal">Team Method</p>
		<nav class="my-2 my-md-0 me-md-3">
			<a class="p-2 text-dark" href="qna?cmd=qna_list">1:1문의</a>
	    	<a class="p-2 text-dark" href="coin?cmd=coin_list">Coin</a>
	    	<a class="p-2 text-dark" href="ranking?cmd=ranking_list">Ranking</a>
	  		<a class="btn btn-outline-primary" href="" data-toggle="modal" data-target="#loginModalForm">Sign in</a>
			<a class="btn btn-outline-primary" href="users?cmd=sign_up">Sign up</a>
		</nav>
	</header>
		<!-- Modal -->
		<div class="modal fade" id="loginModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
			<div class="modal-dialog" role="document">
				<!--Content-->
				<div class="modal-content form-elegant">
					<!--Header-->
					<div class="modal-header text-center">
					<h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Sign in</strong></h3>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!--Body-->
					<form type="post" action="#">
						<div class="modal-body mx-4">
							<!--Body-->
							<div class="md-form mb-5">
								<input type="text" id="Form-id" class="form-control validate" required>
								<label data-error="wrong" data-success="right" for="Form-id">Your id</label>
							</div>
			
							<div class="md-form pb-3">
								<input type="password" id="Form-pass" class="form-control validate" required>
								<label data-error="wrong" data-success="right" for="Form-pass">Your password</label>
								<p class="font-small blue-text d-flex justify-content-end">Forgot <a href="#" class="blue-text ml-1">
									Id?</a><a href="#" class="blue-text ml-1">
									Password?</a></p>
							</div>
			
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block btn-rounded z-depth-1a">Sign in</button>
							</div>
						</div>
					</form>
				</div>
			<!--/.Content-->
			</div>
		</div>
		<!-- Modal -->
	<main class="container">
		<div style="min-height: 400px;"
		class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
</body>
</html>