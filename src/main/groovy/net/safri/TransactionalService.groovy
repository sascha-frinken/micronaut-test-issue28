package net.safri

import io.micronaut.spring.tx.annotation.Transactional

import javax.inject.Singleton

@Singleton
@Transactional
class TransactionalService {

    String test() {
        return "test"
    }
}
