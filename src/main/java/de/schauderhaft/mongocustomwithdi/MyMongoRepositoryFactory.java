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

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;

/**
 * @author Jens Schauder
 */
public class MyMongoRepositoryFactory extends MongoRepositoryFactory {

	private final SomeBean bean;

	MyMongoRepositoryFactory(MongoOperations mongoOperations, SomeBean bean) {
		super(mongoOperations);
		this.bean = bean;
	}

	@Override
	protected Object getTargetRepository(RepositoryInformation information) {
		Object targetRepository = super.getTargetRepository(information);
		System.out.println("caught the target repository");
		if (targetRepository instanceof MyBaseClass) {
			((MyBaseClass) targetRepository).setSomeBean(bean);
		}
		return targetRepository;
	}

}
