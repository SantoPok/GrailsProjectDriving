package owngrailsprj

class HomeController {

    def index() {
        [traineeTotal: Trainee.count(), instructorTotal: Instructor.count()]
    }
}
