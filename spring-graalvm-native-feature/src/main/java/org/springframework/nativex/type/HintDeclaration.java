/*
 * Copyright 2020 Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.nativex.type;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.nativex.domain.init.InitializationDescriptor;

/**
 * 
 * @author Andy Clement
 */
public class HintDeclaration {

	private String triggerTypename;

	private Map<String, AccessDescriptor> specificTypes = new LinkedHashMap<>();

	private List<ProxyDescriptor> proxyDescriptor = new ArrayList<>();

	private List<ResourcesDescriptor> resourceDescriptors = new ArrayList<>();

	private List<InitializationDescriptor> initializationDescriptors = new ArrayList<>();

	private boolean applyToFunctional = true; // True as per default for this attribute in NativeImageHint

	public boolean follow = false;

	public boolean skipIfTypesMissing = false;
	
	public List<String> extractAttributeNames;
	
	public HintDeclaration() {
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("HintDeclaration");
		if (triggerTypename != null) {
			sb.append(" for ").append(triggerTypename);
		}
		sb.append(":");
		sb.append(specificTypes);
		if (resourceDescriptors!=null && !resourceDescriptors.isEmpty()) {
			sb.append(":resDes=").append(resourceDescriptors);
		}
		if (initializationDescriptors!=null && !initializationDescriptors.isEmpty()) {
			sb.append(":initDes=").append(initializationDescriptors);
		}
		if (proxyDescriptor!=null && !proxyDescriptor.isEmpty()) {
			sb.append(":proxyDes=").append(proxyDescriptor);
		}
		return sb.toString();
	}

	public void setTriggerTypename(String triggerTypename) {
		this.triggerTypename = triggerTypename;
	}

	public String getTriggerTypename() {
		return triggerTypename;
	}
	
	public Map<String, AccessDescriptor> getDependantTypes() {
		return specificTypes;
	}

	public void addDependantType(String className, AccessDescriptor accessDescriptor) {
		specificTypes.put(className, accessDescriptor);
	}

	public void setAbortIfTypesMissing(Boolean b) {
		skipIfTypesMissing = b;
	}

	public boolean isAbortIfTypesMissing() {
		return skipIfTypesMissing;
	}

	public void setFollow(Boolean b) {
		follow = b;
	}

	public void addProxyDescriptor(ProxyDescriptor pd) {
		proxyDescriptor.add(pd);
	}
	
	public List<ProxyDescriptor> getProxyDescriptors() {
		return proxyDescriptor;
	}
	
	public void addResourcesDescriptor(ResourcesDescriptor rd) {
		resourceDescriptors.add(rd);
	}

	public void addInitializationDescriptor(InitializationDescriptor id) {
		initializationDescriptors.add(id);
	}
	
	public List<ResourcesDescriptor> getResourcesDescriptors() {
		return resourceDescriptors;
	}
	
	public void setApplyToFunctional(boolean b) {
		applyToFunctional = b;
	}

	public boolean applyToFunctional() {
		return applyToFunctional;
	}

	public List<InitializationDescriptor> getInitializationDescriptors() {
		return initializationDescriptors;
	}

	public void setAttributesToExtract(List<String> extractAttributeNames) {
		this.extractAttributeNames = extractAttributeNames;
	}
	
	public List<String> getExtractAttributeNames() {
		return extractAttributeNames;
	}

}