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
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * The Dynamic Router component routes exchanges to recipients, and the
 * recipients (and their rules) may change at runtime.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface DynamicRouterEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Dynamic Router component.
     */
    public interface DynamicRouterEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedDynamicRouterEndpointConsumerBuilder advanced() {
            return (AdvancedDynamicRouterEndpointConsumerBuilder) this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: consumer
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Dynamic Router component.
     */
    public interface AdvancedDynamicRouterEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default DynamicRouterEndpointConsumerBuilder basic() {
            return (DynamicRouterEndpointConsumerBuilder) this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder exceptionHandler(
                org.apache.camel.spi.ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder exchangePattern(
                org.apache.camel.ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointConsumerBuilder synchronous(
                String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Dynamic Router component.
     */
    public interface DynamicRouterEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedDynamicRouterEndpointProducerBuilder advanced() {
            return (AdvancedDynamicRouterEndpointProducerBuilder) this;
        }
        /**
         * Flag that determines if the producer should block while waiting for a
         * consumer.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: producer
         * 
         * @param block the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder block(boolean block) {
            doSetProperty("block", block);
            return this;
        }
        /**
         * Flag that determines if the producer should block while waiting for a
         * consumer.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: producer
         * 
         * @param block the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder block(String block) {
            doSetProperty("block", block);
            return this;
        }
        /**
         * Flag to fail if there are no consumers.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: producer
         * 
         * @param failIfNoConsumers the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder failIfNoConsumers(
                boolean failIfNoConsumers) {
            doSetProperty("failIfNoConsumers", failIfNoConsumers);
            return this;
        }
        /**
         * Flag to fail if there are no consumers.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: true
         * Group: producer
         * 
         * @param failIfNoConsumers the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder failIfNoConsumers(
                String failIfNoConsumers) {
            doSetProperty("failIfNoConsumers", failIfNoConsumers);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * The time limit, in milliseconds, if/when the producer blocks while
         * waiting for a consumer.
         * 
         * The option is a: &lt;code&gt;long&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param timeout the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder timeout(long timeout) {
            doSetProperty("timeout", timeout);
            return this;
        }
        /**
         * The time limit, in milliseconds, if/when the producer blocks while
         * waiting for a consumer.
         * 
         * The option will be converted to a &lt;code&gt;long&lt;/code&gt; type.
         * 
         * Default: 30000
         * Group: producer
         * 
         * @param timeout the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder timeout(String timeout) {
            doSetProperty("timeout", timeout);
            return this;
        }
        /**
         * Flag to log a warning if no predicates match for an exchange.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param warnDroppedMessage the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder warnDroppedMessage(
                boolean warnDroppedMessage) {
            doSetProperty("warnDroppedMessage", warnDroppedMessage);
            return this;
        }
        /**
         * Flag to log a warning if no predicates match for an exchange.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param warnDroppedMessage the value to set
         * @return the dsl builder
         */
        default DynamicRouterEndpointProducerBuilder warnDroppedMessage(
                String warnDroppedMessage) {
            doSetProperty("warnDroppedMessage", warnDroppedMessage);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Dynamic Router component.
     */
    public interface AdvancedDynamicRouterEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default DynamicRouterEndpointProducerBuilder basic() {
            return (DynamicRouterEndpointProducerBuilder) this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointProducerBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointProducerBuilder synchronous(
                String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Dynamic Router component.
     */
    public interface DynamicRouterEndpointBuilder
            extends
                DynamicRouterEndpointConsumerBuilder,
                DynamicRouterEndpointProducerBuilder {
        default AdvancedDynamicRouterEndpointBuilder advanced() {
            return (AdvancedDynamicRouterEndpointBuilder) this;
        }
    }

    /**
     * Advanced builder for endpoint for the Dynamic Router component.
     */
    public interface AdvancedDynamicRouterEndpointBuilder
            extends
                AdvancedDynamicRouterEndpointConsumerBuilder,
                AdvancedDynamicRouterEndpointProducerBuilder {
        default DynamicRouterEndpointBuilder basic() {
            return (DynamicRouterEndpointBuilder) this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Flag to ensure synchronous processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: advanced
         * 
         * @param synchronous the value to set
         * @return the dsl builder
         */
        default AdvancedDynamicRouterEndpointBuilder synchronous(
                String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    public interface DynamicRouterBuilders {
        /**
         * Dynamic Router (camel-dynamic-router)
         * The Dynamic Router component routes exchanges to recipients, and the
         * recipients (and their rules) may change at runtime.
         * 
         * Category: endpoint,java
         * Since: 3.15
         * Maven coordinates: org.apache.camel:camel-dynamic-router
         * 
         * Syntax: <code>dynamic-router:channel</code>
         * 
         * Path parameter: channel (required)
         * Channel of the Dynamic Router
         * 
         * @param path channel
         * @return the dsl builder
         */
        default DynamicRouterEndpointBuilder dynamicRouter(String path) {
            return DynamicRouterEndpointBuilderFactory.endpointBuilder("dynamic-router", path);
        }
        /**
         * Dynamic Router (camel-dynamic-router)
         * The Dynamic Router component routes exchanges to recipients, and the
         * recipients (and their rules) may change at runtime.
         * 
         * Category: endpoint,java
         * Since: 3.15
         * Maven coordinates: org.apache.camel:camel-dynamic-router
         * 
         * Syntax: <code>dynamic-router:channel</code>
         * 
         * Path parameter: channel (required)
         * Channel of the Dynamic Router
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path channel
         * @return the dsl builder
         */
        default DynamicRouterEndpointBuilder dynamicRouter(
                String componentName,
                String path) {
            return DynamicRouterEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }
    static DynamicRouterEndpointBuilder endpointBuilder(
            String componentName,
            String path) {
        class DynamicRouterEndpointBuilderImpl extends AbstractEndpointBuilder implements DynamicRouterEndpointBuilder, AdvancedDynamicRouterEndpointBuilder {
            public DynamicRouterEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new DynamicRouterEndpointBuilderImpl(path);
    }
}