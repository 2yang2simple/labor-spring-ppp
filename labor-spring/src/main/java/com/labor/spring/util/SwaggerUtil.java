package com.labor.spring.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.Placement;

import static org.asciidoctor.Asciidoctor.Factory.create;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;


public class SwaggerUtil {

	private static final String url = "http://127.0.0.1:8080/ppp/v2/api-docs";
	/**
	 * 生成AsciiDocs格式文档
	 * @throws MalformedURLException
	 */
	public static void generateAsciiDocs() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.withOutputLanguage(Language.EN)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema().build();

		Swagger2MarkupConverter.from(new URL(url))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("./docs/asciidoc/generated"));
	}
	/**
	 * 生成AsciiDocs格式文档,并汇总成一个文件
	 * @throws MalformedURLException
	 */
	public static void generateAsciiDocsToFile() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(url))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/asciidoc/generated/all"));
	}
	
	/**
	 * 生成Markdown格式文档
	 * @throws MalformedURLException
	 */
	public static void generateMarkdownDocs() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(url))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/markdown/generated"));
	}
	/**
	 * 生成Markdown格式文档,并汇总成一个文件
	 * @throws MalformedURLException
	 */
	public static void generateMarkdownDocsToFile() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(url))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/markdown/generated/all"));
	}
	/**
	 */
	public static void generateHtml() throws MalformedURLException {
//		generateAsciiDocs();
        
        Asciidoctor asciidoctor = create();
//        Attributes attributes = new Attributes();
//        attributes.setTableOfContents(Placement.LEFT);
//        attributes.setTableOfContents2(Placement.LEFT);
//        attributes.setSectNumLevels(3);
//        attributes.setSourceHighlighter("coderay");
//        attributes.map().put(attributes.TOC, true);
        
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("toc", "true");
        attributes.put("toc2", "true");
        attributes.put("toc-position", "left");
        attributes.put("toclevels", 3);
        attributes.put("sectnums", "true");
        attributes.put("sourceHighlighter", "true");
        
        Options options = new Options();
        options.setBackend("html");
        options.setToDir("./docs/asciidoc/generated/");
        options.setHeaderFooter(true);
        options.setDocType("book");
        options.setAttributes(attributes);
        final AsciiDocDirectoryWalker directoryWalker = new AsciiDocDirectoryWalker("./docs/asciidoc/generated");
        asciidoctor.convertDirectory(directoryWalker,options);
        

        
	}
	
	/**
	 * 生成Confluence格式文档
	 * @throws MalformedURLException
	 */
	public static void generateConfluenceDocs() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(url))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/confluence/generated"));
	}
	
	/**
	 * 生成Confluence格式文档,并汇总成一个文件
	 * @throws MalformedURLException
	 */
	public static void generateConfluenceDocsToFile() throws MalformedURLException {
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
                .withOutputLanguage(Language.EN)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL(url))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/confluence/generated/all"));
	}
	
	
}