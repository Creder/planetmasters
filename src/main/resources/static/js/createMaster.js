function sendMaster() {
    const XHR = new XMLHttpRequest();

    const FD = new FormData( masterForm );

    XHR.open( "POST", "/masters/save" );

    XHR.send( FD );

    XHR.onreadystatechange = function () {
        if (XHR.readyState === XMLHttpRequest.DONE) {
            if (XHR.status === 200) {
                document.getElementById("master-status").innerText = XHR.response;
            } else {
                console.log('Something went wrong..!!');
            }
        }
    }
}

const masterForm = document.getElementById( "master-form" );

masterForm.addEventListener( "submit", function ( event ) {
    event.preventDefault();

    sendMaster();
} );