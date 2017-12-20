package net.sinsengumi.sampleapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:transaction-context.xml")
public class TransactionConfig {
}
