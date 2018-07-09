'use strict';

angular.module('app')
	.config(function($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state({
				name: 'home',
				redirectTo: 'cenovnici',
				url: '/',
			})
			.state({
				name: 'cenovnici',
				url: '/cenovnici',
				component: 'myCenovnikList'
			})
			.state({
				name: 'proizvodi',
				url: '/proizvodi',
				component: 'myProizvodList'
			})
			.state({
				name: 'linkC',
				url: '/link-c',
				template: '<h1>Link C</h1>'
			})
			.state({
				name: 'error',
				url: '/error',
				template: '<h1>Error 404</h1>'
			});

		$urlRouterProvider
			.when('', '/')
			.otherwise('/error');
	});
