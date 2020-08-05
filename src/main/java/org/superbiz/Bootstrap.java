/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.superbiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

public class Bootstrap {

    @Inject
    private PersonRepository repository;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object o) {

        try (BufferedReader reader = new BufferedReader(
                                     new InputStreamReader(getClass().getResourceAsStream("/person.json")))) {

            List<Person> personList = JsonbBuilder.create().fromJson(reader, new ArrayList<Person>() {}
                                                           .getClass()
                                                           .getGenericSuperclass());

            personList.forEach(person -> {
                Person p = new Person();
                p.setAge(person.getAge());
                p.setName(person.getName());
                p.setAddress(person.getAddress());
                p.setDescription(person.getDescription());
                p.setServer(person.getServer());

                repository.save(p);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
