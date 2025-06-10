package com.turo.wso2.customhandler.handler

import org.apache.commons.logging.LogFactory
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
        val eventProperties = event!!.eventProperties
        println("CustomUserSelfRegistrationHandler Handling event: $event, eventProperties: $eventProperties")
        log.info("CustomUserSelfRegistrationHandler Handling event: $event, eventProperties: $eventProperties")
    }

    open override fun getName(): String {
        println("CustomUserSelfRegistrationHandler getName()")
        log.info("CustomUserSelfRegistrationHandler getName()")
        return "customUserSelfRegistrationHandler"
    }
}
