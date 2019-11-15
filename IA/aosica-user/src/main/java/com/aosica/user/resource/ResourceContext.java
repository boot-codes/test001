package com.aosica.user.resource;




public class ResourceContext extends NamedContextFactory<ResourceClientSpecification> {

	public ResourceContext() {
		super(ResourceClientSpecification.class, "feign", "feign.client.name");
	}

}