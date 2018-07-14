'use strict';

angular.module('core.jedinicamere')
	.service('JedinicaMereService', function($http) {
		let prefix = 'http://localhost:8080/api/jedinicamere';

		this.getAll = () => {
			return $http.get(`${prefix}/`);
		};
		this.add = (data) => {
			return $http.post(`${prefix}/`, data);
		};
	});