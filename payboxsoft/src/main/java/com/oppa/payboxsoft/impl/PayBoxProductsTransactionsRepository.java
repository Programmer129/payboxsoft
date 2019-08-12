package com.oppa.payboxsoft.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
interface PayBoxProductsTransactionsRepository extends CrudRepository<PayBoxTransactionsEntity, Long> {

    Stream<PayBoxTransactionsEntity> findTop10ByTransferredOrderByCommissionDesc(boolean transferred);
}
