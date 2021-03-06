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

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * @author Jens Schauder
 */
public class MyRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends MongoRepositoryFactoryBean<T,S,ID>{

	private final SomeBean bean;
	public MyRepositoryFactoryBean(Class repositoryInterface, SomeBean bean) {
		super(repositoryInterface);
		this.bean = bean;
	}

	@Override
	protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
		return new MyMongoRepositoryFactory(operations, bean);
	}

}
