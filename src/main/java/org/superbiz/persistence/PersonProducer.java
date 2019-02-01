/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.superbiz.persistence;

import org.jnosql.diana.api.Settings;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PersonProducer {

    private static final String DOCUMENT_COLLECTION = "people";

    @Produces
    @ApplicationScoped
    public DocumentCollectionManager getDocumentCollectionManager() {
        DocumentConfiguration<?> configuration = new MongoDBDocumentConfiguration();
        Settings settings = Settings.builder().put("mongodb-server-host-1", "localhost:27017").build();
        DocumentCollectionManagerFactory managerFactory = configuration.get(settings);
        return managerFactory.get(DOCUMENT_COLLECTION);
    }

    public void close(@Disposes DocumentCollectionManager manager) {
        manager.close();
    }
}