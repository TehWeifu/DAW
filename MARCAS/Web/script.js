'use strict'

let cookiesDiv = document.querySelector('#cookies')
let cookiesBtn = document.querySelector('#cookies button')

setTimeout(() => {
    cookiesDiv.style.width = "50%";
    Array.from(cookiesDiv.children).forEach(child => {
        setTimeout(() => {
            child.style.display = "block"
            setTimeout(() => child.style.opacity = "1", 500)
        }, 2000)
    })
}, 1000)

cookiesBtn.addEventListener('click', () => {
    cookiesDiv.style.display = "none"
})
