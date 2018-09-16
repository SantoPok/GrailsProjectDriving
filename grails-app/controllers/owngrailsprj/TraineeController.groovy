package owngrailsprj

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TraineeController {

    TraineeService traineeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond traineeService.list(params), model:[traineeCount: traineeService.count()]
    }

    def show(Long id) {
        respond traineeService.get(id)
    }

    def create() {
        respond new Trainee(params)
    }

    def save(Trainee trainee) {
        if (trainee == null) {
            notFound()
            return
        }

        try {
            traineeService.save(trainee)
        } catch (ValidationException e) {
            respond trainee.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trainee.label', default: 'Trainee'), trainee.id])
                redirect trainee
            }
            '*' { respond trainee, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond traineeService.get(id)
    }

    def update(Trainee trainee) {
        if (trainee == null) {
            notFound()
            return
        }

        try {
            traineeService.save(trainee)
        } catch (ValidationException e) {
            respond trainee.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trainee.label', default: 'Trainee'), trainee.id])
                redirect trainee
            }
            '*'{ respond trainee, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        traineeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'trainee.label', default: 'Trainee'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainee.label', default: 'Trainee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
