package ru.maximov.restdocs.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.maximov.restdocs.models.Car

@RestController
class CarController {

    @RequestMapping("/getCar/{id}")
    fun getCar(@PathVariable("id") id : String):ResponseEntity<Car> {
        return ResponseEntity(Car(id, "RENO"), HttpStatus.OK)
    }
}