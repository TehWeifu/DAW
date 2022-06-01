const editBtn = document.querySelector(".js_editBtn")
const deleteBtn = document.querySelector(".js_deleteBtn")

deleteBtn.addEventListener("click", evt => {
    let idsToDelete = [];

    document.querySelectorAll(".chkBox").forEach(item => {
        if (item.checked) idsToDelete.push(item.value)
    })

    let currentUrl = location.protocol + '//' + location.host + location.pathname;
    let newUrl = currentUrl + "?del"

    for (const id of idsToDelete) {
        newUrl += `&delArr[]=${id}`
    }
    window.location.href = newUrl
})


editBtn.addEventListener("click", evt => {
    let idToEdit = document.querySelector(".chkBox:checked").value;

    let currentUrl = location.protocol + '//' + location.host + location.pathname;

    window.location.href = currentUrl + `?edit&idx=${idToEdit}`
})
