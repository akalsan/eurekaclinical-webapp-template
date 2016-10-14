package org.eurekaclinical.webapp.props;

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


import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;
import org.eurekaclinical.standardapis.props.EurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class WebappProperties extends  CasEurekaClinicalProperties{

	public String getServiceUrl() {
		return getValue("eurekaclinical."+this.getProjectName()+".service.url");
	}

	public String getUrl() {
		return getValue("eurekaclinical."+this.getProjectName()+".webapp.url");
	}
	public String getProjectName() {
		return getValue("eurekaclinical.project.name");
	}
	public WebappProperties(String projectName){
		super("/etc/"+projectName);


	}
	@Override
	public String getProxyCallbackServer() {
		return getValue("eurekaclinical."+this.getProjectName()+".webapp.callbackserver");
	}
}
