(async() => {
    async function getAllPlanets() {
        const url = "/planets/getall";

        const response = await fetch(url);
        return response.json();

    }

    const planets = await getAllPlanets();
    const planetList = document.getElementById("planets");

    planets.forEach(planet => {
        let newElement = document.createElement('div');
        let planetName = document.createElement('p');
        let newLink = document.createElement('a');

        newLink.href = "/planets/destroy/"+planet.name;
        newLink.innerText = "destroy";
        if(planet.master == null){
            planetName.innerText = planet.name+" Don't have master";
        }
        else{
            planetName.innerText = planet.name+ " Master:" +planet.master.name ;
        }


        newElement.appendChild(planetName);
        newElement.appendChild(newLink);

        planetList.appendChild(newElement);
    });

    async function getLazyMasters() {
        const url = "/masters/getlazymasters";

        const response = await fetch(url);
        return response.json();

    }

    const masters = await getLazyMasters();
    const lazymastersList = document.getElementById("lazy-masters");

    masters.forEach(master => {
        let newElement = document.createElement('div');
        let masterName = document.createElement('p');


        masterName.innerText = master.name;

        newElement.appendChild(masterName);

        lazymastersList.appendChild(newElement);
    });


    async function getTenYoungestMasters() {
        const url = "/masters/top";

        const response = await fetch(url);
        return response.json();

    }

    const yongestmasters = await getTenYoungestMasters();
    const youngestmastersList = document.getElementById("top-ten-youngest-masters");

    yongestmasters.forEach(master => {
        let newElement = document.createElement('div');
        let masterName = document.createElement('p');


        masterName.innerText = master.name+" "+master.age;

        newElement.appendChild(masterName);

        youngestmastersList.appendChild(newElement);
    });

})();









