package iChee;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllor {

	@RequestMapping(value = "hello/{name}", produces = "application/json", method = {RequestMethod.GET})
	@ResponseBody
	public String hello(
			@PathVariable String name)
	{
		JSONObject object = new JSONObject();
		object.put("name", name);
		return object.toString();
	}

	@RequestMapping(value = "view/hello/{name}", method = {RequestMethod.GET})
	public ModelAndView helloView(
			@PathVariable String name)
	{
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
