package owngrailsprj

class Trainee {
    String name
    Integer age
    String address
    String trainingType
    String phoneNumber
    String startDate
    String timeOfTheDay
    String remarks

    static belongsTo = [instructor: Instructor]


    static constraints = {
        name blank: false
        age blank: false
        address blank: false
        trainingType inList: ['One Hour', 'One Week', '15 Days', 'One Month', 'Custom']
        phoneNumber nullable: true
        startDate blank: false
        timeOfTheDay blank: false
        remarks blank: true, maxSize: 255, minSize: 10
    }
    String toString(){
        name
    }
}
