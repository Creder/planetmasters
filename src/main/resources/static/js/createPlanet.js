function sendPlanet() {
    const XHR = new XMLHttpRequest();

    const FD = new FormData( planetForm );

    XHR.open( "POST", "/planets/save" );

    XHR.send( FD );

    XHR.onreadystatechange = function () {
        if (XHR.readyState === XMLHttpRequest.DONE) {
            if (XHR.status === 200) {
                document.getElementById("planet-status").innerText = XHR.response;
            } else {
                console.log('Something went wrong..!!');
            }
        }
    }
}

const planetForm = document.getElementById( "planet-form" );

planetForm.addEventListener( "submit", function ( event ) {
    event.preventDefault();

    sendPlanet();
} );