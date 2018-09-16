package owngrailsprj

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InstructorController {

    InstructorService instructorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond instructorService.list(params), model:[instructorCount: instructorService.count()]
    }

    def show(Long id) {
        respond instructorService.get(id)
    }

    def create() {
        respond new Instructor(params)
    }

    def save(Instructor instructor) {
        if (instructor == null) {
            notFound()
            return
        }

        try {
            instructorService.save(instructor)
        } catch (ValidationException e) {
            respond instructor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'instructor.label', default: 'Instructor'), instructor.id])
                redirect instructor
            }
            '*' { respond instructor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond instructorService.get(id)
    }

    def update(Instructor instructor) {
        if (instructor == null) {
            notFound()
            return
        }

        try {
            instructorService.save(instructor)
        } catch (ValidationException e) {
            respond instructor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'instructor.label', default: 'Instructor'), instructor.id])
                redirect instructor
            }
            '*'{ respond instructor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        instructorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'instructor.label', default: 'Instructor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'instructor.label', default: 'Instructor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
