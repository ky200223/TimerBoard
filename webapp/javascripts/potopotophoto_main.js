var loginFeature = {		
		loginStatusDisplay : function() {
			if (global_vars.loginStatus === global_vars.login_Status_On)
				document.getElementById("loginStatus").innerHTML = global_vars.userNickName + " 님, 반갑습니다!";
			else
				document.getElementById("loginStatus").innerHTML = "로그인 되지 않았습니다.";
		},
		
		loginErrorMessageAlert : function() {
			if (global_vars.loginErrorMessage)
				alert(global_vars.loginErrorMessage);
		}
};
	
var onloadEvent = {	
	onloadExecute : function() {
		onloadEvent.loginSection();
		onloadEvent.boardSection();
		onloadEvent.uploadSection();
	},
	
	loginSection : function() {
		loginFeature.loginStatusDisplay();
		//loginFeature.loginErrorMessageAlert();
	}, 
	
	boardSection : function() {
		boardFeature.countComment();
	},
	
	uploadSection : function () {
	}
};
	
var boardFeature = {
	countComment : function() {
		var boardList = document.querySelectorAll('.eachBoardSection');
		for (var i = 0; i < boardList.length; i++) {
			var currentNode = boardList[i];
			var commentCount = currentNode.querySelectorAll('.commentContents').length;
			var activeCommentSection = currentNode.querySelector('.commentCount');
			activeCommentSection.innerHTML = commentCount + "개의 댓글";
		}	
	},
	
	commentOff : function(e) {
		var commentToggle = e.target;
		var commentSection = commentToggle.parentNode.nextElementSibling;
		commentSection.style.display = "none";
		commentToggle.removeEventListener('click', boardFeature.commentOff, false);
		commentToggle.addEventListener('click', boardFeature.commentOn, false);
	},
	
	commentOn : function(e) {
		var commentToggle = e.target;
		var commentSection = commentToggle.parentNode.nextElementSibling;
		commentSection.style.display = "block";
		commentToggle.removeEventListener('click', boardFeature.commentOn, false);
		commentToggle.addEventListener('click', boardFeature.commentOff, false);
	},
	
	writeComment : function(e) {
		e.preventDefault();
		var eleForm = e.currentTarget.form;
		var oFormData = new FormData(eleForm);
		var sID = eleForm[0].value;
		
		var url = "/board/" + sID + "/comments.json";
		var request = new XMLHttpRequest();
		
		request.open("POST" , url, true);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var obj = JSON.parse(request.responseText);
				var eleCommentList = eleForm.parentElement.previousElementSibling;
				eleCommentList.insertAdjacentHTML("afterend", "<div class=\"commentField\">" + "<div class = \"commentContents\">" + obj.reply + "</div>" + +"<div class = \"commentDeleteForm\">" + "<form action = \"/board/${comment.id}/deleteComment\" method=\"post\">" + "<button class = \"commentDeleteButton\" type = \"submit\">" + "삭제" + "</button>" + "</form>" + "</div>" + "</div>" + "<div class = \"horizonLine\">" + "</div>");
			};
		};
		request.send(oFormData);
		//ajax 통신이 끝난 후 폼의 값을 초기화 해준다.
		eleForm[1].value = "";
	}
};
	
var uploadFeature = {	
	resetDefaultText : function() {
		defaultBoardContents.innerHTML = "";
		defaultBoardContents.removeEventListener('click', uploadFeature.resetDefaultText, false);
	}	
};
	
window.onload = onloadEvent.onloadExecute;

var defaultBoardContents = document.getElementById("defaultBoardContents");
defaultBoardContents.addEventListener('click', uploadFeature.resetDefaultText, false);

var commentToggle = document.getElementsByClassName('commentToggle');
for (var i = 0 ; i < commentToggle.length ; i++) {
	commentToggle[i].addEventListener('click', boardFeature.commentOff, false);
}

var commentSubmitButton = document.getElementsByClassName('commentButton');
for (var j = 0 ; j < commentSubmitButton.length ; j++) {
	commentSubmitButton[j].addEventListener('click', boardFeature.writeComment, false);
}
