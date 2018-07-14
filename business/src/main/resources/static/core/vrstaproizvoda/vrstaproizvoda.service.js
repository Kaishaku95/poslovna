'use strict';

angular.module('core.vrstaproizvoda')
	.service('VrstaProizvodaService', function($http) {
		let prefix = 'http://localhost:8080/api/vrstaproizvoda';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.getOne = (id) => {
			return $http.get(`${prefix}/${id}`);
		};
		this.add = (data) => {
			return $http.post(`${prefix}/`, data);
		};
	});