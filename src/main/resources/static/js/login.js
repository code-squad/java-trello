$(".login-form button[type=submit]").click(login);

function login(e) {
	e.preventDefault();

	var data = {
		'email' : $('#email').val(),
		'password' : $('#password').val()
	};
	var json = JSON.stringify(data);
	var url = $(".login-form").attr("action");

	$.ajax({
		type : 'post',
		url : url,
		data : json,
		contentType : "application/json; charset=utf-8",
		error : onError,
		success : onSuccess
	});
}

function onError(e) {
	console.log(e);
	$("#loginFail").html("이메일 혹은 비밀번호가 잘못됐습니다.");
}

function onSuccess(data, status) {
	location.replace("/boards");
}