package com.oppa.payboxsoft.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@PropertySource("classpath:application.properties")
class AsyncJobs {

    private static final Logger logger = LoggerFactory.getLogger(AsyncJobs.class);

    private final PayBoxProductsTransactionsRepository repository;

    AsyncJobs(PayBoxProductsTransactionsRepository repository) {
        this.repository = repository;
    }

    @Async
    @Scheduled(cron = "${transactions.transfer.cron}")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void sendTransactions() {
        repository.findTop10ByTransferredOrderByCommissionDesc(false)
                .peek(entity -> entity.setTransferred(true))
                .forEach(entity -> logger.info("Transferred to server: {}", entity));
    }
}
