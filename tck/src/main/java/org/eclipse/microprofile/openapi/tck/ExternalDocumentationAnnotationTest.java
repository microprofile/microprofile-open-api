package org.eclipse.microprofile.openapi.tck;

import io.restassured.response.ValidatableResponse;
import org.eclipse.microprofile.openapi.apps.scanconfig.ScanConfigApplication;
import org.eclipse.microprofile.openapi.apps.scanconfig.a.AResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Verify usage of the {@code @ExternalDocumentation} annotation.
 */
public class ExternalDocumentationAnnotationTest extends AppTestBase {

    @Deployment(name = "externalDocs-test", testable = false)
    public static WebArchive deployment() {
        return ShrinkWrap.create(WebArchive.class, "externalDocs-test.war")
                .addClasses(ScanConfigApplication.class, AResource.class);
    }

    /**
     * Check that the {@code externalDocs} element is present in the generated OpenAPI document when the
     * {@code @ExternalDocumentation} annotation is used on a resource method definition.
     * @param type Type of the OpenAPI output format
     */
    @Test(dataProvider = "formatProvider")
    public void testExternalDocumentationAnnotationOnMethod(String type) {
        ValidatableResponse vr = callEndpoint(type);

        vr.body("paths.'/a'.get.externalDocs.description", equalTo("Find more information about this application resource"));
        vr.body("paths.'/a'.get.externalDocs.url", equalTo(
                "https://github.com/microprofile/microprofile-open-api/blob/main/tck/src/main/java/org/eclipse/microprofile/openapi/apps/scanconfig/a/AResource.java"));
    }
}
