'use strict';

angular.module('app')
	.config(function($stateProvider, $urlRouterProvider) {
		$stateProvider
			.state({
				name: 'home',
				redirectTo: 'linkA',
				url: '/',
			})
			.state({
				name: 'linkA',
				url: '/link-a',
				template: '<h1>Link A</h1>'
			})
			.state({
				name: 'linkB',
				url: '/link-b',
				template: '<h1>Link B</h1>'
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
