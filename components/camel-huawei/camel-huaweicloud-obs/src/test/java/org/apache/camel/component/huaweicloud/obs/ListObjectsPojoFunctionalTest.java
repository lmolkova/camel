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

import com.obs.services.model.ListObjectsRequest;
import org.apache.camel.BindToRegistry;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.huaweicloud.obs.models.ServiceKeys;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Ignore;
import org.junit.Test;

public class ListObjectsPojoFunctionalTest extends CamelTestSupport {

    private static final String AUTHENTICATION_KEY = "replace_this_with_authentication_key";
    private static final String SECRET_KEY = "replace_this_with_secret_key";
    private static final String REGION = "replace_this_with_region";
    private static final String BUCKET_NAME = "replace_this_with_bucket_name";

    @BindToRegistry("serviceKeys")
    ServiceKeys serviceKeys = new ServiceKeys(AUTHENTICATION_KEY, SECRET_KEY);

    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:list_objects")
                        .to("hwcloud-obs:listObjects?" +
                            "serviceKeys=#serviceKeys" +
                            "&region=" + REGION +
                            "&ignoreSslVerification=true")
                        .log("List objects successful")
                        .to("log:LOG?showAll=true")
                        .to("mock:list_objects_result");
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
        MockEndpoint mock = getMockEndpoint("mock:list_objects_result");
        mock.expectedMinimumMessageCount(1);

        // More parameters can be added to the ListObjectsRequest below. E.g. setDelimiter, setMarker, setMaxKeys, setPrefix
        ListObjectsRequest request = new ListObjectsRequest(BUCKET_NAME);
        template.sendBody("direct:list_objects", request);
        Exchange responseExchange = mock.getExchanges().get(0);

        mock.assertIsSatisfied();

        assertNotNull(responseExchange.getIn().getBody(String.class));
        assertTrue(responseExchange.getIn().getBody(String.class).length() > 0);
    }
}