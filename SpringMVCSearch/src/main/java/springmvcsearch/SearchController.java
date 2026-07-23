package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController 
{

	@RequestMapping("/home")
	public String home() {
		System.out.println("Going to home view...");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		
		RedirectView redirectView = new RedirectView();

	    if (query == null || query.trim().isEmpty()) {
	        // Redirect to the same page
	        redirectView.setUrl("http://localhost:8080/SpringMVCSearch/home?querybox=");   // change this to your current page URL
	    } else {
	        String url = "https://www.google.com/search?q=" + query;
	        redirectView.setUrl(url);
	    }
		return redirectView;
		
	}
}
