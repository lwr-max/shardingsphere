/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.database.mysql;

import org.apache.shardingsphere.infra.database.core.system.DialectSystemDatabase;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * System database of MySQL.
 */
public final class MySQLSystemDatabase implements DialectSystemDatabase {
    
    private static final Map<String, Collection<String>> SYSTEM_DATABASE_SCHEMA_MAP = new HashMap<>();
    
    static {
        SYSTEM_DATABASE_SCHEMA_MAP.put("information_schema", Collections.singleton("information_schema"));
        SYSTEM_DATABASE_SCHEMA_MAP.put("performance_schema", Collections.singleton("performance_schema"));
        SYSTEM_DATABASE_SCHEMA_MAP.put("mysql", Collections.singleton("mysql"));
        SYSTEM_DATABASE_SCHEMA_MAP.put("sys", Collections.singleton("sys"));
        SYSTEM_DATABASE_SCHEMA_MAP.put("shardingsphere", Collections.singleton("shardingsphere"));
    }
    
    @Override
    public Map<String, Collection<String>> getSystemDatabaseSchemaMap() {
        return SYSTEM_DATABASE_SCHEMA_MAP;
    }
    
    @Override
    public Collection<String> getSystemSchemas() {
        return SYSTEM_DATABASE_SCHEMA_MAP.keySet();
    }
    
    @Override
    public String getDatabaseType() {
        return "MySQL";
    }
}
