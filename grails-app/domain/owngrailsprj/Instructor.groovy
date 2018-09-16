package owngrailsprj

class Instructor {


    String name
    Integer age
    String address
    String phoneNumber
    String jobType

    static hasMany = [trainees: Trainee]
    static constraints = {
        name blank: false
        age blank: true
        address blank: false
        phoneNumber blank: false
        jobType inList: ['Full Time', 'Part Time', 'Provisional']
    }

    String toString(){
        name
    }
}
