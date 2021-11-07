'use strict'

let cookiesDiv = document.querySelector('#cookies')
let cookiesBtn = document.querySelector('#cookies button')

let cookiesAccepted = Boolean(window.localStorage.getItem("cookiesAccepted"))
console.log(cookiesAccepted)

cookiesBtn.addEventListener('click', () => {
    cookiesDiv.style.display = "none"
    window.localStorage.setItem('cookiesAccepted', "true")
})

displayCookiesAgreement()

function displayCookiesAgreement() {
    if (!cookiesAccepted) {

        setTimeout(() => {
            cookiesDiv.style.width = "50%";
            Array.from(cookiesDiv.children).forEach(child => {
                setTimeout(() => {
                    child.style.display = "block"
                    setTimeout(() => child.style.opacity = "1", 500)
                }, 2000)
            })
        }, 1000)
    } else {
        cookiesDiv.style.display = "none"
    }
}
