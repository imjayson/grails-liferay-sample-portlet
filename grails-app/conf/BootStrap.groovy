import com.sysgears.Car

class BootStrap {

    def init = { servletContext ->
			if (!Car.count) {
				def cars = [['BMW', 'Black'], ['Mersedes', 'White'], ['Porshe', 'Yellow'], ['Aston Martin', 'White'],
						['Daewoo', 'Gray']]
				cars.each { car ->
					new Car(name: car[0], color: car[1]).save(flush:true)
				}
			}
    }
    def destroy = {
    }
}
