package com.labor.spring.system.ppp;

import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labor.spring.util.SwaggerUtil;

import springfox.documentation.annotations.ApiIgnore;
@RestController
@RequestMapping("/rest/api/export")
@ApiIgnore
public class ApiExportRestController {

	
	@RequestMapping("/ascii")
	public String exportAscii() throws MalformedURLException{
		SwaggerUtil.generateAsciiDocs();
		return "success";
	}
	
	@RequestMapping("/asciiToFile")
	public String asciiToFile() throws MalformedURLException{
		SwaggerUtil.generateAsciiDocsToFile();
		return "success";
	}
	
	@RequestMapping("/markdown")
	public String exportMarkdown() throws MalformedURLException{
		SwaggerUtil.generateMarkdownDocs();
		return "success";
	}
	
	@RequestMapping("/markdownToFile")
	public String exportMarkdownToFile() throws MalformedURLException{
		SwaggerUtil.generateMarkdownDocsToFile();
		return "success";
	}
	
	@RequestMapping("/confluence")
	public String confluence() throws MalformedURLException{
		SwaggerUtil.generateConfluenceDocs();
		return "success";
	}
	
	@RequestMapping("/confluenceToFile")
	public String confluenceToFile() throws MalformedURLException{
		SwaggerUtil.generateConfluenceDocsToFile();
		return "success";
	}
	
	
	@RequestMapping("/html")
	public String exportHtml() throws MalformedURLException{
		SwaggerUtil.generateHtml();
		return "success";
	}
	
}
