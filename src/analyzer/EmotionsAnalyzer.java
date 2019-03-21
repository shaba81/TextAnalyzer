package analyzer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class EmotionsAnalyzer {

	
	public String Analyze(String text) {
		IamOptions options = new IamOptions.Builder()
			    .apiKey("d6PQvf5BNClu3H7gz-ry435NYNiDHaLhnMuRqTGgzWJG")
			    .build();

			NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2018-11-16", options);
			naturalLanguageUnderstanding.setEndPoint("https://gateway-lon.watsonplatform.net/natural-language-understanding/api");


			//Posso usarle per valutare le emozioni attorno a determinate parole
			List<String> targets = new ArrayList<String>();
			targets.add("word1");
			targets.add("word2");

			EmotionOptions emotion= new EmotionOptions.Builder()
			  //.targets(targets)
			  .build();

			//Qui imposto che statistiche deve andare ad analizzare nel testo: emotions, entities, keywords, concepts
			Features features = new Features.Builder()
			  .emotion(emotion)
			  .build();

			//Qui imposto i parametri. Tipo di testo (html, stringa...) e le features
			AnalyzeOptions parameters = new AnalyzeOptions.Builder()
			  .text(text)
			  .features(features)
			  .build();

			AnalysisResults response = naturalLanguageUnderstanding
			  .analyze(parameters)
			  .execute();
			
			
			String resp = response.getEmotion().toString();
			
			System.out.println(resp);
			return resp;
			
			
			
	}

}
