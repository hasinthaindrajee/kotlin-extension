package com.organization.wso2.custom.internal

/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.com).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import com.organization.wso2.custom.handler.CustomUserSelfRegistrationHandler
import org.apache.commons.logging.LogFactory
import org.osgi.service.component.ComponentContext
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Reference
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import org.osgi.service.component.annotations.ReferenceCardinality
import org.osgi.service.component.annotations.ReferencePolicy
import org.wso2.carbon.identity.event.handler.AbstractEventHandler
import org.wso2.carbon.user.core.service.RealmService

@Component(service = [CustomUserSelfRegistrationHandlerComponent::class], immediate = true)
open class CustomUserSelfRegistrationHandlerComponent {

    @Activate
    protected fun activate(context: ComponentContext?) {
        log.info("**********************************CustomUserSelfRegistrationHandlerComponent activated*********************")
        println("***************CustomUserSelfRegistrationHandlerComponent activated***************************************")
        try {
            val bundleContext = context?.bundleContext
            val eventHandler = CustomUserSelfRegistrationHandler()
            bundleContext?.registerService(
                AbstractEventHandler::class.java.name,
                eventHandler,
                null
            )
        } catch (e: Throwable) {
            println("***************CustomUserSelfRegistrationHandlerComponent activated***************************************")
            log.error("Error while activating custom User selfRegistration handler component.", e)
        }
    }

    @Deactivate
    protected fun deactivate(context: ComponentContext?) {
        log.info("******************************CustomUserSelfRegistrationHandlerComponent deactivated***************************")
        println("***************CustomUserSelfRegistrationHandlerComponent deactivated***************************************")
        if (log.isDebugEnabled) {
            log.debug("custom self registration handler is de-activated")
        }
    }

    @Reference(
        name = "RealmService",
        service = RealmService::class,
        cardinality = ReferenceCardinality.MANDATORY,
        policy = ReferencePolicy.DYNAMIC,
        unbind = "unsetRealmService"
    )
    protected open fun setRealmService(realmService: RealmService?) {
        log.info("***((((((((((((((((((((((((((((((((((((((((((CustomUserSelfRegistrationHandlerComponent setRealmService")
        if (log.isDebugEnabled) {
            log.debug("Setting the Realm Service")
        }
    }

    public fun unsetRealmService(realmService: RealmService?) {
        log.info("CustomUserSelfRegistrationHandlerComponent unsetRealmService")
        log.debug("UnSetting the Realm Service")
    }

    companion object {
        private val log = LogFactory.getLog(CustomUserSelfRegistrationHandlerComponent::class.java)
    }
}
