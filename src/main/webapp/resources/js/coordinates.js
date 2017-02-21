
counter = 3;
var map;
function initMap(position, zoom) {
    if (position == null) {
        var tempPosition = {lat: 50.4501, lng: 30.5234};
        map = new 	google.maps.Map(document.getElementById('map'), {
            center: tempPosition,
            zoom: 6
        });
    } else {
        map = new google.maps.Map(document.getElementById('map'), {
            center: position,
            zoom: zoom
        });
    }

}


function forward() {

    addMarkerById(++counter)

}

function backward() {
    if (counter === 3) {
        console.log('counter === 3');
        counter++;
        return;
    }

    addMarkerById(--counter);
}


function getAllMarkers() {

    initMap();

    $.getJSON('/maxPlaceId', function (maxPlaceId) {

        for (var id = 4; id < maxPlaceId; id++) {
            $.getJSON('/coordinates/' + id, function (data) {
                $.each(data, function () {
                    var latLng = {lat: data.placeGeoLat, lng: data.placeGeoLong};
                    console.log(latLng);
                    // Creating a marker and putting it on the map
                    var marker = new google.maps.Marker({
                        position: latLng,
                        map: map,
                    });
                });
            });

        }
    });
}

function getRandomPlace() {
    $.getJSON('/maxPlaceId', function (maxPlaceId) {
        var randomNumber = Math.floor(Math.random() * maxPlaceId) + 3;

        console.log('Random number is ' + randomNumber);
        addMarkerById(randomNumber);
    });
}


function addMarkerById(id) {
    $.getJSON('/coordinates/' + id, function (data) {

        if (data === null) {
            counter++;
            alert("DATA NULL");
            return;
        }


        var lat = data.placeGeoLat;
        var lng = data.placeGeoLong;
        var place = data.placeName;

        var infowindow = new google.maps.InfoWindow({
            content: place
        });

        params = {lat, lng};

        console.log(params);
        console.log(place);

        initMap(params, 14);

        var marker = new google.maps.Marker({
            position: params,
            map: map
        });
        marker.addListener('click', function () {
            infowindow.open(map, marker);
        })
    });
}
