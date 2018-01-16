var BOARDS = (function (window){

	 'use strict';
	 var boardTemplate = Handlebars.compile(Template.board);


	function init(){

    	$("#modal").modal();
		$(".board-list").on("click", ".board", gotoBoard);
		$(".add-board-btn").on("click", showCreateBoardForm);
		$(".add-board-form .save").on("click", createNewBoard);
		$(".close-moadl").on("click", closeModal);

	}

	function showCreateBoardForm(){

		$('#modal').modal('open');

	}

	function createNewBoard(){

		var boardName = $(".board-name").val();

		if(boardName == ""){
			$(".warning").css("display","block");
			return;
		}
		var data = {
				'name' : $('.board-name').val()
			};

		  // 위에서 만든 오브젝트를 json 타입으로 바꾼다.
			var json = JSON.stringify(data);
			var url = $(".add-board-form").attr("action");
		 $.ajax({
			type: 'post',
			url: url,
			data: json,
			dataType: 'json',
			contentType: 'application/json'
		 }).done(function(data){
            $(".warning").css("display","none");
            	var board = boardTemplate({"id":data.id, "input-value":data.name})

            $(".board-name").val("");
            $("#modal").modal("close");
            $(".board-list").append(board);

		 }).fail(function(){
        
		 });

    }

	function gotoBoard(){

		window.location.href = ("board.html");

	}

	function closeModal(){

        $("#modal").modal("close");

	}


	return {
		"init" : init
	}
})(window);

$(function(){
    BOARDS.init();
});
