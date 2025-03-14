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

package org.eclipse.microprofile.openapi.models;

import java.util.List;
import java.util.Map;

import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.tags.Tag;

/**
 * OpenAPI
 * <p>
 * This is the root document object of the OpenAPI document. It contains required and optional fields.
 *
 * @see <a href= "https://spec.openapis.org/oas/v3.1.0.html#openapi-object">OpenAPI Specification OpenAPI Object</a>
 */
public interface OpenAPI extends Constructible, Extensible<OpenAPI> {

    /**
     * Returns the openapi property from an OpenAPI instance.
     *
     * @return the semantic version number of the OpenAPI Specification version that the OpenAPI document uses
     **/
    String getOpenapi();

    /**
     * Sets this OpenAPI instance's openapi property to the given string.
     *
     * @param openapi
     *            the semantic version number of the OpenAPI Specification version that the OpenAPI document uses
     */
    void setOpenapi(String openapi);

    /**
     * Sets this OpenAPI instance's openapi property to the given string.
     *
     * @param openapi
     *            the semantic version number of the OpenAPI Specification version that the OpenAPI document uses
     * @return the current OpenAPI object
     */
    default OpenAPI openapi(String openapi) {
        setOpenapi(openapi);
        return this;
    }

    /**
     * Returns the info property from an OpenAPI instance.
     *
     * @return metadata about the API
     **/
    Info getInfo();

    /**
     * Sets this OpenAPI instance's info property to the given object.
     *
     * @param info
     *            metadata about the API
     */
    void setInfo(Info info);

    /**
     * Sets this OpenAPI instance's info property to the given object.
     *
     * @param info
     *            metadata about the API
     * @return the current OpenAPI object
     */
    default OpenAPI info(Info info) {
        setInfo(info);
        return this;
    }

    /**
     * Returns the externalDocs property from an OpenAPI instance.
     *
     * @return additional external documentation
     **/
    ExternalDocumentation getExternalDocs();

    /**
     * Sets this OpenAPI instance's externalDocs property to the given object.
     *
     * @param externalDocs
     *            additional external documentation.
     */
    void setExternalDocs(ExternalDocumentation externalDocs);

    /**
     * Sets this OpenAPI instance's externalDocs property to the given object.
     *
     * @param externalDocs
     *            additional external documentation
     * @return the current OpenAPI object
     */
    default OpenAPI externalDocs(ExternalDocumentation externalDocs) {
        setExternalDocs(externalDocs);
        return this;
    }

    /**
     * Returns the Servers defined in the API
     *
     * @return a copy List (potentially immutable) of Server objects which provide connectivity information to target
     *         servers
     **/
    List<Server> getServers();

    /**
     * Sets this OpenAPI instance's servers property to the given servers.
     *
     * @param servers
     *            Server objects which provide connectivity information to target servers
     */
    void setServers(List<Server> servers);

    /**
     * Sets this OpenAPI instance's servers property to the given servers.
     *
     * @param servers
     *            Server objects which provide connectivity information to target servers
     * @return the current OpenAPI object
     */
    default OpenAPI servers(List<Server> servers) {
        setServers(servers);
        return this;
    }

    /**
     * Adds the given server to this OpenAPI instance's list of servers.
     *
     * @param server
     *            Server object which provides connectivity information to a target server
     * @return the current OpenAPI object
     */
    OpenAPI addServer(Server server);

    /**
     * Removes the given server to this OpenAPI instance's list of servers.
     *
     * @param server
     *            Server object which provides connectivity information to a target server
     */
    void removeServer(Server server);

    /**
     * Returns the security property from an OpenAPI instance.
     *
     * @return a copy List (potentially immutable) containing the security mechanisms that can be used across the API
     **/
    List<SecurityRequirement> getSecurity();

    /**
     * Sets this OpenAPI instance's security property to the given list.
     *
     * @param security
     *            which security mechanisms can be used across the API
     */
    void setSecurity(List<SecurityRequirement> security);

    /**
     * Sets this OpenAPI instance's security property to the given list.
     *
     * @param security
     *            which security mechanisms can be used across the API
     * @return the current OpenAPI object
     */
    default OpenAPI security(List<SecurityRequirement> security) {
        setSecurity(security);
        return this;
    }

    /**
     * Adds the given security requirement to this OpenAPI instance's list of security requirements.
     *
     * @param securityRequirement
     *            security mechanism which can be used across the API
     * @return the current OpenAPI object
     */
    OpenAPI addSecurityRequirement(SecurityRequirement securityRequirement);

    /**
     * Removes the given security requirement to this OpenAPI instance's list of security requirements.
     *
     * @param securityRequirement
     *            security mechanism which can be used across the API
     */
    void removeSecurityRequirement(SecurityRequirement securityRequirement);

    /**
     * Returns the tags property from an OpenAPI instance.
     *
     * @return a copy List (potentially immutable) of tags defined in this the specification
     **/

    List<Tag> getTags();

    /**
     * Sets this OpenAPI instance's tags property to the given Tags.
     *
     * @param tags
     *            tags used by the specification with additional metadata
     */
    void setTags(List<Tag> tags);

    /**
     * Sets this OpenAPI instance's tags property to the given tags.
     *
     * @param tags
     *            tags used by the specification with additional metadata
     * @return the current OpenAPI object
     */
    default OpenAPI tags(List<Tag> tags) {
        setTags(tags);
        return this;
    }

    /**
     * Adds the given tag to this OpenAPI instance's list of tags.
     *
     * @param tag
     *            a tag used by the specification with additional metadata
     * @return the current OpenAPI object
     */
    OpenAPI addTag(Tag tag);

    /**
     * Removes the given tag to this OpenAPI instance's list of tags.
     *
     * @param tag
     *            a tag used by the specification with additional metadata
     */
    void removeTag(Tag tag);

    /**
     * Returns the paths property from an OpenAPI instance.
     *
     * @return the available paths and operations for the API
     **/
    Paths getPaths();

    /**
     * Sets this OpenAPI instance's paths property to the given paths.
     *
     * @param paths
     *            the available paths and operations for the API
     */
    void setPaths(Paths paths);

    /**
     * Sets this OpenAPI instance's paths property to the given paths.
     *
     * @param paths
     *            the available paths and operations for the API
     * @return the current OpenAPI object
     */
    default OpenAPI paths(Paths paths) {
        setPaths(paths);
        return this;
    }

    /**
     * Returns the webhooks property of this OpenAPI instance.
     *
     * @return a copy Map (potentially immutable) of named webhook definitions
     * @since 4.0
     */
    Map<String, PathItem> getWebhooks();

    /**
     * Sets the webhooks property of this OpenAPI instance.
     *
     * @param webhooks
     *            a map of named webhook definitions
     * @since 4.0
     */
    void setWebhooks(Map<String, PathItem> webhooks);

    /**
     * Sets the webhooks property of this OpenAPI instance.
     *
     * @param webhooks
     *            a map of named webhook definitions
     * @return the current Schema instance
     * @since 4.0
     */
    default OpenAPI webhooks(Map<String, PathItem> webhooks) {
        setWebhooks(webhooks);
        return this;
    }

    /**
     * Adds a webhook definition.
     *
     * @param name
     *            unique name of the webhook to add
     * @param webhook
     *            webhook definition to add
     * @return the current Schema instance
     * @since 4.0
     */
    OpenAPI addWebhook(String name, PathItem webhook);

    /**
     * Removes a webhook definition.
     *
     * @param name
     *            unique name of the webhook to remove
     * @since 4.0
     */
    void removeWebhook(String name);

    /**
     * Returns the default JSON Schema dialect for schemas in this document.
     *
     * @return the identifier of the default schema dialect for schemas in this document
     * @since 4.1
     */
    String getJsonSchemaDialect();

    /**
     * Sets the default JSON Schema dialect for schemas in this document.
     *
     * @param jsonSchemaDialect
     *            the identifier of the default schema dialect for schemas in this document
     * @since 4.1
     */
    void setJsonSchemaDialect(String jsonSchemaDialect);

    /**
     * Sets the default JSON Schema dialect for schemas in this document.
     *
     * @param jsonSchemaDialect
     *            the identifier of the default schema dialect for schemas in this document
     * @return the current OpenAPI object
     * @since 4.1
     */
    default OpenAPI jsonSchemaDialect(String jsonSchemaDialect) {
        setJsonSchemaDialect(jsonSchemaDialect);
        return this;
    }

    /**
     * Returns the components property from an OpenAPI instance.
     *
     * @return schemas used in the specification
     **/
    Components getComponents();

    /**
     * Sets this OpenAPI instance's components property to the given components.
     *
     * @param components
     *            a set of reusable objects used in the API specification
     */
    void setComponents(Components components);

    /**
     * Sets this OpenAPI instance's components property to the given components.
     *
     * @param components
     *            a set of reusable objects used in the API specification
     * @return the current OpenAPI object
     */
    default OpenAPI components(Components components) {
        setComponents(components);
        return this;
    }

}