/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.huaweicloud.obs;

import org.apache.camel.BindToRegistry;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.huaweicloud.obs.constants.OBSHeaders;
import org.apache.camel.component.huaweicloud.obs.models.ServiceKeys;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test download objects with specific filename given
 */
public class DownloadSingleFunctionalTest extends CamelTestSupport {
    private static final String AUTHENTICATION_KEY = "replace_this_with_authentication_key";
    private static final String SECRET_KEY = "replace_this_with_secret_key";
    private static final String REGION = "replace_this_with_region";
    private static final String BUCKET_NAME = "replace_this_with_bucket_name";
    private static final String FILENAME = "replace_this_with_filename";

    @BindToRegistry("serviceKeys")
    ServiceKeys serviceKeys = new ServiceKeys(AUTHENTICATION_KEY, SECRET_KEY);

    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("hwcloud-obs:?" +
                     "serviceKeys=#serviceKeys" +
                     "&region=" + REGION +
                     "&bucketName=" + BUCKET_NAME +
                     "&fileName=" + FILENAME +
                     "&ignoreSslVerification=true" +
                     "&deleteAfterRead=false" +
                     "&moveAfterRead=false")
                             .log("Download objects successful")
                             .to("log:LOG?showAll=true")
                             .to("mock:download_objects_result");
            }
        };
    }

    /**
     * The following test cases should be manually enabled to perform test against the actual HuaweiCloud OBS server
     * with real user credentials. To perform this test, manually comment out the @Ignore annotation and enter relevant
     * service parameters in the placeholders above (static variables of this test class)
     *
     * @throws Exception
     */
    @Ignore("Manually enable this once you configure the parameters in the placeholders above")
    @Test
    public void testListBuckets() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:download_objects_result");
        mock.expectedMinimumMessageCount(1);
        mock.assertIsSatisfied();
        Exchange responseExchange = mock.getExchanges().get(0);

        assertEquals(1, mock.getExchanges().size());
        assertEquals(FILENAME, responseExchange.getIn().getHeader(OBSHeaders.OBJECT_KEY, String.class));
        if (responseExchange.getIn().getHeader(Exchange.CONTENT_LENGTH, Integer.class) > 0) {
            assertNotNull(responseExchange.getIn().getBody(String.class));
            assertTrue(responseExchange.getIn().getBody(String.class).length() > 0);
        }
    }
}