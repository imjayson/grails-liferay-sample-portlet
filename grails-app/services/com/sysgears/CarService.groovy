package com.sysgears

class CarService {

	def saveCar(String name, String color) {
		new Car(name: name, color: color).save(flush: true)
	}
}
