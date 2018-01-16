$(".signup-form input[type=submit]").click(signUp);

function signUp(e) {
	e.preventDefault();

	var data = {
		'name' : $('#name').val(),
		'password' : $('#password').val(),
		'email' : $('#email').val()
	};
	var json = JSON.stringify(data);
	var url = $(".signup-form").attr("action");

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
	$("#signUpFail").html("이미 존재하는 이메일 입니다.");
}

function onSuccess(data, status) {
	console.log("hahahahah")
	location.replace("/login");
}