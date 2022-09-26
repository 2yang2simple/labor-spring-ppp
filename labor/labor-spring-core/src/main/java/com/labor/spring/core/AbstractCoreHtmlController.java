package com.labor.spring.core;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.labor.spring.base.BaseHtmlController;

public abstract class AbstractCoreHtmlController extends BaseHtmlController {
	
	private final String CORE_PREFIX = "00.";
	
	
	@RequestMapping(value = { "/redirect.html" }, method = RequestMethod.GET)
	public String toRedirect(ModelMap map) {	
		map.addAttribute("message","");
		return "redirect.html";
	}
	
	/******************
	 * core
	 */
	
	@RequestMapping(value = { "/core" }, method = RequestMethod.GET)
	public String toCoreIndex(ModelMap map) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/settings";
	}

	//labor setting
	@RequestMapping(value = { "/core/settings"}, method = RequestMethod.GET)
	public String toCoreSettingPage(ModelMap map) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/settings";
	}

	@RequestMapping(value = { "/core/asample/{page}" }, method = RequestMethod.GET)
	public String toAsamplePages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/asample/"+page;
	}
		
	@RequestMapping(value = { "/core/sysconfig/{page}" }, method = RequestMethod.GET)
	public String toCoreSysconfigPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/sysconfig/"+page;
	}
	
	
	//url rewrite;
	@RequestMapping(value = { "/rt/uuid/{uuid}.html" }, method = RequestMethod.GET)
	public String toRichtextViewPage(ModelMap map,@PathVariable(value="uuid") String uuid) {	
		map.addAttribute("uuid",uuid);
		return CORE_PREFIX + "core/richtext/viewer";
	}
	//url rewrite;
	@RequestMapping(value = { "/rt/name/{name}.html" }, method = RequestMethod.GET)
	public String toRichtextNamePage(ModelMap map,@PathVariable(value="name") String name) {	
		map.addAttribute("name",name);
		return CORE_PREFIX + "core/richtext/viewer";
	}

	@RequestMapping(value = { "/core/richtext/{page}" }, method = RequestMethod.GET)
	public String toRichtextPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/richtext/"+page;
	}
	@RequestMapping(value = { "/core/dictionary/{page}" }, method = RequestMethod.GET)
	public String toDictionaryPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return CORE_PREFIX + "core/dictionary/"+page;
	}
		
	
}
