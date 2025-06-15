package com.organization.wso2.custom.handler

import org.apache.commons.logging.LogFactory
import org.wso2.carbon.identity.core.bean.context.MessageContext
import org.wso2.carbon.identity.event.event.Event
import org.wso2.carbon.identity.event.handler.AbstractEventHandler

open class CustomUserSelfRegistrationHandler : AbstractEventHandler() {

    companion object {
        private val log = LogFactory.getLog(CustomUserSelfRegistrationHandler::class.java)
        const val CUSTOM_ROLE = "Internal/CustomRole"

        init {
            println("CustomUserSelfRegistrationHandler initialized=================================================")
            log.info("CustomUserSelfRegistrationHandler initialized==========================================")
        }
    }

    open override fun handleEvent(event: Event?) {
        log.info("=======================================Event Recived to Kotlin Custom Handler =============")
        val eventProperties = event!!.eventProperties
        println("CustomUserSelfRegistrationHandler Handling event: $event, eventProperties: $eventProperties")
        log.info("CustomUserSelfRegistrationHandler Handling event: $event, eventProperties: $eventProperties")
    }

    open override fun getName(): String {
        println("CustomUserSelfRegistrationHandler getName()")
        log.info("CustomUserSelfRegistrationHandler getName()")
        return "customUserRegistration"
    }

    open override fun getPriority(messageContext: MessageContext<*, *>?): Int {
        return 250;
    }
}
