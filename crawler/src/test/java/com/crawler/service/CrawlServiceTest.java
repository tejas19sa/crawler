package com.crawler.service;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.crawler.model.SiteMap;

@RunWith(SpringRunner.class)
public class CrawlServiceTest {

	@InjectMocks
	private CrawlService crawlService;

	@Test
	public final void testCrawl() {
		List<String> allowedDomain = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("redhat.com");
			}
		};

		SiteMap siteMap = crawlService.crawlSite("http://redhat.com", allowedDomain, 1,"http://redhat.com");
		assertEquals(siteMap.getChildren(), null);

		siteMap = crawlService.crawlSite("http://redhat.com", allowedDomain, 5,"http://redhat.com");
		assertEquals(siteMap.getChildren().size() > 0, true);
	}
}
