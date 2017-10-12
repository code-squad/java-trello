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

		// $.ajax({
		//
		// }).done(function(){

            $(".warning").css("display","none");
            var str = Template.board.replace(/\{\{input-value\}\}/gi,boardName);
            $(".board-name").val("");
            $("#modal").modal("close");
            $(".board-list").append(str);

		// }).fail(function(){
        //
		// });

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
