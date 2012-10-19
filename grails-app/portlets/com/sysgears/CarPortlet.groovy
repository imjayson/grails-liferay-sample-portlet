package com.sysgears

import grails.converters.JSON
import org.apache.commons.logging.LogFactory

import javax.portlet.PortletMode

class CarPortlet {

	def carService

	private static final log = LogFactory.getLog(this)


	def title = 'Car Portlet'
	def description = '''
This is my sample grails liferay portlet.
'''
	def displayName = 'Car Portlet'
	def supports = ['text/html': ['view', 'edit', 'help']]
	def liferay_display_category = "Cars"

	def liferay_portlet_header_portlet_css = [
			'/css/car.css'
	]

	//uncomment to declare events support
	//def events = [publish: ["event-1"], process: ["event-2"]]

	//uncomment to declare public render parameter support
	//def public_render_params = ["prp-1","prp-2"]

	// Used for liferay
	// @see http://www.liferay.com/documentation/liferay-portal/6.0/development/-/ai/anatomy-of-a-portlets
	// def liferay_display_category = "category.sample"


	def actionView = {
		//TODO Define action phase for 'view' portlets mode
		log.info('In actionView. ' + params)
		def car = Car.get(params.id)
		if (car) {
			car.delete()
		}
//		portletResponse.setRenderParameter("prp-1", "value-1");
	}

	def eventView = {
		//TODO Define event phase for 'view' portlets mode.
		def eventValue = portletRequest.event.value
	}

	def renderView = {
		//TODO Define render phase for 'view' portlets mode.
		//Return the map of the variables bound to the view,
		//in this case view.gsp if it exists or render.gsp if not
		log.info('In renderView. ' + params)
		def cars = Car.list()
		[cars: cars]
	}

	def resourceView = {
		//TODO define resource phase for 'view' portlets mode.
		//Render HTML as response
		render {
			html {
				head()
				body {
					"Render me!!"
				}
			}
		}
	}

	def actionEdit = {
		//TODO Define action phase for 'edit' portlets mode

		portletResponse.setEvent("event-1", "event-1")
		portletResponse.setPortletMode(PortletMode.VIEW)
	}

	def addCar = {
		log.info('In add action. ' + params)
		if (params.name && params.color) {
			carService.saveCar(params.name, params.color)
		}
		portletResponse.setRenderParameter("action", "added");
	}

	def renderAdded = {
		log.info('Rendering added car view.')
	}


	def renderHelp = {
		//TODO Define render phase for 'help' portlets mode
		//Return the map of the variables bound to the view,
		//in this case help.gsp if it exists or render.gsp if not
		['mykey': 'myvalue']
	}

	def doResource = {
		//TODO Define handling for default resource URL handling method, independent of porlet mode
		//Return the map of the variables bound to the view,
		//in this case resource.gsp
		['mykey': 'myvalue']
	}

	//invoked by setting 'action' param in resourceURL (as an example) to 'rentCar'
	def rentCar = {
		//render JSON

		render ([success: "You have rent a car!"] as JSON)
		/*render(contentType: "text/json") {
			example(mykey: "myvalue")
		}*/
	}

	//invoked by setting 'action' param in eventURL (as an example) to 'handleThisEvent'
	def handleThisEvent = {
		//render thisEvent.gsp
		render(view: "thisEvent")
	}
}
