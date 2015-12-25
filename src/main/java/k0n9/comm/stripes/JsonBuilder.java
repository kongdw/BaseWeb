/*
 * Copyright 2014 Rick Grashel.
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
package k0n9.comm.stripes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

import java.io.Writer;

/**
 * This class converts an object to JSON. This implementation initially
 * uses Jackson.  In the future, this will be a pluggable implementation for
 * building JSON.
 *
 * @author Rick Grashel
 */
public class JsonBuilder extends ObjectOutputBuilder<JsonBuilder> {

    /**
     * Constructs a new JsonBuilder object which is used to convert the passed
     * Java object into JSON.  The optional list of properties will be excluded
     * from serialization.
     *
     * @param root - Root object to convert to JSON
     * @param propertiesToExclude - List of property names to exclude from serialization
     * marshaling
     */
    public JsonBuilder(Object root, String... propertiesToExclude) {
        super(root);
        addPropertyExclusion(propertiesToExclude);
    }

    @Override
    public void build(Writer writer) throws Exception {
        Gson gson = new GsonBuilder().setExclusionStrategies(new JsonExclusionStrategy()).create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(gson.toJson(getRootObject()));
        JsonWriter jsonWriter = gson.newJsonWriter(writer);
        gson.toJson(jsonElement,jsonWriter);
        jsonWriter.flush();
        jsonWriter.close();
    }

}
