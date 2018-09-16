package owngrailsprj

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TraineeServiceSpec extends Specification {

    TraineeService traineeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Trainee(...).save(flush: true, failOnError: true)
        //new Trainee(...).save(flush: true, failOnError: true)
        //Trainee trainee = new Trainee(...).save(flush: true, failOnError: true)
        //new Trainee(...).save(flush: true, failOnError: true)
        //new Trainee(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //trainee.id
    }

    void "test get"() {
        setupData()

        expect:
        traineeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Trainee> traineeList = traineeService.list(max: 2, offset: 2)

        then:
        traineeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        traineeService.count() == 5
    }

    void "test delete"() {
        Long traineeId = setupData()

        expect:
        traineeService.count() == 5

        when:
        traineeService.delete(traineeId)
        sessionFactory.currentSession.flush()

        then:
        traineeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Trainee trainee = new Trainee()
        traineeService.save(trainee)

        then:
        trainee.id != null
    }
}
