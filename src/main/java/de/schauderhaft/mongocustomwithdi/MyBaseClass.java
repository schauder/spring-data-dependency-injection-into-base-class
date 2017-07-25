/*
 * Copyright 2017 the original author or authors.
 *
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
 */
package de.schauderhaft.mongocustomwithdi;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

/**
 * @author Jens Schauder
 */
public class MyBaseClass extends SimpleMongoRepository implements ApplicationContextAware {


	private SomeBean someBean;

	public MyBaseClass(MongoEntityInformation metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@PostConstruct
	public void after() {
		System.out.println("in post construct");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("got an application context");
	}

	public void setSomeBean(SomeBean someBean) {
		System.out.println("got some bean");
		this.someBean = someBean;
	}
}
