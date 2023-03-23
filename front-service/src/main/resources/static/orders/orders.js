angular.module('market').controller('ordersController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:5555/core/';

    $scope.loadOrdersItemDtos = function () {
        $http.get(contextPath + 'api/v1/orders').then(function (response) {
            let itemDtos = [];
            response.data.map((order) => {
                itemDtos = itemDtos.concat(order.itemDtos);
            });
            $scope.itemDtos = itemDtos;
        });
    };

    $scope.addFeedback = function () {
        $scope.feedback.productId = 1
        $http.post(contextPath + 'api/v1/feedback', $scope.feedback).then(function (response){
            $localStorage.feedback = {commentText: $scope.feedback.commentText, grade: $scope.feedback.grade, productId: 1};
            console.log("1 = ", $scope.feedback)
        });
    };

    $scope.loadOrdersItemDtos();
});