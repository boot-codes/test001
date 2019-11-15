package com.aosica.user.resource;

import org.springframework.cloud.context.named.NamedContextFactory;

import java.util.Arrays;
import java.util.Objects;


class ResourceClientSpecification implements NamedContextFactory.Specification, com.aosica.user.resource.NamedContextFactory.Specification {

	private String name;

	private Class<?>[] configuration;

	public ResourceClientSpecification() {}

	public ResourceClientSpecification(String name, Class<?>[] configuration) {
		this.name = name;
		this.configuration = configuration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?>[] getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Class<?>[] configuration) {
		this.configuration = configuration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResourceClientSpecification that = (ResourceClientSpecification) o;
		return Objects.equals(name, that.name) &&  Arrays.equals(configuration, that.configuration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, configuration);
	}

	@Override
	public String toString() {
		return new StringBuilder("ResourceClientSpecification{")
				.append("name='").append(name).append("', ")
				.append("configuration=").append(Arrays.toString(configuration))
				.append("}").toString();
	}

}