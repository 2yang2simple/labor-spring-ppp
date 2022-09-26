package com.labor.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.labor.spring.system.auth.AbstractAuthHtmlController;

@Controller
public class PPPHtmlController extends AbstractAuthHtmlController{

	private static String CORE_PREFIX = "00.";
	private static String PROD_PREFIX = "01.ppp/01.";
	private static String PROJ_PREFIX = "01.ppp/02.";
	private static String PROF_PREFIX = "01.ppp/03.";
	

	/***********************
	 * proof
	 */
	@RequestMapping(value = { "/prof/document/{page}" }, method = RequestMethod.GET)
	public String toProofDocumentPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROF_PREFIX + "prof/document/"+page;
	}
	//url rewrite;
	@RequestMapping(value = { "/prof/document/{uuid}.html" }, method = RequestMethod.GET)
	public String toProofDocumentViewPage(ModelMap map,@PathVariable(value="uuid") String uuid) {	
		map.addAttribute("uuid",uuid);
		return PROF_PREFIX + "prof/document/viewer";
	}
	@RequestMapping(value = { "/prof/gallery/{page}" }, method = RequestMethod.GET)
	public String toProofGalleryPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROF_PREFIX + "prof/gallery/"+page;
	}
	@RequestMapping(value = { "/prof/tag/{page}" }, method = RequestMethod.GET)
	public String toProofTagPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROF_PREFIX + "prof/tag/"+page;
	}
	
	/***********************
	 * product
	 */
	@RequestMapping(value = { "/prod/{page}" }, method = RequestMethod.GET)
	public String toProductPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROD_PREFIX + "prod/"+page;
	}
	
	/***********************
	 * project
	 */
	@RequestMapping(value = { "/proj/{page}" }, method = RequestMethod.GET)
	public String toProjectPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROJ_PREFIX + "proj/"+page;
	}
	
}
