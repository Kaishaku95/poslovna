'use strict';

angular.module('core.proizvod')
	.service('ProizvodService', function($http) {
		let prefix = 'http://localhost:8080/api/proizvod';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.add = (data) => {
			return $http.post(`${prefix}/`, data);
		};
	});