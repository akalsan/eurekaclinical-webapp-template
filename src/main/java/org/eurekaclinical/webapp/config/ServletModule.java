package org.eurekaclinical.webapp.config;

/*-
 * #%L
 * eurekaclinical-webapp-template
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.eurekaclinical.common.config.AbstractServletModule;
import org.eurekaclinical.common.servlet.DestroySessionServlet;
import org.eurekaclinical.common.servlet.PostMessageLoginServlet;
import org.eurekaclinical.common.servlet.ProxyServlet;
import org.eurekaclinical.webapp.props.WebappProperties;
import org.eurekaclinical.webapp.servlet.ViewSampleServlet;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by akalsan on 9/15/16.
 */


public class ServletModule extends AbstractServletModule {
	private static final String CONTAINER_PATH = "/site/*";

	private static final String CONTAINER_PROTECTED_PATH = "/protected/*";

	private final WebappProperties properties;

	public ServletModule(WebappProperties inProperties) {
		super(inProperties, CONTAINER_PATH, CONTAINER_PROTECTED_PATH);
		this.properties = inProperties;
	}

	@Override
	protected void setupServlets() {
		serve("/protected/view").with(ViewSampleServlet.class);
		serve("/protected/get-session").with(PostMessageLoginServlet.class);
		serve("/proxy-resource/*").with(ProxyServlet.class);
		serve("/destroy-session").with(DestroySessionServlet.class);
	}

	@Override
	protected Map<String, String> getCasValidationFilterInitParams() {
		Map<String, String> params = new HashMap<>();
		params.put("casServerUrlPrefix", this.properties.getCasUrl());
		params.put("serverName", this.properties.getProxyCallbackServer());
		params.put("proxyCallbackUrl", getCasProxyCallbackUrl());
		params.put("proxyReceptorUrl", getCasProxyCallbackPath());
		return params;
	}
}