let original = true;

let eyes1 = document.querySelector("#contenedor2 .ojos1")
let eyes2 = document.querySelector("#contenedor2 .ojos2")

document.getElementById('contenedor2').addEventListener("click", switchPlaces);

function switchPlaces() {
    if (original) {
        eyes1.style.animation = "goAhead 2s cubic-bezier(0, 2.03, 1, -0.52)"
        eyes1.style.left = "80%"

        eyes2.style.animation = "goBack 2s cubic-bezier(0, 2.03, 1, -0.52)"
        eyes2.style.left = "20%"
    } else {
        eyes1.style.animation = "goBack 2s cubic-bezier(0, 2.03, 1, -0.52)"
        eyes1.style.left = "20%"

        eyes2.style.animation = "goAhead 2s cubic-bezier(0, 2.03, 1, -0.52)"
        eyes2.style.left = "80%"
    }

    original = !original;
}