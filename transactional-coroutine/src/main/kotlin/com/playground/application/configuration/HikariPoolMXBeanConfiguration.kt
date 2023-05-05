package com.playground.application.configuration

import com.zaxxer.hikari.HikariPoolMXBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.management.ManagementFactory
import javax.management.JMX
import javax.management.MBeanServer
import javax.management.ObjectName

@Configuration
class HikariPoolMXBeanConfiguration {
    @Bean
    fun poolProxy(): HikariPoolMXBean {
        val mBeanServer: MBeanServer = ManagementFactory.getPlatformMBeanServer()
        val objectName = ObjectName("com.zaxxer.hikari:type=Pool (hikari)")
        return JMX.newMBeanProxy(mBeanServer, objectName, HikariPoolMXBean::class.java)
    }
}
