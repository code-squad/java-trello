var BOARD = (function (window){

	'use strict';

  	var deckTemplate = Handlebars.compile(Template.deck),
  		cardTemplate = Handlebars.compile(Template.card),
  		commentTemplate = Handlebars.compile(Template.comment);

	function init(){

		$("#modal").modal();
		$("#warning-modal").modal();
		$(".close-moadl").on("click", closeModal)
		$(".members-btn").on("click", showMembers);
		$("#board-canvas").on("click",".add-card-btn", showCreateCardForm);
    	$("#board-canvas").on("click",".save-card", saveCard);
    	$("#board-canvas").on("click",".cancel-card", cancelCard);
		$("#board-canvas").on("click", ".deck-card-title", openCardModal);
		$(".add-deck-btn").on("click", showCreateDeckForm);
		$(".save-deck").on("click", saveDeck);
		$(".cancel-deck").on("click", cancelDeck);
		$(".attach-from-computer").on("click", fileUpload);
		$(".comment-send").on("click", addComment);
		$(".datepicker").pickadate({
			selectMonths: true,
			selectYears: 15
		});
   		$(".due-date-btn").on("click", setDate);
   		$(".file-attachment").on("click", setAttachment);
		$(".members-btn-in-card").on("click", searchMember);
		$(".card-description-edit-btn").on("click", showCardDescriptionEdit);
		$(".card-edit-close").on("click", closeCardEdit);
        $(".card-edit-save").on("click", saveCardEdit);
        $(".datepicker").on("change", setDueDate);

	}

	function closeModal(e){


		var modalName = $(e.target).closest(".modal").attr('id');

		if(modalName === "modal") {

			$("#modal").modal("close");

		}else if(modalName === "warning-modal") {

            $("#warning-modal").modal("close");
		}

	}

	function showMembers(){

			if($(".member-list").hasClass("clicked")){
				$(".member-list").removeClass("clicked").slideUp();
				return;
			}

			$(".member-list").addClass("clicked").slideDown();

	}

	function showCreateCardForm(e){

        $(e.target).closest(".card-composer").find(".add-card-form").css('display', 'block');
        $(e.target).closest("a.add-card-btn").css('display', 'none');

	 }

	function saveCard(e){

        var cardTitle = $(e.target).parents(".add-card-form").find(".card-title").val();

		if(cardTitle == "") {
			$("#warning-modal").modal("open");
			return;
		}

        // $.ajax({
        //
        // }).done(function(){

			$(".add-card-form").css('display', 'none');
			var card = cardTemplate({"value":cardTitle});
			var $deckWrapper = $(e.target).closest(".deck-wrapper");
			$deckWrapper.find(".deck-cards").append(card);
			$(e.target).parents(".add-card-form").find(".card-title").val("");
			$(e.target).parents(".card-composer").find("a.add-card-btn").css('display', 'block');
        // }).fail(function(){
        //
        // });

    }

	function cancelCard(e){

		$(e.target).closest(".card-composer .add-card-form").css('display', 'none');
		$(e.target).parent(".add-card-form").find(".card-title").val("");
		$(e.target).closest(".card-composer").find("a.add-card-btn").css('display', 'block');
	}

	function showCreateDeckForm(){

			$(".add-deck-btn").css('display','none');
			$(".add-deck-form").css('display','block');
	}

	function saveDeck(e){

		e.preventDefault();

		var deckTitle = $("#add-deck").val();

		if(deckTitle == ""){
			$("#warning-modal").modal('open');
			return;
		}

        // $.ajax({
        //
        // }).done(function(){

			$(".add-deck-form").css('display','none');
			var deck = deckTemplate({"value":deckTitle})
			$(".add-deck-area").before(deck);
			$("#add-deck").val("");
			$(".add-deck-btn").css('display','block');

        // }).fail(function(){
        //
        // });


		}

	function cancelDeck(){

		$(".add-deck-btn").css('display','block');
		$(".add-deck-form").css('display','none');

	}

	function openCardModal(e){

			$("#modal").modal('open');
			var title = $(e.target).text();
			$(".card-title-in-modal").text(title);
			var deckName = $(e.target).closest(".deck-content").find(".deck-header-name").val();
			$(".deck-name").text(deckName);

	}

	function setAttachment(){

		if($(".modal-for-attachment").hasClass("clicked")){
			$(".modal-for-attachment").removeClass("clicked").slideUp();
			return;
		}

		$(".modal-for-due-date").removeClass("clicked").slideUp();
		$(".modal-for-members").removeClass("clicked").slideUp();
		$(".modal-for-attachment").addClass("clicked").slideDown("slow", "easeInOutQuart");
	}

	function setDate(){

		if($(".modal-for-due-date").hasClass("clicked")){
			$(".modal-for-due-date").removeClass("clicked").slideUp();
			return;
		}

        $(".modal-for-attachment").removeClass("clicked").slideUp();
        $(".modal-for-members").removeClass("clicked").slideUp();
		$(".modal-for-due-date").addClass("clicked").slideDown("slow", "easeInOutQuart");

	}

  	function searchMember(){

		if($(".modal-for-members").hasClass("clicked")){
			$(".modal-for-members").removeClass("clicked").slideUp();
			return;
		}

        $(".modal-for-attachment").removeClass("clicked").slideUp();
        $(".modal-for-due-date").removeClass("clicked").slideUp();
		$(".modal-for-members").addClass("clicked").slideDown("slow", "easeInOutQuart");
	}

	function addComment(e){

		var commentContent = $(".comment-contents").val();

		if(commentContent == ""){

            $("#warning-modal").modal('open');
            return;

		}

        // $.ajax({
        //
        // }).done(function(){

			var now = new Date();
			var currentTime = now.getDate() + " " +
				monthToString(now.getMonth()+1) + " " +
				now.getFullYear() + " at " +
				now.getHours() + ":" +
				now.getMinutes();
			$(commentTemplate({"comment-contents":commentContent, "current-time":currentTime})).appendTo(".comments");
			$(".comment-contents").val("");

        // }).fail(function(){
        //
        // });

	}

	function monthToString(month){

		if(month === 1){
			return "Jan";
		}else if(month === 2){
			return "Feb";
		}else if(month === 3){
			return "Mar";
		}else if(month === 4){
			return "Apr";
		}else if(month === 5){
			return "May";
		}else if(month === 6){
			return "Jun";
		}else if(month === 7){
			return "July";
		}else if(month === 8){
			return "Aug";
		}else if(month === 9){
			return "Sep";
		}else if(month === 10){
			return "Oct";
		}else if(month === 11){
			return "Nov";
		}else if(month === 12){
			return "Dec";
		}
	}

	function fileUpload(){

			$("#fileUpload").trigger("click");

		}

	function showCardDescriptionEdit(e){

		$(".card-description-edit").css("display","block");
        $(".card-description-edit-btn").css("display","none");

        var descriptionContent = $(".card-description").text();

        if($(".card-description").text() != null){

            $(".card-description-textarea").val(descriptionContent);
            $(".card-description").css("display", "none");
		}

	}

	function closeCardEdit(){

        $(".card-description-edit").css("display","none");
        $(".card-description-edit-btn").css("display","block");
        $(".card-description").css("display","block");

	}

	function saveCardEdit(){


        var description = $(".card-description-textarea").val();

        if(description == ""){

            $("#warning-modal").modal('open');
            return;

		}

        // $.ajax({
        //
        // }).done(function(){

      		  $(".card-description-textarea").val("");
        	  $(".card-description").text(description);
       		  $(".card-description-edit").css("display","none");
       		  $(".card-description-edit-btn").css("display","block");
		      $(".card-description").css("display","block");


        // }).fail(function(){
        //
        // });


	}

	function setDueDate(){

		var dueDate = $(".datepicker").val();
		$(".current-due-date").text(dueDate);

	}

	return {
		"init" : init
	}

})(window);

$(function(){
    BOARD.init();
});
