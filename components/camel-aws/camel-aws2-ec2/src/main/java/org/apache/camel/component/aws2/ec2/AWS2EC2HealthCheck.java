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

package org.apache.camel.component.aws2.ec2;

import java.util.Map;

import org.apache.camel.component.aws2.ec2.client.AWS2EC2ClientFactory;
import org.apache.camel.health.HealthCheckResultBuilder;
import org.apache.camel.impl.health.AbstractHealthCheck;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;

public class AWS2EC2HealthCheck extends AbstractHealthCheck {

    private final AWS2EC2Endpoint aws2EC2Endpoint;
    private final String clientId;

    public AWS2EC2HealthCheck(AWS2EC2Endpoint aws2EC2Endpoint, String clientId) {
        super("camel", "aws2-ec2-client-" + clientId);
        this.aws2EC2Endpoint = aws2EC2Endpoint;
        this.clientId = clientId;
    }

    @Override
    public boolean isLiveness() {
        // this health check is only readiness
        return false;
    }

    @Override
    protected void doCall(HealthCheckResultBuilder builder, Map<String, Object> options) {

        try {
            AWS2EC2Configuration configuration = aws2EC2Endpoint.getConfiguration();
            if (!Ec2Client.serviceMetadata().regions().contains(Region.of(configuration.getRegion()))) {
                builder.message("The service is not supported in this region");
                builder.down();
                return;
            }

            Ec2Client client = AWS2EC2ClientFactory.getEc2Client(configuration).getEc2Client();
            client.describeInstances();
        } catch (AwsServiceException e) {
            builder.message(e.getMessage());
            builder.error(e);
            builder.down();
        } catch (Exception e) {
            builder.error(e);
            builder.down();
            return;
        }
        builder.up();

    }
}
