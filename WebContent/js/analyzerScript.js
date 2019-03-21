/**
 * 
 */

var text;

function myFunction() {
	text = document.getElementById("text").value;
	
	$.ajax({
		type:"GET",
		url:"AnalyzeEmotions.do",
		data:{text:text},
		success:function(result){
			
			var obj = JSON.parse(result);
			
			var anger = Math.round(obj.document.emotion.anger * 100) ;
			var disgust = Math.round(obj.document.emotion.disgust * 100);
			var fear = Math.round(obj.document.emotion.fear * 100);
			var joy = Math.round(obj.document.emotion.joy * 100);
			var sadness = Math.round(obj.document.emotion.sadness * 100);
			
			$("#sadness").width(sadness + "%");
			$("#sadnessNumber").text(sadness + "%");
			
			$("#joy").width(joy + "%");
			$("#joyNumber").text(joy + "%");
			
			$("#fear").width(fear + "%");
			$("#fearNumber").text(fear + "%");
			
			$("#disgust").width(disgust + "%");
			$("#disgustNumber").text(disgust + "%");
			
			$("#anger").width(anger + "%");
			$("#angerNumber").text(anger + "%");
		
		}
	})
}