/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 * Copyright 2017 SmartBear Software
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

package org.eclipse.microprofile.openapi.annotations.headers;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Describes a single header object.
 * <p>
 * Note that although the {@linkplain #org.eclipse.microprofile.openapi.models.headers.Header header} model contains a
 * {@link org.eclipse.microprofile.openapi.models.headers.Header#getContent() content} property, modeling that
 * information using annotations is not possible because the content annotation's
 * {@link org.eclipse.microprofile.openapi.annotations.media.Content#encoding() encoding} references this annotation, a
 * cycle disallowed by the Java language.
 * </p>
 *
 * @see <a href= "https://spec.openapis.org/oas/v3.1.0.html#header-object">OpenAPI Specification Header Object</a>
 **/
@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Header {
    /**
     * The name of the header. The name is only used as the key to add this header to a map.
     * <p>
     * It is a REQUIRED property unless this is only a reference to a header instance.
     * </p>
     * When the header is defined within {@link org.eclipse.microprofile.openapi.annotations.Components}, the name will
     * be used as the key to add this header to the 'headers' map for reuse.
     *
     * @return this header's name
     **/
    String name() default "";

    /**
     * Additional description data to provide on the purpose of the header
     *
     * @return the header's description
     **/
    String description() default "";

    /**
     * The schema defining the type used for the header. Ignored if the properties content or array are specified.
     *
     * @return the schema of the header
     **/
    Schema schema() default @Schema();

    /**
     * Determines whether this header is mandatory. The property may be included and its default value is false.
     *
     * @return whether or not the header is required
     **/
    boolean required() default false;

    /**
     * Specifies that a header is deprecated and should be transitioned out of usage.
     *
     * @return whether or not the header is deprecated
     **/
    boolean deprecated() default false;

    /**
     * When true, allows sending an empty value. If false, the header will be considered \&quot;null\&quot; if no value
     * is present. This may create validation errors when the header is required.
     *
     * @return whether or not the header allows empty values
     **/
    boolean allowEmptyValue() default false;

    /**
     * Reference value to a Header object.
     * <p>
     * This property provides a reference to an object defined elsewhere. This property may be used with
     * {@link #description()} but is mutually exclusive with all other properties. If properties other than
     * {@code description} are defined in addition to the {@code ref} property then the result is undefined.
     *
     * @return reference to a header
     **/
    String ref() default "";

    /**
     * List of extensions to be added to the {@link org.eclipse.microprofile.openapi.models.headers.Header Header} model
     * corresponding to the containing annotation.
     *
     * @return array of extensions
     *
     * @since 3.1
     */
    Extension[] extensions() default {};

    /**
     * Example of the header's potential value. The example SHOULD match the specified schema and encoding properties if
     * present. The {@code example} field is mutually exclusive of the {@link #examples() examples} field. Furthermore,
     * if referencing a {@link #schema() schema} that contains an example, the {@code example} value SHALL override the
     * example provided by the schema.
     * <p>
     * If the media type associated with the example allows parsing into an object, it may be converted from a string.
     * </p>
     *
     * @return an example of the header
     *
     * @since 4.2
     **/
    String example() default "";

    /**
     * Examples of the header's potential value. Each example SHOULD contain a value in the correct format as specified
     * in the parameter encoding. The {@code examples} field is mutually exclusive of the {@link #example() example}
     * field. Furthermore, if referencing a schema that contains an example, the {@code examples} value SHALL override
     * the example provided by the schema.
     *
     * @return the list of examples for this header
     *
     * @since 4.2
     **/
    ExampleObject[] examples() default {};

}
