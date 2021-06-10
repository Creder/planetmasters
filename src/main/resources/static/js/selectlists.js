(async() => {
    async function getAllPlanets() {
        const url = "/planets/getall";

        const response = await fetch(url);
        return response.json();
    }

    const planets = await getAllPlanets();
    const selectPlanet = document.getElementById("select-planet");

    planets.forEach(planet => {
        let newOption = document.createElement('option');
        newOption.setAttribute("value", planet.name);
        newOption.innerText = planet.name;
        selectPlanet.appendChild(newOption);

    });

    async function getAllMasters() {
        const url = "/masters/getall";

        const response = await fetch(url);
        return response.json();

    }

    const allmasters = await getAllMasters();
    const selectMaster = document.getElementById("select-master");

    allmasters.forEach(master => {
        let newOption = document.createElement('option');
        newOption.setAttribute("value", master.name);
        newOption.innerText = master.name;
        selectMaster.appendChild(newOption);
    });
})();

function sendData() {
    const XHR = new XMLHttpRequest();

    const FD = new FormData( form );

    XHR.open( "POST", "/planets/setMaster" );

    XHR.send( FD );

    XHR.onreadystatechange = function () {
        if (XHR.readyState === XMLHttpRequest.DONE) {
            if (XHR.status === 200) {
                    document.getElementById("status").innerText = XHR.response;
            } else {
                console.log('Something went wrong..!!');
            }
        }
    }
}

const form = document.getElementById( "form" );

form.addEventListener( "submit", function ( event ) {
    event.preventDefault();

    sendData();
} );