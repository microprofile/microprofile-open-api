/**
 * Copyright (c) 2026 Contributors to the Eclipse Foundation
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.openapi.tck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.media.Schema.SchemaType;
import org.testng.annotations.Test;

/**
 * This test covers the Extensible aspect of the Schema model, checking that properties are recognized correctly as
 * extensions by an implementation and handled according to the Schema documentation.
 */
public class SchemaExtensionPropertyTest {

    private static final String EXTNAME = "my-extension";

    @Test
    public void testExtensionSetForUnknownProperty() {
        Schema schema = OASFactory.createSchema();
        Object theExtension = new Object();
        schema.set(EXTNAME, theExtension);

        assertThat(schema.get(EXTNAME), is(sameInstance(theExtension)));
        assertThat(schema.getExtension(EXTNAME), is(sameInstance(theExtension)));
    }

    @Test
    public void testExtensionSetAllForUnknownProperty() {
        Schema schema = OASFactory.createSchema();
        Object theExtension = new Object();
        schema.setAll(Map.of(
                "type", List.of(SchemaType.STRING),
                EXTNAME, theExtension));

        assertThat(schema.getType(), is(List.of(SchemaType.STRING)));
        assertThat(schema.get(EXTNAME), is(sameInstance(theExtension)));
        assertThat(schema.getExtension(EXTNAME), is(sameInstance(theExtension)));
    }

    @Test
    public void testExtensionAvailableFromGet() {
        Schema schema = OASFactory.createSchema();
        Object theExtension = new Object();
        schema.addExtension(EXTNAME, theExtension);

        assertThat(schema.get(EXTNAME), is(sameInstance(theExtension)));
        assertThat(schema.getExtension(EXTNAME), is(sameInstance(theExtension)));
    }

    @Test
    public void testExtensionSetWithNonnullDialect() {
        Schema schema = OASFactory.createSchema();
        schema.setSchemaDialect("https://spec.openapis.org/oas/3.1/dialect/base");
        Object theExtension = new Object();
        schema.set(EXTNAME, theExtension);
        assertThat(schema.getExtension(EXTNAME), is(sameInstance(theExtension)));
    }

    @Test
    public void testSetAllClearsExtensions() {
        Schema schema = OASFactory.createSchema();
        Object theExtension = new Object();
        schema.set(EXTNAME, theExtension);
        assertThat(schema.getExtension(EXTNAME), is(sameInstance(theExtension)));
        schema.setAll(Collections.emptyMap());
        assertThat(schema.hasExtension(EXTNAME), is(false));
    }

    @Test
    public void testNullExtensionNotAdded() {
        Schema schema = OASFactory.createSchema();

        try {
            schema.addExtension(EXTNAME, null);
        } catch (Exception e) {
            // May or may not be thrown
        }

        assertThat(schema.hasExtension(EXTNAME), is(false));
    }
}
