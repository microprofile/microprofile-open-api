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

package org.eclipse.microprofile.openapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.microprofile.openapi.annotations.extensions.Extension;

/**
 * This annotation allows referencing an external resource for extended documentation.
 * <p>
 * When it is applied to a method the value of the annotation is added to the corresponding OpenAPI operation
 * definition.
 * <p>
 * As of version 4.2 of the MicroProfile OpenAPI specification, use of this annotation on a type is deprecated. While
 * implementations may continue to provide the previously-specified support for setting the documentation in the OpenAPI
 * document root's {@code externalDocs} property from this annotation, that functionality is neither required nor
 * recommended by the MicroProfile OpenAPI specification. Developers are instead encouraged to use the
 * {@link OpenAPIDefinition#externalDocs() externalDocs} property of the {@link OpenAPIDefinition @OpenAPIDefinition}
 * directly.
 *
 * @see <a href= "https://spec.openapis.org/oas/v3.1.0.html#external-documentation-object">OpenAPI Specification
 *      External Documentation Object</a>
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExternalDocumentation {

    /**
     * A short description of the target documentation.
     *
     * @return the documentation description
     **/
    String description() default "";

    /**
     * The URL for the target documentation. Value must be in the format of a URL.
     *
     * @return the documentation URL
     **/
    String url() default "";

    /**
     * List of extensions to be added to the {@link org.eclipse.microprofile.openapi.models.ExternalDocumentation
     * ExternalDocumentation} model corresponding to the containing annotation.
     *
     * @return array of extensions
     *
     * @since 3.1
     */
    Extension[] extensions() default {};
}
