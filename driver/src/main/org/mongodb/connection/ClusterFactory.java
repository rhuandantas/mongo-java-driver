/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.connection;

import org.mongodb.MongoCredential;
import org.mongodb.connection.impl.ChannelProviderSettings;
import org.mongodb.connection.impl.ServerSettings;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Factory for {@code Cluster} implementations.
 *
 * @since 3.0
 */
public interface ClusterFactory {

    /*
     * Creates a cluster with the given settings.  The cluster mode will be based on the mode from the settings.
     *
     * @param settings      the settings
     * @param serverFactory the server factory that the cluster implementation should use to create instances of {@code ClusterableServer}.
     * @return the cluster
     */

    /**
     * Creates a cluster with the given settings.  The cluster mode will be based on the mode from the settings.
     *
     * @param settings the cluster settings
     * @param serverSettings the server settings
     * @param channelProviderSettings the connection pool settings
     * @param streamFactory the stream factory
     * @param asyncConnectionProviderFactory the async factory
     * @param heartbeatStreamFactory the heartbeat stream factory
     * @param scheduledExecutorService the executor service used to monitor servers.
     * @param credentialList the credential list
     * @param bufferProvider the buffer provider
     * @return the cluster
     */
    Cluster create(final ClusterSettings settings,
                   final ServerSettings serverSettings,
                   final ChannelProviderSettings channelProviderSettings,
                   final StreamFactory streamFactory,
                   final AsyncConnectionProviderFactory asyncConnectionProviderFactory,
                   final StreamFactory heartbeatStreamFactory,
                   final ScheduledExecutorService scheduledExecutorService,
                   final List<MongoCredential> credentialList,
                   final BufferProvider bufferProvider);
}
