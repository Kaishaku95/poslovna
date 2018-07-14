'use strict';

angular.module('core.vrstaproizvoda')
	.service('VrstaProizvodaService', function($http) {
		let prefix = 'http://localhost:8080/api/vrstaproizvoda';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.add = (data) => {
			return $http.post(`${prefix}/`, data);
		};
	});