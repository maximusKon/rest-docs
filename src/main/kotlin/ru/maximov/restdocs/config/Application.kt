package ru.maximov.restdocs.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import ru.maximov.restdocs.controllers.CarController

@SpringBootApplication
@ComponentScan(basePackageClasses = arrayOf(CarController::class))
open class Application
