var BOARDS = (function (window){

	 'use strict';

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
				'userId' : 1,
				'boardName' : $('.board-name').val()
			};

		  //위에서 만든 오브젝트를 json 타입으로 바꾼다.
			var json = JSON.stringify(data);
			var url = $(".add-board-form").attr("action");
		 $.ajax({
			type: 'post',
			url: url,
			data: json,
			dataType: 'json',
			contentType: 'application/json'
		 }).done(function(){

            $(".warning").css("display","none");
            var str = Template.board.replace(/\{\{input-value\}\}/gi,boardName);
            $(".board-name").val("");
            $("#modal").modal("close");
            $(".board-list").append(str);

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
