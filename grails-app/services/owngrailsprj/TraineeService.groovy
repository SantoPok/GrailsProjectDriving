package owngrailsprj

import grails.gorm.services.Service

@Service(Trainee)
interface TraineeService {

    Trainee get(Serializable id)

    List<Trainee> list(Map args)

    Long count()

    void delete(Serializable id)

    Trainee save(Trainee trainee)

}