package com.crawler.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.crawler.model.SiteMap;

public class CrawlSiteTest {

	@Test
	public final void testCrawl() {
		List<String> allowedDomain = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("redhat.com");
			}
		};

		Map<String, SiteMap> visitedUrl = new HashMap<>();
		CrawlSite crawlSite = new CrawlSite(true, allowedDomain, 5 , "http://redhat.com");
		SiteMap siteMap = crawlSite.crawlUrl("http://redhat.com", null, visitedUrl);
		System.out.println(siteMap);
		System.out.println(siteMap.getText());
		assertEquals(siteMap.getText(), "http://redhat.com");

		// check for failure
		siteMap = crawlSite.crawlUrl("redhat.com", null, visitedUrl);
		assertEquals(siteMap, null);
	}

}
