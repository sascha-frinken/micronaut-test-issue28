package net.safri

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MyServiceTest extends Specification {

    @Inject
    MyService myService

    def "test"() {
        expect:
        myService.test() == "test"
    }

    def "test2"() {
        expect:
        myService.test() == "test"
    }
}


